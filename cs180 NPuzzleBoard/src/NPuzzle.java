/*
 * NPuzzle.java
 *
 * You should not have to modify anything in this file, though you may if you find it necessary.
 */

import java.util.Scanner;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
//import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class NPuzzle {
    
    private NPuzzleBoard board;
    JFrame frame;
    JButton[][] buttons;
    int movesTaken;
    
    /**
     * Creates a new instance of NPuzzle
     */
    public NPuzzle() {}
    
    /**
     * play method
     */
    public void playViaGUI() {
        // setup the GUI
        setupGUI();
    }
    
    /**
     * GUI setup
     */
    public void setupGUI() {
        // setup frame
        frame = new JFrame("CS180 N-Puzzle");
        frame.setSize(512, 512);
        frame.setLocation(128,128);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        // setup menu
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item = new JMenuItem("New Game");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        menu.add(item);
        item = new JMenuItem("Change Puzzle Size");
        item.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
                String dimstr = JOptionPane.showInputDialog(frame,"New puzzle size (currently "+ NPuzzleBoard.DIMENSION+"):");
                try {
                    int newsize = Integer.parseInt(dimstr);
					if (newsize > 1) {
						board.DIMENSION = newsize;
						startGame();
					}
                } catch (Exception ex) {}
            }
        });
        menu.add(item);
        item = new JMenuItem("Change Scramble Moves");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = JOptionPane.showInputDialog(frame,"New number of scramble moves (currently "+NPuzzleBoard.SCRAMBLE_MOVES+"):");
                try {
                    int newmoves = Integer.parseInt(str);
					if (newmoves >= 0)
						NPuzzleBoard.SCRAMBLE_MOVES = newmoves;
                } catch (Exception ex) {}
            }
        });
        menu.add(item);
        item = new JMenuItem("Exit");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        menu.add(item);
        bar.add(menu);
        frame.setJMenuBar(bar);
        frame.validate();
    }
    
    /**
     * start a new game
     */
    public void startGame() {
        movesTaken = 0;
        createBoard(NPuzzleBoard.DIMENSION);
        setTiles();
        if (board.solved()) {
            JOptionPane.showMessageDialog(frame, "WINNER!!! ("+movesTaken+" move(s))");
            setButtons(false);
        }
    }
    
    /**
     * generate a fresh board for a new game
     */
    public void createBoard(int dim) {
        board = new NPuzzleBoard(dim);
        buttons = new JButton[dim][dim];
        for (int i=0; i<dim; i++) {
            for (int j=0; j<dim; j++) {
                JButton b = new JButton("?");
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton)e.getSource();
                        int dir = board.findDirectionFromBlank(Integer.parseInt(b.getText()));
                        if (board.move(dir)) {
                            movesTaken++;
                            setTiles();
                        }
                        if (board.solved()) {
                            JOptionPane.showMessageDialog(frame, "WINNER!!! ("+movesTaken+" move(s))");
                            setButtons(false);
                        }
                    }
                });
                buttons[i][j] = b;
            }
        }
    }
    
    /**
     * updates the tiles to correspond to the board
     */
    public void setTiles() {
        int dim = NPuzzleBoard.DIMENSION;
        int x = board.getBlankX();
        int y = board.getBlankY();
        Container pane = frame.getContentPane();
        pane.removeAll();
        JPanel panel = new JPanel(new GridLayout(dim,dim));
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        panel.setBorder(raisedetched);
        for (int i=0; i<dim; i++)
            for (int j=0; j<dim; j++) {
                int num = board.getNumberAtCoordinate(i,j);
                buttons[i][j].setText(""+num);
                if (num != NPuzzleBoard.BLANK)
                    panel.add(buttons[i][j]);
                else
                    panel.add(new JLabel(""));
            }
        pane.add(panel, BorderLayout.CENTER);
        JPanel footer = new JPanel();
        footer.add(new JLabel("Moves taken:  "+movesTaken));
        pane.add(footer, BorderLayout.SOUTH);
        
        frame.validate();
    }
    
    /**
     * sets each button to the state provided
     */
    public void setButtons(boolean state) {
        int dim = NPuzzleBoard.DIMENSION;
        for (int i=0; i<dim; i++)
            for (int j=0; j<dim; j++)
                buttons[i][j].setEnabled(state);
    }
    
    /**
     * the main method
     */
    public static void main(String[] args) {
        NPuzzle game = new NPuzzle();
        game.playViaGUI();
    }
}
