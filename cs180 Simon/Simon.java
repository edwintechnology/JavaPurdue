import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/* TODO 1
 *
 * Write the class declaration for Simon so that it inherits
 * from JFrame and provides all the methods listed in the
 * ActionListener interface.
 */
public class Simon extends JFrame implements ActionListener
{

    /* These JButtons represent the colored buttons on the Simon game. */
    JButton redButton;
    JButton blueButton;
    JButton greenButton;
    JButton yellowButton;

    /* These variables allow us to maintain game state in an event
     * driven programming environment. */
    String sequence; /* the current color sequence user is trying to match */
    int cur;         /* the user's position with the current sequence */
    boolean playing; /* whether or not the game is underway */
    String highScorer;
    int highScore;

    public Simon()
    {
        /* TODO 2
         *
         * Add a new WindowDestroyer object as the window listener
         * for this object. 
         * */
	 WindowDestroyer wd = new WindowDestroyer();
	addWindowListener(wd);
        /* here we initialize the state of the game */
        sequence = "";
        cur = 0;
        playing = false;
        highScorer = "";
        highScore = 0;

        setSize(500,500);
        setTitle("Simon");
        setVisible(true);

        /* TODO 3
         *
         * Get the content pane of this objecct and store
         * it in a Container named contentPane. Next, set
         * the layout of the content pane to BorderLayout.
         */
	 Container contentPane = getContentPane();
	 contentPane.setLayout(new BorderLayout());
        /* top is the Container for the Simon I/O */
        JPanel top = new JPanel();

        /* TODO 4
         *
         * Set the layout of the JPanel named top to a
         * GridLayout with 3 rows and 3 columns.
         */
	 top.setLayout(new GridLayout(3,3));
        redButton = new JButton("Red"); 
        redButton.setBackground(Color.red);

        blueButton = new JButton("Blue"); 
        blueButton.setBackground(Color.blue);

        greenButton = new JButton("Green"); 
        greenButton.setBackground(Color.green);

        yellowButton = new JButton("Yellow"); 
        yellowButton.setBackground(Color.yellow);

        /* TODO 5
         *
         * For red, blue, green, and yellow buttons,
         * add this as the action listener for the button.
         */ 
	 redButton.addActionListener(this);
	 blueButton.addActionListener(this);
	 greenButton.addActionListener(this);
	 yellowButton.addActionListener(this);
        /* TODO 6
         *
         * Add red, blue, green, and yellow buttons to
         * the JPanel top in order to have a display
         * like that in the lab webpage. In the spots
         * that do not represent a button on the Simon
         * board, just add a new JPanel() to fill in
         * the space.
         */
	 JPanel blank1 = new JPanel();
	 JPanel blank2 = new JPanel();
	 JPanel blank3 = new JPanel();
	 JPanel blank4 = new JPanel();
	 JPanel blank5 = new JPanel();
	 top.add(blank1);
	 top.add(redButton);
	 top.add(blank2);
	 top.add(blueButton);
	 top.add(blank3);
	 top.add(greenButton);
	 top.add(blank4);
	 top.add(yellowButton);
	 top.add(blank5);
	 
        contentPane.add(top, BorderLayout.CENTER);

        /* bottom is the Container for our control panel */
        JPanel bottom = new JPanel();

        /* TODO 7
         *
         * Set the layout of the JPanel named bottom to a
         * GridLayout with 1 row and 3 columns.
         */
	bottom.setLayout(new GridLayout(1,3));
        JButton start = new JButton("Start");
        bottom.add(start);

        JButton stop = new JButton("Stop");
        bottom.add(stop);

        JButton score = new JButton("High Score");
        bottom.add(score);

        /* TODO 8
         *
         * For start, stop, and high score buttons,
         * add this as the action listener for the button.
         */ 
	 start.addActionListener(this);
	 stop.addActionListener(this);
	 score.addActionListener(this);
        contentPane.add(bottom, BorderLayout.SOUTH);

        /* this call redraws the screen */
        update(getGraphics());
        repaint(); 
    }

