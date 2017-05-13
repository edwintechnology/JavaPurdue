import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/*
 * TODO 1:  Convert this Swing program into a Java applet.  If you brought your book,
 *          this should be really easy.
 */
public class Simon extends JApplet implements ActionListener
{
    JButton redButton;
    JButton blueButton;
    JButton greenButton;
    JButton yellowButton;

    String sequence;
    int cur;
    boolean playing;
    String highScorer;
    int highScore;

    public Simon()
    {
        super();
       // addWindowListener(new WindowDestroyer());

        sequence = "";
        cur = 0;
        playing = false;
        highScorer = "";
        highScore = 0;

       // setSize(500,500);
       // setTitle("Simon");
        setVisible(true);

        /* contentPane is the Container for entire window. */
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        /* top is the Container for the Simon I/O */
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3,3));

        redButton = new JButton("Red"); 
        redButton.setBackground(Color.red);
        redButton.addActionListener(this);

        blueButton = new JButton("Blue"); 
        blueButton.setBackground(Color.blue);
        blueButton.addActionListener(this);

        greenButton = new JButton("Green"); 
        greenButton.setBackground(Color.green);
        greenButton.addActionListener(this);

        yellowButton = new JButton("Yellow"); 
        yellowButton.setBackground(Color.yellow);
        yellowButton.addActionListener(this);

        top.add(new JPanel());
        top.add(redButton);
        top.add(new JPanel());
        top.add(blueButton);
        top.add(new JPanel());
        top.add(greenButton);
        top.add(new JPanel());
        top.add(yellowButton);
        top.add(new JPanel());

        contentPane.add(top, BorderLayout.CENTER);

        /* bottom is the Container for our control panel */
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,3));

        JButton start = new JButton("Start");
        start.addActionListener(this);
        bottom.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(this);
        bottom.add(stop);

        JButton score = new JButton("High Score");
        score.addActionListener(this);
        bottom.add(score);

        contentPane.add(bottom, BorderLayout.SOUTH);

        update(getGraphics());
        repaint();
        update(getGraphics());
        repaint();
        this.paint(getGraphics());
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

            b.setBackground(Color.white);
            update(getGraphics());
            try{ Thread.sleep(500); } catch(Exception e) { }
            b.setBackground(c);
            update(getGraphics());
            try{ Thread.sleep(500); } catch(Exception e) { }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String com = e.getActionCommand();

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
            JOptionPane.showMessageDialog(null, 
                "High Scorer: " + highScorer + "\n" +
                "High Score: " + highScore);
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
        if(sequence.charAt(cur) == c)
        {
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
            JOptionPane.showMessageDialog(null, "Game Over. Score: " + score);
            if(score > highScore)
            {
                highScorer = JOptionPane.showInputDialog(null, "New High Score! Enter your name:");
                highScore = score;
            }
        }
    }
    public void init()
    {
        new Simon();
    }

    class WindowDestroyer extends WindowAdapter
    {
        public void windowClosing(WindowEvent e) { System.exit(0); }
    }
}
