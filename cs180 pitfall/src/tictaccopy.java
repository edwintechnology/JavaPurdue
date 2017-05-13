import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private TicTacToe ttt;
	private JLabel status;
	private JPanel board, message;
	private JButton[] buttons;
	
	/**
	 * Constructor - creates a new instance of the tic tac toe object
	 * 
	 */
	public TicTacToeGUI()
	{
		ttt = new TicTacToe();
	}
	
	/**
	 *  start method kick starts the program's GUI
	 * 
	 *  
	 *  TODO:
	 *  creates the panels for board and message.
	 *  set title to Tic Tac Toe
	 *  set the size of the window to 300 x 300
	 *  add the board and message to the content pane of the frame
	 *  
	 *  pack()
	 *  setVisible(true)
	 */
	public void start()
	{
		board = createBoard();
		message = createStatus();
		
		setTitle("Simple GUI - Tic Tac Toe");
		setPreferredSize(new Dimension(300, 300));
		getContentPane().add(board, BorderLayout.CENTER);
		getContentPane().add(message, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel createBoard()
	{
		JPanel b = new JPanel(new GridLayout(3,3));
		buttons = new JButton[3 * 3];
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				JButton button = new JButton("");
				int id = i * 3 + j;
				button.setActionCommand(Integer.toString(id));
				button.addActionListener(this);
				buttons[i * 3 + j] = button;
				b.add(button);
			}
		}
		return b;
	}

	/**
	 * 
	 * @return
	 */
	private JPanel createStatus()
	{
		JPanel m = new JPanel();
		m.setPreferredSize(new Dimension(300, 25));
		status = new JLabel("");
		m.add(status);
		
		return m;
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = Integer.parseInt(e.getActionCommand());
		boolean marked = ttt.mark(index);
		
		if(marked){
			int turn = ttt.getTurn();
			if(turn % 2 == 0)
				buttons[index].setBackground(Color.BLUE);
			else
				buttons[index].setBackground(Color.RED);
			changeStatusText(index, turn);
			
			if(ttt.checkForWinners()){
				
				int player = 0;
				if(turn % 2 == 0)
					player = 2;
				else
					player = 1;
				
				JOptionPane.showMessageDialog(this, "Awesome: Player " + player + " wins!");
				removeAllActionListeners();
			}
			else if(ttt.isFull())
			{
				JOptionPane.showMessageDialog (this, "Awe, Draw!");
				removeAllActionListeners();
			}
		}
	}

	/**
	 * 
	 */
	public void removeAllActionListeners()
	{
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				buttons[i * 3 + j].removeActionListener(this);
	}
	
	/**
	 * 
	 * @param index
	 * @param turn
	 */
	private void changeStatusText(int index, int turn)
	{
		int player = 0;
		if(turn % 2 == 0)
			player = 2;
		else
			player = 1;
		
		String text = "Player " + player + " played: ";
		
		switch(index){
		case 0: text += " Top Left Corner"; break;
		case 1: text += " Top Center"; break;
		case 2: text += " Top Right Corner"; break;
		case 3: text += " Middle Left"; break;
		case 4: text += " Middle Center"; break;
		case 5: text += " Middle Right"; break;
		case 6: text += " Bottom Left Corner"; break;
		case 7: text += " Bottom Center"; break;
		case 8: text += " Bottom Right Corner"; break;
		}
		status.setText(text);
	}	
	
	/** Testing Method
	 * 
	 *  this method makes sure the tic tac toe works
	 */
	public void test()
	{
		System.out.println();
		ttt.printBoard();
		
		ttt.mark(0 * 3 + 2);
		if(ttt.checkForWinners()){
			System.out.printf("Awesome");
		}
		System.out.println();
		ttt.printBoard();
		
		ttt.mark(1* 3 + 0);
		if(ttt.checkForWinners()){
			System.out.printf("Awesome");
		}
		System.out.println();
		ttt.printBoard();
		
		ttt.mark(1* 3 + 2);
		if(ttt.checkForWinners()){
			System.out.printf("Awesome");
		}
		System.out.println();
		ttt.printBoard();
		
		ttt.mark(0* 3 + 0);
		if(ttt.checkForWinners()){
			System.out.printf("Awesome");
		}
		System.out.println();
		ttt.printBoard();
		
		ttt.mark(2* 3 + 2);
		if(ttt.checkForWinners()){
			System.out.printf("Awesome");
		}
		System.out.println();
		ttt.printBoard();
	}
}