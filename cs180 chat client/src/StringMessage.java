
public class StringMessage
{
  public static final int LOGIN      = 1;
  public static final int LOGOUT     = 2;
  public static final int MSG        = 3;
  public static final int NEWUSER    = 4;
  public static final int CHANGEPORT = 5;
  public static final int PING       = 6;
  public static final int ASSIGNNAME = 7;
  
  private int msgtype;
  private String to;
  private String from;
  private String msg;
  
  public StringMessage(int msgtype, String msg, String from, String to)
  {
    this.msgtype = msgtype;
    this.msg = msg;
    this.from = from;
    this.to = to;
  }

  public StringMessage(byte[] bytes)
  {
    String bytestring = new String(bytes);
    this.msgtype = Integer.parseInt(bytestring.substring(0, bytestring.indexOf('*')).trim());
    int index1 = bytestring.indexOf('*');
    int index2 = bytestring.indexOf('*', index1+1);
    int index3 = bytestring.indexOf('*', index2+1);
    this.msg = bytestring.substring(index1+1, index2).trim();
    this.from = bytestring.substring(index2+1, index3).trim();
    this.to = bytestring.substring(index3 + 1, bytestring.length()).trim();
  }

  public byte[] getBytes()
  {
    String bytestring;
    bytestring = msgtype + "*" + msg + "*" + from + "*" + to;
    return bytestring.getBytes();
  }

  public int getType() { return this.msgtype; }
  public String getMessage() { return this.msg; }
  public String getSender() { return this.from; }
  public String getReceiver() { return this.to; }
}
