import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Vector;
import java.util.Scanner;

public class ChatClient
{
  public final static String SERVER_HOST = "gator.cs.purdue.edu";
  //public final static String SERVER_HOST = "localhost";
  //public final static String SERVER_HOST = "128.210.192.76";
  
  private String username;
  private boolean servlet_running;
  private Vector<String> users;
  private int port;
  private Thread servletThread;
  private ChatServlet cservlet;
  private ChatGUI mygui;
  private boolean loggedin;

  public ChatClient(ChatGUI cg)
  {
    this.mygui = cg;
    this.username = null;  //set upon login
    servlet_running = false;
    users = new Vector<String>();
    port = ChatServlet.INIT_PORT;
    loggedin = false;
  }

  public synchronized String loginWithName(String username)
  {
    if(!loggedin) {
      servletThread = new Thread(cservlet = new ChatServlet(this));
      servletThread.start();
      try { this.wait(); } catch(Exception ex) { ex.printStackTrace(); }

      try {
        StringMessage msg = new StringMessage(StringMessage.LOGIN, port + "", username, "server");
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        InetAddress ia = InetAddress.getByName(SERVER_HOST);
        DatagramSocket socket = new DatagramSocket();
        socket.connect(ia, 8888);
        //System.out.println("Sending a login packet...");
        socket.send(packet);
        try { this.wait(); } catch(Exception ex) { ex.printStackTrace(); }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return this.username;
  }
  
  public synchronized void loggedin()
  {
    if(!loggedin) this.notify();
    loggedin = true;
  }
  public Vector<String> getBuddies() { return users; }
  
  public void logout()
  {
    if(loggedin) {
      cservlet.closeSocket();
      servlet_running = false;
      if(servletThread != null)
        servletThread.interrupt();
      
      try {
        StringMessage msg = new StringMessage(StringMessage.LOGOUT, port + "", username, "server");
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        InetAddress ia = InetAddress.getByName(SERVER_HOST);
        DatagramSocket socket = new DatagramSocket();
        socket.connect(ia, 8888);
        //System.out.println("Sending a logout packet to server...");
        socket.send(packet);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      loggedin = false;
    }
  }

  public void addUser(String newuser)
  {
    System.out.println(newuser + " logged in");
    users.add(newuser);
    if(mygui != null) mygui.addUser(newuser);
  }

  public void removeUser(String user)
  {
    System.out.println(user + " logged out");
    users.remove(user);
    if(mygui != null ) mygui.removeUser(user);
  }
  
  public synchronized void start_servlet()
  {
    if(!servlet_running) this.notify();
    servlet_running = true;
  }
  public boolean servlet_running() { return servlet_running; }
  public int getPort() { return port; }
  public String getName() { return username; }
  public void setName(String newname) { username = newname; }
  public void setPort(int p) { port = p; }

  public void receive(String msg, String from)
  {
    if(mygui != null) mygui.receive(msg, from);
    System.out.println(from + "> " + msg);
  }
  
  public void send(String str, String to)
  {
    try {
      if(loggedin) {
        //System.out.println("sending sender, receiver, str: " + username + " " +  to + " " + str);
        StringMessage msg = new StringMessage(StringMessage.MSG, str, username, to);
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        InetAddress ia = InetAddress.getByName(SERVER_HOST);
        DatagramSocket socket = new DatagramSocket();
        socket.connect(ia, 8888);
        //System.out.println("Sending a message packet...");
        socket.send(packet);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    ChatClient user = new ChatClient(null);
    user.loginWithName(args[0]);

    Scanner sc = new Scanner(System.in);
    String str, name, msg;
    while(true)
    {
      str = sc.nextLine();
      if(str.equals("QUIT")) {
        user.logout();
        break;
      } else {
        name = str.substring(0, str.indexOf(',')).trim();
        msg = str.substring(str.indexOf(',') + 1, str.length()).trim();
        user.send(msg, name);
      }
    }
  }
}

class ChatServlet implements Runnable
{
  public final static int INIT_PORT = 7800;
  private final static int BUFSIZE = 500;
  private ChatClient user;
  private DatagramSocket ds;
  
  public ChatServlet(ChatClient user)
  {
    this.user = user;
  }

  public void closeSocket()
  {
    if(ds != null)
      ds.close();
  }
  
  public void run()
  {
    try { 
      int port = user.getPort();
      //System.out.println("listening on port: " + port);
      ds = new DatagramSocket(port);
      
      while (true) {
        byte buffer[] = new byte[BUFSIZE];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        //System.out.println("ds.receive...");
        user.start_servlet();
        try { ds.receive(dp); }
        catch (SocketException ex) { break; }
        //System.out.println("servlet received msg...");
        if(!user.servlet_running()) break;
        StringMessage msg = new StringMessage(dp.getData());
        // DEBUG System.out.println(msg);
        if(msg.getType() == StringMessage.MSG) {
          user.receive(msg.getMessage(), msg.getSender());
        } else if(msg.getType() == StringMessage.NEWUSER) {
          user.addUser(msg.getMessage());
        } else if(msg.getType() == StringMessage.CHANGEPORT) {
          ds.close();
          int newport = Integer.parseInt(msg.getMessage());
          user.setPort(newport);
          //System.out.println(user.getName() + ": " + newport);
          ds = new DatagramSocket(newport);
          user.loggedin();
        } else if(msg.getType() == StringMessage.ASSIGNNAME) {
          //System.out.println("assigning name: " + msg.getMessage());
          user.setName(msg.getMessage());
        } else if(msg.getType() == StringMessage.LOGOUT) {
          user.removeUser(msg.getMessage());
        } else if(msg.getType() == StringMessage.PING) {
          //Send PING message back to server
          int pingport = Integer.parseInt(msg.getMessage());
          StringMessage ping = new StringMessage(StringMessage.PING, "", user.getName(), "fd");
          byte[] pingbuffer = ping.getBytes();
          DatagramPacket packet = new DatagramPacket(pingbuffer, pingbuffer.length);
          InetAddress ia = InetAddress.getByName(ChatClient.SERVER_HOST);
          DatagramSocket socket = new DatagramSocket();
          socket.connect(ia, pingport);
          socket.send(packet);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