    public void say()
    {
        Random rand = new Random();

        switch(rand.nextInt(4))
        {
            case 0: sequence += "R"; break;
            case 1: sequence += "B"; break;
            case 2: sequence += "G"; break;
            case 3: sequence += "Y"; break;
        }

        /* TODO 9
         *
         * Declare a JButton object named b and
         * a Color object named c. Initialize
         * both to null.
         */
	 JButton b = null;
	 Color c = null;
        for(int i=0; i<sequence.length(); i++)
        {
            switch(sequence.charAt(i))
            {
                case 'R':
                    b = redButton;
                    c = Color.red;
                    break;

                case 'B':
                    b = blueButton;
                    c = Color.blue;
                    break;

                case 'G':
                    b = greenButton;
                    c = Color.green;
                    break;

                case 'Y':
                    b = yellowButton;
                    c = Color.yellow;
                    break;
            }

            /* TODO 10
             *
             * Set the background of the JButton named b
             * to white.
             */
	     b.setBackground(Color.WHITE);
            update(getGraphics());
            try{ Thread.sleep(500); } catch(Exception e) { }

            /* TODO 10
             *
             * Set the background of the JButton named b
             * to the Color named c.
             */
	     b.setBackground(c);
            update(getGraphics());
            try{ Thread.sleep(500); } catch(Exception e) { }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String com;

        /* TODO 11
         *
         * Set com equal to the String representing the action 
         * command from the ActionEvent e.
         */ 
	 com = e.getActionCommand();
        if(com.equals("Start"))
        {
            playing = true;
            sequence = "";
            say();
        }
        else if(com.equals("Stop"))
        {
            playing = false;
            cur = 0;
        }
        else if(com.equals("High Score"))
        {
            /* TODO 12
             *
             * Create a JOptionPane that displays the
             * String highscorer and the int highscore.
             * Use the static method showMesssageDialog.
             * Check the Java API to learn more about
             * this useful method.
             */ 
	     JOptionPane.showMessageDialog(null, highScorer + " " + highScore);
        }
        else if(com.equals("Red"))
        {
            if(!playing) return;
            check('R');
        }
        else if(com.equals("Blue"))
        {
            if(!playing) return;
            check('B');
        }
        else if(com.equals("Green"))
        {
            if(!playing) return;
            check('G');
        }
        else if(com.equals("Yellow"))
        {
            if(!playing) return;
            check('Y');
        }
    }

    void check(char c)
    {
        assert(cur < sequence.length());

        /* TODO 13
         *
         * See if the character c passed in as a parameter
         * matches the character in the String sequence
         * at position cur.
         */ 
	if(c == sequence.charAt(cur))
        {
            /* TODO 14
             *
             * Increment cur.
             *
             * If cur is equal to the length of
             * sequence, then set cur to 0 and
             * call the say() method.
             */
	     cur++;
	     if(cur == sequence.length())
	     {
		     cur = 0;
		     say();
	     }
        }
        else
        {
            playing = false;
            cur = 0;
            int score = sequence.length();

            /* TODO 15
             *
             * Create a JOptionPane that displays the String
             * "Game Over. Score: " and the int named score 
             * declared above. Once again use showMessageDialog.
             */ 
	     JOptionPane.showMessageDialog(null, "Game Over. Score: " + score);
            if(score > highScore)
            {
                highScorer = JOptionPane.showInputDialog(null, "New High Score! Enter your name:");
                highScore = score;
            }
        }
    }

    public static void main(String args[])
    {
        new Simon();
    }

    /* TODO 16
     *
     * Write an inner class named WindowDestroyer that
     * inherits from the class WindowAdapter.
     */ 
    public class WindowDestroyer extends WindowAdapter
    {
        /* TODO 17
         *
         * Override the windowClosed method from the 
         * WindowAdapter class so that the window will
         * close with the "x" button is clicked.
         */
	 @Override public void windowClosing(WindowEvent e){
		 System.exit(0);
	 }
    }
}
