/** Dustin Wolf */
/*
 * NPuzzleBoard.java
 *
 * Your task is to use arrays to complete this class.  You MUST fill in all the methods provided here.
 * You MUST use arrays.  You may add your own methods or other classes as necessary.
 */
import java.util.*;

public class NPuzzleBoard {
    // public state variables needed in NPuzzle
    public static int SCRAMBLE_MOVES = 50;  // the number of scrambles from the solution state to get a new game
    public static int DIMENSION = 4;        // the size of the puzzle
    public static final int BLANK = -1;     // the blank value - wherever the blank tile is, you should use this integer
                                            // value as a marker
    
    // put your additional class variables/constants here
    int[][] board;
    Random rand = new Random();
    /**
     * Creates a new instance of NPuzzleBoard which is dimension x dimension in size.  You may want to add to this
     * method to have it create the necessary data structures and default anything else you find necessary.  Creating
     * a new NPuzzleBoard should also scramble the starting state of the N-Puzzle game.  You may implement the provided
     * scramble() method below and call that method to do this, or you may make your own design decisions if you wish.
     */
    public NPuzzleBoard(int dimension) 
    {
        // allocate space for the board
        DIMENSION = dimension;
        board = new int[DIMENSION][DIMENSION]; // new array with bounds determined by Static variable.
        int h = 1; // the number for the tiles 
		for(int i = 0; i < board.length; i++) // For the row
		{
			for(int j = 0; j < board[i].length; j++) // For the column
			{				
				board[i][j] = h; 
				if(h == DIMENSION*DIMENSION) // last blank for any dimension
				{
					board[DIMENSION-1][DIMENSION-1] = BLANK;
				}
				h++;
			}
		} 
        scramble(); // calls method scramble
    }
    
