import java.awt.event.*;
import javax.swing.JFrame;

public class ChatWindowListener
	extends WindowAdapter
{
  private JFrame myframe;
  private ChatClient my_user;

  public ChatWindowListener(JFrame fr, ChatClient user)
  {
     super();
     myframe = fr;
     my_user = user;
  }

  public void windowClosing(WindowEvent e)
  {
    my_user.logout();
    myframe.dispose();
  }

}
