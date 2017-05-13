import java.util.*;
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class Pitfall extends JFrame implements ActionListener{ 
	private static final long serialVersionUID = 1L;
	private static final int SENTINEL = -1; 
	private static int[][] pitfall; 
	public static int width; 
	public static int height; 
	private static Vector<Integer> xGuys = new Vector<Integer>();  
	private static Vector<Integer> yGuys = new Vector<Integer>();
	private JFrame frame = new JFrame("CS180 - Pitfall Java");
	private JButton[][] buttons;
	private JTextField wText;
	private JTextField hText;
	private JButton Backward;
	private JButton Validate;
	private JButton Forward;
	private Container pane = frame.getContentPane();
	private static final int xStart = 0; 
	private static final int yStart = 0;
	private static int movement;
	public static boolean problemSolver(int m, int n){	
		int counter = 0;
		pitfall[m][n] = SENTINEL;
		xGuys.add(m);
		yGuys.add(n);
		for(int i = 0; i < pitfall.length; i++)	{ 
			for(int j = 0; j < pitfall[i].length; j++){
				if(pitfall[i][j] == SENTINEL){ counter++; }
			}
		}
		if(counter == height*width){return true;}
		theMove(m-2,n-1);/** this is for the UP and LEFT */
		theMove(m-2,n+1);/** this is for the UP and RIGHT */
		theMove(m+2,n-1);/** this is for the DOWN and LEFT */
		theMove(m+2,n+1);/** this is for the DOWN and RIGHT */
		theMove(m-1,n-2);/** this is for the LEFT and UP */
		theMove(m+1,n-2);/** this is for the LEFT and DOWN */                                                                                        
		theMove(m-1,n+2);/** this is for the RIGHT and UP */
		theMove(m+1,n+2);/** this is for the RIGHT and DOWN */
		if(xGuys.size() > counter){ return true; }
		pitfall[m][n] = 0;
		xGuys.remove(xGuys.size()-1);
		yGuys.remove(yGuys.size()-1);
		counter--;
		return false;
	}
	public static void theMove(int x, int y){
		if(x >= 0 && x < height){
			if(y >= 0 && y < width){
				if(pitfall[x][y] != SENTINEL){
					problemSolver(x,y);
				}
			}
		}
	}
	public void topBar(){
		JPanel topBar = new JPanel(new FlowLayout());
		topBar.setBackground(Color.BLACK);
		JLabel enteredWidth = new JLabel("<html><FONT COLOR=WHITE>Width</font>");
		wText = new JTextField("" + width, 3);
		topBar.add(enteredWidth);
		topBar.add(wText);
		JLabel enteredHeight = new JLabel("<html><FONT COLOR=WHITE>Height</font>");
		hText = new JTextField("" + height, 3);
		topBar.add(enteredHeight);
		topBar.add(hText);
		Validate = new JButton("<html><FONT COLOR=BLACK>Visualize Solution</font>");
		Validate.setActionCommand("Validate");
		Validate.addActionListener(this);
		topBar.add(Validate);
		pane.add(topBar, BorderLayout.NORTH);
	}
	public void botBar(){
		JPanel botBar = new JPanel(new FlowLayout());
		botBar.setBackground(Color.BLACK);
		Backward = new JButton("<html><FONT COLOR=BLACK>Backward</font>");
		Backward.setEnabled(false);
		Backward.setActionCommand("Backward");
		Backward.addActionListener(this);
		botBar.add(Backward);
		Forward = new JButton("<html><FONT COLOR=BLACK>Forward</font>");
		Forward.setEnabled(false);
		Forward.setActionCommand("Forward");
		Forward.addActionListener(this);
		botBar.add(Forward);
		pane.add(botBar, BorderLayout.SOUTH);
	}
	public void createBoard(int w, int h){
		buttons = new JButton[h][w];
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				JButton b = new JButton();
				b.setBackground(Color.BLACK);
				buttons[i][j] = b;
			}
		}
	}
	public void setBoard(int k, int l){
		JPanel panel = new JPanel(new GridLayout(l,k));
		pane.removeAll();
		for(int i = 0; i < l; i++){
			for(int j = 0; j < k; j++){
				panel.add(buttons[i][j]);
			}
		}
		pane.add(panel, BorderLayout.CENTER);
		topBar();
		botBar();
		frame.validate();
	}
	public void startGame(){
		createBoard(width, height);
		setBoard(width, height);
		movement = 0;
	}
	public void makeGui(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400, 400);
		topBar();
		frame.validate();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Validate")){
			width = Integer.parseInt(wText.getText().trim());
			height = Integer.parseInt(hText.getText().trim());
			if(width == 0 || height == 0){
				JOptionPane.showMessageDialog(frame, "Invalid puzzle dimensions (" + width + "," + height +")");
				return;
			}
			xGuys.removeAllElements();
			yGuys.removeAllElements();
			pitfall = new int[height][width];
			boolean t = problemSolver(xStart, yStart);
			startGame();
			if( t == false ){
				JOptionPane.showMessageDialog(frame, "No solution was found for the given board size.");
				return;
			}
			else{
				JOptionPane.showMessageDialog(frame, "A valid solution was found.\nUse the Forward and Backward buttons\nto step through the solution.");
			}			
			Forward.setEnabled(true);
		}
		else if(e.getActionCommand().equals("Backward")){
			movement--;
			if(movement <= 0)
			{
				Backward.setEnabled(false);
				movement = 0;
			}
			if(movement > width*height-1)
			{
				movement = (width*height)-1;
			}
			int x = xGuys.elementAt(movement);
			int y = yGuys.elementAt(movement);
			buttons[x][y].setBackground(Color.BLACK);
			Forward.setEnabled(true);
		}
		else if(e.getActionCommand().equals("Forward")){
			if(movement >= width*height-1)
			{
				Forward.setEnabled(false);
			}
			int x = xGuys.elementAt(movement);
			int y = yGuys.elementAt(movement);
			buttons[x][y].setBackground(Color.LIGHT_GRAY);
			movement++;
			Backward.setEnabled(true);
		}
	}
	public static void main( String args[] ){
		Pitfall game = new Pitfall();
		game.makeGui();
	}
}