    /**
     * Scrambles the board from the solution state to a beginning puzzle state.  The number
     * of scrambling moves is defined by SCRAMBLE_MOVES.  A move is valid only if successful.
     * That is, if your blank is on the top, moving up is NOT considered a move.  Note that
     * implementing this method is optional.  You only need to implement it if you plan on using
     * it.
     */
    private void scramble()
    {
	    int count = 1;
	    while(count < SCRAMBLE_MOVES)
	    {
		    int randomX = rand.nextInt(DIMENSION); // calls a random number for X
		    int randomY = rand.nextInt(DIMENSION); // and a random for Y
		    if(board[randomX][randomY] == BLANK)
		    {
			    // basically if the blank space is already blank. dont do anything
		    }
		    else // else. well follow the wonderful path of if's and if else's
		    {
			    if(randomX == 0)
			    { // this represents the first row
				    if(randomY == 0) // and the top left corner
				    {
					    if(board[randomX+1][randomY] == BLANK) // down
					    {
						    board[randomX+1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY+1] == BLANK) // right 
					    {
						    board[randomX][randomY+1] = board[randomX][randomY];  
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
				    }
				    else if(randomY == DIMENSION-1) // this is the Top right corner
				    {
					    if(board[randomX+1][randomY] == BLANK) // down
					    {
						    board[randomX+1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY-1] == BLANK) // left
					    {
						    board[randomX][randomY-1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
				    }
				    else  // the ones in the middle of the top
				    {
					    if(board[randomX+1][randomY] == BLANK) // down
					    {
						    board[randomX+1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY-1] == BLANK) // left
					    {
						    board[randomX][randomY-1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY+1] == BLANK) // right 
					    {
						    board[randomX][randomY+1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
				    }
						    
			    }
			    else if(randomX == DIMENSION-1) // bottom row time 
			    {
				    if(randomY == 0) // bottom left corner
				    {
					    if(board[randomX-1][randomY] == BLANK) // up 
					    {
						    board[randomX-1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY+1] == BLANK) // right
					    {
						    board[randomX][randomY+1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
				    }
				    else if(randomY == DIMENSION-1) // bottom right corner 
				    {
					    if(board[randomX-1][randomY] == BLANK) // up 
					    {
						    board[randomX-1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY-1] == BLANK) // left
					    {
						    board[randomX][randomY-1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
				    }
				    else // bottom non cornor tiles 
				    {
					    if(board[randomX-1][randomY] == BLANK) // up 
					    {
						    board[randomX-1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;						    
					    }
					    else if(board[randomX][randomY-1] == BLANK) // left
					    {
						    board[randomX][randomY-1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY+1] == BLANK) // right 
					    {
						    board[randomX][randomY+1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
				    }
			    }
			    else // middle blocks
			    {
				    if(randomY == 0) // the left blocks on the end
				    {
					    if(board[randomX-1][randomY] == BLANK) // up 
					    {
						    board[randomX-1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;						    
					    }
					    else if(board[randomX+1][randomY] == BLANK) // down
					    {
						    board[randomX+1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY+1] == BLANK) // right 
					    {
						    board[randomX][randomY+1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }    
				    }
				    else if(randomY == DIMENSION-1) // the right blocks on the end
				    {
					    if(board[randomX-1][randomY] == BLANK) // up 
					    {
						    board[randomX-1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;						    
					    }
					    else if(board[randomX+1][randomY] == BLANK) // down
					    {
						    board[randomX+1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY-1] == BLANK) // left
					    {
						    board[randomX][randomY-1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }	
				    }
				    else
				    {
					    if(board[randomX-1][randomY] == BLANK) // up 
					    {
						    board[randomX-1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;						    
					    }
					    else if(board[randomX+1][randomY] == BLANK) // down
					    {
						    board[randomX+1][randomY] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY-1] == BLANK) // left
					    {
						    board[randomX][randomY-1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }
					    else if(board[randomX][randomY+1] == BLANK) // right 
					    {
						    board[randomX][randomY+1] = board[randomX][randomY];
						    board[randomX][randomY] = BLANK;
						    count++;
					    }	
				    }					    
			    }
		    }
	    }
    }
    
    /**
     * Moves the blank on the board.  That is, if the direction of movement is up, the blank
     * moves up and a tile moves down.  This method returns true if the move was successful,
     * false if the blank cannot move in that particular direction.
     */
    public boolean move(int dir) 
    { 	
	int blankX = getBlankX(); // calls getBlankX to get the x of the blank
	int blankY = getBlankY(); // calls getBlankY to get the y of the blank
	
	switch(dir)
	{
		case 1: // up
		{
			board[blankX][blankY] = board[blankX+1][blankY]; // swaps the blank with tile below it
			board[blankX+1][blankY] = BLANK;
			return true;
		}
		case 2: //down
		{
			board[blankX][blankY] = board[blankX-1][blankY]; // swaps the blank with tile above it
			board[blankX-1][blankY] = BLANK;
			return true;
		}
		case 3: //left
		{
			board[blankX][blankY] = board[blankX][blankY+1]; // swaps the blank that is to the right of it
			board[blankX][blankY+1] = BLANK;
			return true;
		}
		case 4:  //right
		{
			board[blankX][blankY] = board[blankX][blankY-1]; // swaps the blank that is to the left of it
			board[blankX][blankY-1] = BLANK;
			return true;
		}
		default: // sentinel value 
		{
			return false;
		}
	}
		
    }
    
    /**
     * Returns true if board is solved (all numbers are in place), false otherwise.
     */
    public boolean solved() 
    {
	    int count = 1;
	    for(int i = 0; i < DIMENSION; i++) // row 
	    {
		    for(int j = 0; j < DIMENSION; j++) // column
		    {
			    if(board[i][j] == count) // if they are the same count is incremented. 
			    {	
				    count++;				   
			    }
			    else if(i == (DIMENSION-1) && j == (DIMENSION -1)) // shows if the blank then true.
			    {
				    return true;
			    }
			    else
			    {
				    return false; // if not the same.. then its false
			    }
		    }
	    }
	    return true;
    }
    
    /**
     * Finds the location of num on the board and returns a value indicating the direction
     * from the blank to the num if the num tile is adjacent to the blank.  If the num tile
     * is not adjacent to the blank, return a value indicating so.
     */
    public int findDirectionFromBlank(int num) 
    {		/** up = 1
	    	down = 2
		left = 3
		right = 4
		BLANK = -1
		*/
		for (int x = 0; x < DIMENSION; x++)
		{
			for (int y = 0; y < DIMENSION; y++)
			{
				if (board[x][y] == num) // if the blank was equal to the number
				{
					if(x == 0)
					{
						if(y == 0)
						{
							if(board[x+1][y] == BLANK) // down 
							{
								return 2;
							}
							else if(board[x][y+1] == BLANK) // right
							{
								return 4;
							}
						}
						else if(y == DIMENSION-1)
						{
							if(board[x+1][y] == BLANK) // down
							{
								return 2;
							}
							else if(board[x][y-1] == BLANK) // left
							{
								return 3;
							}
						}
						else
						{
							if(board[x+1][y] == BLANK) // down
							{
								return 2;
							}
							else if(board[x][y-1] == BLANK) // left
							{
								return 3;
							}
							else if(board[x][y+1] == BLANK) // right
							{
								return 4;
							}
						}
					}
					else if(x == DIMENSION-1)
					{
						if(y == 0) 
						{
							if(board[x-1][y] == BLANK) // up
							{
								return 1;
							}
							else if(board[x][y+1] == BLANK) // right
							{
								return 4;
							}
						}
						else if(y == DIMENSION-1)
						{
							if(board[x-1][y] == BLANK) // up
							{
								return 1;
							}
							else if(board[x][y-1] == BLANK) // left
							{
								return 3;
							}
						}
						else
						{
							if(board[x-1][y] == BLANK) // up
							{
								return 1;
							}
							else if(board[x][y-1] == BLANK) // left
							{
								return 3;
							}
							else if(board[x][y+1] == BLANK) // right
							{
								return 4;
							}
						}
					}
					else
					{
						if(y == 0)
						{
							if(board[x-1][y] == BLANK) // up
							{
								return 1;
							}
							else if(board[x][y+1] == BLANK) // right
							{
								return 4;
							}
							else if(board[x+1][y] == BLANK) // down
							{
								return 2;
							}
						}
						else if(y == DIMENSION-1)
						{
							if(board[x+1][y] == BLANK) // down
							{
								return 2;
							}
							else if(board[x-1][y] == BLANK) // up
							{
								return 1;
							}
							else if(board[x][y-1] == BLANK) // left
							{
								return 3;
							}
						}
						else
						{
							if(board[x-1][y] == BLANK) // up
							{
								return 1;
							}
							else if(board[x][y+1] == BLANK) // right
							{
								return 4;
							}
							else if(board[x+1][y] == BLANK) // down
							{
								return 2;
							}
							else if(board[x][y-1] == BLANK) // left
							{
								return 3;
							}
						}
					}
				}
			}
		}
		return -1;
    }
    
    /**
     * Get the x coordinate of the blank tile.
     */
    public int getBlankX() 
    {
	    for(int x = 0; x < DIMENSION; x++) // searches the x's
	    {
		    for(int y = 0; y < DIMENSION; y++) //  searches the y's
		    {
			    if(board[x][y] == BLANK) // returns x value for the blank
			    {
				    return x;
			    }
		    }
	    }
	    return 0;
    }
    
    /**
     * Get the y coordinate of the blank tile.
     */
    public int getBlankY() 
    {
        for(int x = 0; x < DIMENSION; x++) // searches the x's 
	    {
		    for(int y = 0; y < DIMENSION; y++)  // and the y's
		    {
			    if(board[x][y] == BLANK) // and returns the y value for the blank
			    {
				    return y;
			    }
		    }
	    }
	    return 0;
    }
    
    /**
     * Get the number on the tile at the coordinate (i,j).
     */
    public int getNumberAtCoordinate(int i, int j) 
    {
	    return board[i][j]; // returns the cords for the tile. 
    }

   /**
     * Sets this NPuzzleBoard to that of newBoard.  You may assume that the dimensions
     * of the two boards are the same.  You should NOT simply copy over reference addresses
     * even if your board array setup is the same as the parameter newBoard.  Instead, you
     * should make a deep copy of the board by copying over the tile numbers one by one
     * into your board representation.
     */
    public void setBoard(int[][] newBoard)  // for debuggin
    {
	   int h = 1;
	   for(int i = 0; i < newBoard.length; i++) // rows
		{
			for(int j = 0; j < newBoard[i].length; j++) // columns
			{
				newBoard[i][j] = h;
				h++;
				if(h == DIMENSION*DIMENSION) // last slot = blank... sa
				{
					newBoard[DIMENSION-1][DIMENSION-1] = BLANK;
				}
			}
		}
    }
}
