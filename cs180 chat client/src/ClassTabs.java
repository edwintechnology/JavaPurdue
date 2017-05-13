import javax.swing.*;
import java.awt.*;

public class ClassTabs{
	public JTabbedPane tabbed;
	public String user;
	public JTextField jtf;
	public JTextArea jta;
	public JPanel total;
	public JButton send = new JButton("Send");
	public JButton close = new JButton("Close");
	public ClassTabs(String user){
		JFrame frame = new JFrame();
		frame.setSize(200, 500);
		tabbed = new JTabbedPane();
		jtf = new JTextField("", 35);
		jta = new JTextArea("", 50, 50);
		this.user = user;
		Container pane = frame.getContentPane();
		JPanel top = new JPanel();
		@SuppressWarnings("unused")
		JPanel center = new JPanel();
		JPanel bot = new JPanel();
		jtf.setActionCommand("send");
		send.setActionCommand("send");
		close.setActionCommand("close");
		bot.add(send);
		bot.add(close);
		top.add(jtf);
		JScrollPane scroller = new JScrollPane(jta);
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		scroller.setPreferredSize(new Dimension(250,300));
		total = new JPanel();
		total.setLayout(new BoxLayout(total, BoxLayout.PAGE_AXIS));
		total.add(top);
		total.add(scroller);
		total.add(bot);
		pane.add(total);
		}	
}
