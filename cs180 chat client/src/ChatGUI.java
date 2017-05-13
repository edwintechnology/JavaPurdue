/** Dustin Wolf Cs180 Project8 Chat client GUI */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.util.*;

public class ChatGUI extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	public Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	public ChatClient c = new ChatClient(this);
	public Container bListPane = getContentPane();
	public SortedListModel model = new SortedListModel();
	public JList names = new JList(model);
	public JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	// buttons /////////////////////////////////////////
	public JButton login = new JButton("Login");
	public JButton logout = new JButton("Logout");
	public JButton newChat = new JButton("Start New Chat");
	public JButton send = new JButton("Send");
	public JButton closeButton = new JButton("Close");
	///////////////////////////////////////////////////
	public String loggedInUserName = "";
	public int counter;
	public Vector<ClassTabs> classVector = new Vector<ClassTabs>();
	public String s = "";
	public ClassTabs ct = new ClassTabs(s);
	public JTabbedPane tab = new JTabbedPane();
	// menu items /////////////////////////////////////
	public JMenuItem log;
	public JMenuItem out;
	public JMenuItem newS;
	public JMenuItem size;
	///////////////////////////////////////////////////
	public static void main(String args[]){
		ChatGUI chat = new ChatGUI();
		chat.runClient();
	}
	public void runClient(){
		frameSetup();
	}
	public void frameSetup(){
		setSize(625,500);
		setLocation(200,200);
		setTitle("Chat Client");
		// adds window listener to allow logout and closure
		ChatWindowListener cwl = new ChatWindowListener(this, c);
		addWindowListener(cwl);
		counter = 0;
		setVisible(true);
		menuSetup();
		leftSide();
	}
	public void menuSetup(){
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		log = new JMenuItem("Login");
		log.setActionCommand("in");
		log.addActionListener(this);
		menu.add(log);
		out = new JMenuItem("Logout");
		out.setActionCommand("out");
		out.addActionListener(this);
		menu.add(out);
		newS = new JMenuItem("Start New Chat");
		newS.setActionCommand("new");
		newS.addActionListener(this);
		menu.add(newS);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(this);
		menu.add(exit);
		// adds to the actual bar
		bar.add(menu);
		setJMenuBar(bar);
	}		
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("in")){ // for the login button
			loggedInUserName = JOptionPane.showInputDialog(this, "Please Enter User Name", "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
			
			while(loggedInUserName.equals("")){ // keeps prompting if its empty
					loggedInUserName = JOptionPane.showInputDialog(this, "Please Enter User Name", "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
					if(loggedInUserName == null)
						return;
			}
				loggedInUserName = c.loginWithName(loggedInUserName);
				setTitle("Chat Client: " + loggedInUserName);
				login.setEnabled(false);
				logout.setEnabled(true);
				newChat.setEnabled(true);	
				log.setEnabled(false);
				out.setEnabled(true);
				newS.setEnabled(true);
		}
		else if(e.getActionCommand().equals("out")){ // logout button
			counter = 0;
			setTitle("Chat Client");
			c.logout();
			model.clear();
			tab.removeAll();
			login.setEnabled(true);
			logout.setEnabled(false);
			newChat.setEnabled(false);
			log.setEnabled(true);
			out.setEnabled(false);
			newS.setEnabled(false);
		}
		else if(e.getActionCommand().equals("new")){
			// gets the name of the selection of the list
			int index = names.getSelectedIndex();
			String stringy = (String)model.getElementAt(index);
			int x = tab.indexOfTab(stringy);
			// then gets the string at that position 
			makeTab(stringy);
			ct.tabbed.setBorder(raisedetched);
			bListPane.add(jsp);
			validate();
			if(x == 0){ return; }
		}
		else if(e.getActionCommand().equals("send")){
			int index = tab.getSelectedIndex();
			ct = classVector.get(index);
			String s = ct.user;
			String IM = ct.jtf.getText();
			c.send(IM, s);
			ct.jta.append(loggedInUserName + ": " + IM + "\n");
			ct.jtf.setText("");
		}
		else if(e.getActionCommand().equals("close")){
			int index = tab.getSelectedIndex();
			ct = classVector.get(index);
			tab.remove(ct.total);
			classVector.remove(ct);
		}
		else if(e.getActionCommand().equals("exit")){
			c.logout();
			dispose();
		}
	}
	public void makeTab(String usersName){
		// ct is a class objec that contains the makings for the im box
		@SuppressWarnings("unused")
		JPanel Buttons = new JPanel();
		ct = new ClassTabs(usersName);
		ct.send.addActionListener(this);
		ct.close.addActionListener(this);
		ct.jtf.addActionListener(this);
		classVector.add(ct);
		tab.add(usersName, ct.total); // right blue box
		tab.setBorder(raisedetched);
		jsp.setRightComponent(tab); // over all board with gridlayout
		validate();
	}
	public void leftSide(){
		JPanel bTop = new JPanel();
		JScrollPane scroller = new JScrollPane(bTop);
		scroller.setPreferredSize(new Dimension(225,350));
		scroller.setAlignmentX(LEFT_ALIGNMENT);
		JPanel left = new JPanel();
		bTop.setBackground(Color.WHITE);
		bTop.add(names);
		login.setActionCommand("in");
		logout.setActionCommand("out");
		newChat.setActionCommand("new");
		login.addActionListener(this);
		logout.addActionListener(this);
		newChat.addActionListener(this);
		login.setAlignmentX(CENTER_ALIGNMENT);
		logout.setAlignmentX(CENTER_ALIGNMENT);
		newChat.setAlignmentX(CENTER_ALIGNMENT);
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(login);
		buttons.add(logout);
		buttons.add(newChat);
		buttons.setBorder(raisedetched);
		left.add(scroller, BorderLayout.NORTH);
		left.add(buttons, BorderLayout.SOUTH);
		logout.setEnabled(false);
		newChat.setEnabled(false);
		out.setEnabled(false);
		newS.setEnabled(false);
		jsp.setDividerLocation(250);
		jsp.setLeftComponent(left);
		jsp.setRightComponent(tab);
		bListPane.add(jsp);
		validate();
	}
	public void addUser(String user){
		counter = model.getSize();
		model.add(user);
		names.setSelectedIndex(counter);
		names.ensureIndexIsVisible(counter);
	}
	public void removeUser(String user){
		model.removeElement(user);
	}
	public void receive(String message, String fromName){ // needs work
		int index = tab.indexOfTab(fromName);
		if(index == -1){
			makeTab(fromName);
			ct.jta.append(fromName + ": " + message + "\n");
		}
		else{
			ct = classVector.get(index);
			ct.jta.append(fromName + ": " + message + "\n");
		}
	}
}
