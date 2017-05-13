import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;


public class BoxGUI extends JApplet implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private gamePiece gamePieceArray;
	
	private JTextField boxText;
	private JButton boxCount = new JButton("Enter Number of Boxes");
	private JLabel cent = new JLabel("Box The Bull!");
	private JPanel title = new JPanel(new GridLayout(1,1));
	private JPanel space1 = new JPanel(new GridLayout(1,1));
	private JPanel space2 = new JPanel(new GridLayout(1,1));
	private JPanel buttons = new JPanel(new GridLayout(4,1));
	private Container pane = getContentPane();
	
	public void init(){
		pane.setBackground(Color.WHITE);
		createGUI();
	}
	public void createGUI(){
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
