public class Cube
{

    /* The method equals() below compares two
     * Cube objects and return true if they are
     * equal and false otherwise.
     *
     * We will use the equals method to compare
     * a cube to the solved cube. This could
     * be expressed as:
     *
     *  cube.equals(solved)
     *
     *  for some Cube cube and a solved Cube
     *  solved. Notice that if we use equals()
     *  in a method in this class (Cube) we
     *  can use
     *
     *  this.equals(solved)
     *
     *  or just
     *
     *  equals(solved)
     *
     *  to implicitly refer to the Cube object
     *  calling the method.
     */
    public boolean equals(Cube c)
    {
        for(int face=0; face<6; face++)
        {
            for(int i=0; i<9; i++)
            {
                if(cube[face][i/3][i%3] != c.cube[face][i/3][i%3])
                {
                    return false;
                }
            }
        }

        return true;
    }

    /* The method solve() below takes a "goal" cube
     * and the number of steps we have to reach the
     * goal. 
     *
     * Each move we make (Rti, Lti, Fti) in an effort
     * to reach the goal cube will cost us 1 step.
     *
     * If we try a move and discover that it does not
     * lead to a solution, then we "reuse" the step
     * we tried.
     *
     * Here is an example:
     *
     *  1.  Cube scrambled with: Lt Ft
     *      (NOTE: In general, we don't know how the
     *       cube was scrambled !!!)
     *  
     *  2.  Goal cube is a solved cube.
     *
     *  3.  We have ttl = 2 which means we can only use
     *      2 moves to solve the cube.
     *      (NOTE: ttl stand for "time to live")
     *
     *  4.  In our first attempt we try Rti.
     *      4a. This leaves us with ttl = 1 which
     *          means we must find a solution that
     *          uses only one move. So, we recurse. 
     *          Notice how we have reduced
     *          one problem to a very similiar one:
     *          Given a scrambled cube and a number
     *          of moves to solve it, we tentatively
     *          try one move and this leaves us
     *          with the problem of solving the cube
     *          with one less move.
     *
     *      4b. We will discover that there is
     *          no solution if we start with Rti
     *
     *      4c. So we *UNDO* Rti which gives us back
     *          the move we spent on Rti. Hence
     *          tll = 2 again.
     *
     *  5. In our second attempt we try Lti.
     *      5a. This leaves us with ttl = 1 which means
     *          we must find a solution that uses only 1
     *          move. Again this is a similiar problem,
     *          so we recurse.
     *
     *      5b. We will discover that this leads to a
     *          solution. So we will prepend " Lti "
     *          to the solution string we got from the
     *          recursion and return the string
     *
     *  END EXAMPLE
     *
     *  But how can we signal that a particular attempt
     *  worked? Since this method returns the string representing
     *  the solution, we construct a simple convention:
     *      If cube.solve(goal, n) is "" (the empty string)
     *          then no sequence of n moves will make cube
     *          match goal.
     *      Otherwise, the String returned by cube.solve(goal, n)
     *          represents the sequence of up to n moves that
     *          transform cube into goal.
     *
     *  SO: If we discover the cube cannot be made to reach goal,
     *      then we return "". Otherwise we return some non-empty
     *      string (generally the solution String  to the subproblem 
     *      with the move we just tried prepend onto it).
     *
     *
     * SO SO: The basic strategy is this:
     *
     *      If the cube is already solved, that is, if our cube
     *      equals the goal cube, then return a non-empty
     *      string. For simplicity's sake, use " ".
     *
     *      If the cube cannot be solved, that is, if ttl = 0 so
     *      we have no moves left to try, then return the empty
     *      string "".
     *
     *      For each of the possible inverse moves: Rti, Lti, Fti
     *          Tentatively make this move.
     *
     *          Recurse with ttl one less.
     *
     *          If the recursive call returns a non-empty string,
     *              then we have found a solution. So prepend this
     *              move's String representation (" Rti ", " Lti ",
     *              or " Fti ") to solution string and return the 
     *              solution string.
     *
     *          Otherwise (the recursive call returns the empty string),
     *              undo the move. For example, if you tentatively
     *              tried Rti(), then to undo it you would call Rt().
     *              This gives us back the move we were trying out.
     *
     *         Go to the next possible move.
     *
     *      If none of the moves Rti, Lti, or Fti can lead to a solution,
     *      then cube is not solvable. Hence you should return the empty
     *      String "".
     */
     public String bill = "";
    public String solve(Cube goal, int ttl)
    {
        /* TODO 1
         *
         * Implement the above solution strategy.
         */
	 if(this.equals(goal))
	 {
		 return " ";
	 }
	 else if(ttl <= 0){
		 return "";
	 }
	 Rti();
	 if(!(this.solve(goal, ttl-1).equals("")))
	 {
		 bill = "Rti " + bill;
		 return bill;
	 }
	 Rt();
	 if(!(this.solve(goal, ttl-1).equals("")))
	 {
		 bill = "Rt " + bill;
		 return bill;
	 }
	 Lti();
	 if(!(this.solve(goal, ttl-1).equals("")))
	 {
		 bill = "Lti " + bill;
		  return bill;
	 }
	 Lt();
	 if(!(this.solve(goal, ttl-1).equals("")))
	 {
		 bill = "Lt " + bill;
		  return bill;
	 }
	 Fti();
	  if(!(this.solve(goal, ttl-1).equals("")))
	 {
		 bill = "Fti " + bill;
		  return bill;
	 }
	 Ft();
	  if(!(this.solve(goal, ttl-1).equals("")))
	 {
		 bill = "Ft " + bill;
		  return bill;
	 }
        return ""; // this is just so Cube.java will compile. You should remove it.
    }



    /* 
     * This main method just drives the solve() method.
     * You should read it to understand what's going on.
     */
    public static void main(String args[])
    {
        // ttl ~ "time to live"
        int ttl = 0;
        try
        {
             ttl  = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.err.println("Usage: java Cube [ # of random moves ]");
            System.exit(1);
        }

        // create a fresh cube
        Cube c = new Cube();

        // let opponent scramble cube
        CubeScrambler.scramble(c, ttl);

        // create a solved cube as a goal to match our muddled cube to
        Cube solved = new Cube();

        // try to solve the cube
        String sol = c.solve(solved, ttl);

        // if we get a non-empty string back it is the solution
        if(!"".equals(sol))
        {
            System.out.println("I think the solution is:");
            System.out.println("\t" + sol + "\n");

            System.out.println("Here is how the opponent scrambled the cube:");
            System.out.println("\t" + CubeScrambler.getScramble());
        }
        else
        {
            System.out.println("No solution found.");
        }
    }




    /* 
     * BELOW IS THE IMPLEMENTATION OF THE CUBE CLASS AND ITS METHODS
     * YOU SHOULD READ THESE TO DISCOVER HOW THE METHODS YOU ARE USING
     * ABOVE ACTUALLY WORK
     */



    public static final int Ye = 0;
    public static final int Gr = 1;
    public static final int Wh = 2;
    public static final int Bl = 3;
    public static final int Rd = 4;
    public static final int Or = 5;
    public static final String color[] = {"Ye", "Gr", "Wh", "Bl", "Rd", "Or"};

    public static final int Ft = 0;
    public static final int Bm = 1;
    public static final int Bk = 2;
    public static final int Tp = 3;
    public static final int Lt = 4;
    public static final int Rt = 5;

    int cube[][][];

    /* The cube has 6 cubes which we lay out as:
     *
     *               -----
     *               | 4 |
     *               -----
     *        -----  -----  -----  -----
     *        | 0 |  | 1 |  | 2 |  | 3 |
     *        -----  -----  -----  -----
     *               -----
     *               | 5 |
     *               -----
     *
     *     4
     *   0 1 2 3 
     *     5
     *
     * We use special names to suggest the position of
     * the cube in relation to the solver:
     *
     * 0 - front
     * 1 - bottom
     * 2 - back
     * 3 - top
     * 4 - left
     * 5 - right
     *
     * Thinking of the cube in this way should provide
     * an unabmiguous picture of how our flattening
     * corresponds to the actual cube.
     *
     * Within each cube we have a 3x3 int array of colors.
     * The semantics of these arrays are specified as:
     *
     *                         (top)
     *
     *                       0 : 0 1 2
     *                       1 : 0 1 2
     *                       2 : 0 1 2
     *
     *          0 : 0 1 2    0 : 0 1 2   0 : 0 1 2    0 : 0 1 2   
     * (top)    1 : 0 1 2    1 : 0 1 2   1 : 0 1 2    1 : 0 1 2  (front)
     *          2 : 0 1 2    2 : 0 1 2   2 : 0 1 2    2 : 0 1 2
     *
     *                       0 : 0 1 2
     *                       1 : 0 1 2
     *                       2 : 0 1 2
     *
     *                         (top)
     
     *
     */

    // initial setting
    // cube[0] -> yellow
    // cube[1] -> green
    // cube[2] -> white
    // cube[3] -> blue
    // cube[4] -> red
    // cube[5] -> orange
    int init[][][] = 
           { { {Ye, Ye, Ye},  {Ye, Ye, Ye},  {Ye, Ye, Ye} },
             { {Gr, Gr, Gr},  {Gr, Gr, Gr},  {Gr, Gr, Gr} },
             { {Wh, Wh, Wh},  {Wh, Wh, Wh},  {Wh, Wh, Wh} },
             { {Bl, Bl, Bl},  {Bl, Bl, Bl},  {Bl, Bl, Bl} },
             { {Rd, Rd, Rd},  {Rd, Rd, Rd},  {Rd, Rd, Rd} },
             { {Or, Or, Or},  {Or, Or, Or},  {Or, Or, Or} } };

    public Cube()
    {
        cube = init;
    }

    public void print()
    {
        String out = 
            " .. .. .." + 
            " " + color[cube[Lt][0][0]] + 
            " " + color[cube[Lt][0][1]] +
            " " + color[cube[Lt][0][2]] +
            " .. .. .." + 
            " .. .. .." + 
            "\n" +

            " .. .. .." + 
            " " + color[cube[Lt][1][0]] + 
            " " + color[cube[Lt][1][1]] +
            " " + color[cube[Lt][1][2]] +
            " .. .. .." + 
            " .. .. .." + 
            "\n" +

            " .. .. .." + 
            " " + color[cube[Lt][2][0]] + 
            " " + color[cube[Lt][2][1]] +
            " " + color[cube[Lt][2][2]] +
            " .. .. .." + 
            " .. .. .." + 
            "\n" +

            " " + color[cube[Ft][0][0]] +
            " " + color[cube[Ft][0][1]] +
            " " + color[cube[Ft][0][2]] +
            " " + color[cube[Bm][0][0]] +
            " " + color[cube[Bm][0][1]] +
            " " + color[cube[Bm][0][2]] +
            " " + color[cube[Bk][0][0]] +
            " " + color[cube[Bk][0][1]] +
            " " + color[cube[Bk][0][2]] +
            " " + color[cube[Tp][0][0]] +
            " " + color[cube[Tp][0][1]] +
            " " + color[cube[Tp][0][2]] +
            "\n" +

            " " + color[cube[Ft][1][0]] +
            " " + color[cube[Ft][1][1]] +
            " " + color[cube[Ft][1][2]] +
            " " + color[cube[Bm][1][0]] +
            " " + color[cube[Bm][1][1]] +
            " " + color[cube[Bm][1][2]] +
            " " + color[cube[Bk][1][0]] +
            " " + color[cube[Bk][1][1]] +
            " " + color[cube[Bk][1][2]] +
            " " + color[cube[Tp][1][0]] +
            " " + color[cube[Tp][1][1]] +
            " " + color[cube[Tp][1][2]] +
            "\n" +

            " " + color[cube[Ft][2][0]] +
            " " + color[cube[Ft][2][1]] +
            " " + color[cube[Ft][2][2]] +
            " " + color[cube[Bm][2][0]] +
            " " + color[cube[Bm][2][1]] +
            " " + color[cube[Bm][2][2]] +
            " " + color[cube[Bk][2][0]] +
            " " + color[cube[Bk][2][1]] +
            " " + color[cube[Bk][2][2]] +
            " " + color[cube[Tp][2][0]] +
            " " + color[cube[Tp][2][1]] +
            " " + color[cube[Tp][2][2]] +
            "\n" +

            " .. .. .." + 
            " " + color[cube[Rt][0][0]] + 
            " " + color[cube[Rt][0][1]] +
            " " + color[cube[Rt][0][2]] +
            " .. .. .." + 
            " .. .. .." + 
            "\n" +

            " .. .. .." + 
            " " + color[cube[Rt][1][0]] + 
            " " + color[cube[Rt][1][1]] +
            " " + color[cube[Rt][1][2]] +
            " .. .. .." + 
            " .. .. .." + 
            "\n" +

            " .. .. .." + 
            " " + color[cube[Rt][2][0]] + 
            " " + color[cube[Rt][2][1]] +
            " " + color[cube[Rt][2][2]] +
            " .. .. .." + 
            " .. .. .." + 
            "\n";

        System.out.print(out + "\n");
    }

    public void Ft()
    {
        int tmp;

        // front corners
        tmp = cube[Ft][0][0];
        cube[Ft][0][0] = cube[Ft][0][2];
        cube[Ft][0][2] = cube[Ft][2][2];
        cube[Ft][2][2] = cube[Ft][2][0];
        cube[Ft][2][0] = tmp;

        // front edges
        tmp = cube[Ft][0][1];
        cube[Ft][0][1] = cube[Ft][1][2];
        cube[Ft][1][2] = cube[Ft][2][1];
        cube[Ft][2][1] = cube[Ft][1][0];
        cube[Ft][1][0] = tmp;

        // outside corners 1
        tmp = cube[Tp][2][2];
        cube[Tp][2][2] = cube[Lt][0][0];
        cube[Lt][0][0] = cube[Bm][0][0];
        cube[Bm][0][0] = cube[Rt][0][0];
        cube[Rt][0][0] = tmp;

        // outside corners 2
        tmp = cube[Tp][0][2];
        cube[Tp][0][2] = cube[Lt][2][0];
        cube[Lt][2][0] = cube[Bm][2][0];
        cube[Bm][2][0] = cube[Rt][2][0];
        cube[Rt][2][0] = tmp;

        // outside edges
        tmp = cube[Tp][1][2];
        cube[Tp][1][2] = cube[Lt][1][0];
        cube[Lt][1][0] = cube[Bm][1][0];
        cube[Bm][1][0] = cube[Rt][1][0];
        cube[Rt][1][0] = tmp;
    }

    public void Fti()
    {
        Ft();
        Ft();
        Ft();
    }

    public void Rt()
    {
        int tmp;

        // right corners
        tmp = cube[Rt][2][0];
        cube[Rt][2][0] = cube[Rt][0][0];
        cube[Rt][0][0] = cube[Rt][0][2];
        cube[Rt][0][2] = cube[Rt][2][2];
        cube[Rt][2][2] = tmp;

        // right edges
        tmp = cube[Rt][2][1];
        cube[Rt][2][1] = cube[Rt][1][0];
        cube[Rt][1][0] = cube[Rt][0][1];
        cube[Rt][0][1] = cube[Rt][1][2];
        cube[Rt][1][2] = tmp;

        // outside corners 1
        tmp = cube[Tp][2][0];
        cube[Tp][2][0] = cube[Ft][2][0];
        cube[Ft][2][0] = cube[Bm][2][0];
        cube[Bm][2][0] = cube[Bk][2][0];
        cube[Bk][2][0] = tmp;
        
        // outside corners 2
        tmp = cube[Tp][2][2];
        cube[Tp][2][2] = cube[Ft][2][2];
        cube[Ft][2][2] = cube[Bm][2][2];
        cube[Bm][2][2] = cube[Bk][2][2];
        cube[Bk][2][2] = tmp;
        
        // outsice edges
        tmp = cube[Tp][2][1];
        cube[Tp][2][1] = cube[Ft][2][1];
        cube[Ft][2][1] = cube[Bm][2][1];
        cube[Bm][2][1] = cube[Bk][2][1];
        cube[Bk][2][1] = tmp;
        
    }

    public void Rti()
    {
        Rt();
        Rt();
        Rt();
    }

    public void Tp()
    {
        int tmp;

        // top corners
        tmp = cube[Tp][2][0];
        cube[Tp][2][0] = cube[Tp][0][0];
        cube[Tp][0][0] = cube[Tp][0][2];
        cube[Tp][0][2] = cube[Tp][2][2];
        cube[Tp][2][2] = tmp;

        // top edges
        tmp = cube[Tp][2][1];
        cube[Tp][2][1] = cube[Tp][1][0];
        cube[Tp][1][0] = cube[Tp][0][1];
        cube[Tp][0][1] = cube[Tp][1][2];
        cube[Tp][1][2] = tmp;

        // outside corners 1
        tmp = cube[Rt][2][0];
        cube[Rt][2][0] = cube[Bk][2][2];
        cube[Bk][2][2] = cube[Lt][0][2];
        cube[Lt][0][2] = cube[Ft][0][0];
        cube[Ft][0][0] = tmp;

        // outside corners 2
        tmp = cube[Rt][2][2];
        cube[Rt][2][2] = cube[Bk][0][2];
        cube[Bk][0][2] = cube[Lt][0][0];
        cube[Lt][0][0] = cube[Ft][2][0];
        cube[Ft][2][0] = tmp;

        // outside edges
        tmp = cube[Rt][2][1];
        cube[Rt][2][1] = cube[Bk][1][2];
        cube[Bk][1][2] = cube[Lt][0][1];
        cube[Lt][0][1] = cube[Ft][1][0];
        cube[Ft][1][0] = tmp;
    }

    public void Tpi()
    {
        Tp();
        Tp();
        Tp();
    }

    public void Lt()
    {
        int tmp;

        // left corners
        tmp = cube[Lt][2][0];
        cube[Lt][2][0] = cube[Lt][0][0];
        cube[Lt][0][0] = cube[Lt][0][2];
        cube[Lt][0][2] = cube[Lt][2][2];
        cube[Lt][2][2] = tmp;

        // left edges
        tmp = cube[Lt][2][1];
        cube[Lt][2][1] = cube[Lt][1][0];
        cube[Lt][1][0] = cube[Lt][0][1];
        cube[Lt][0][1] = cube[Lt][1][2];
        cube[Lt][1][2] = tmp;

        // outside corners 1
        tmp = cube[Tp][0][2];
        cube[Tp][0][2] = cube[Bk][0][2];
        cube[Bk][0][2] = cube[Bm][0][2];
        cube[Bm][0][2] = cube[Ft][0][2];
        cube[Ft][0][2] = tmp;

        // outside corners 2
        tmp = cube[Tp][0][0];
        cube[Tp][0][0] = cube[Bk][0][0];
        cube[Bk][0][0] = cube[Bm][0][0];
        cube[Bm][0][0] = cube[Ft][0][0];
        cube[Ft][0][0] = tmp;
        
        // outside edges
        tmp = cube[Tp][0][1];
        cube[Tp][0][1] = cube[Bk][0][1];
        cube[Bk][0][1] = cube[Bm][0][1];
        cube[Bm][0][1] = cube[Ft][0][1];
        cube[Ft][0][1] = tmp;
    }

    public void Lti()
    {
        Lt();
        Lt();
        Lt();
    }

    public void Bm()
    {
        int tmp;

        // bottom corners
        tmp = cube[Bm][2][0];
        cube[Bm][2][0] = cube[Bm][0][0];
        cube[Bm][0][0] = cube[Bm][0][2];
        cube[Bm][0][2] = cube[Bm][2][2];
        cube[Bm][2][2] = tmp;

        // bottom edges
        tmp = cube[Bm][2][1];
        cube[Bm][2][1] = cube[Bm][1][0];
        cube[Bm][1][0] = cube[Bm][0][1];
        cube[Bm][0][1] = cube[Bm][1][2];
        cube[Bm][1][2] = tmp;

        // outside corners 1
        tmp = cube[Rt][0][2];
        cube[Rt][0][2] = cube[Ft][2][2];
        cube[Ft][2][2] = cube[Lt][2][0];
        cube[Lt][2][0] = cube[Bk][0][0];
        cube[Bk][0][0] = tmp;

        // outside corners 2
        tmp = cube[Rt][0][0];
        cube[Rt][0][0] = cube[Ft][0][2];
        cube[Ft][0][2] = cube[Lt][2][2];
        cube[Lt][2][2] = cube[Bk][2][0];
        cube[Bk][2][0] = tmp;

        // outside edges
        tmp = cube[Rt][0][1];
        cube[Rt][0][1] = cube[Ft][1][2];
        cube[Ft][1][2] = cube[Lt][2][1];
        cube[Lt][2][1] = cube[Bk][1][0];
        cube[Bk][1][0] = tmp;
    }

    public void Bmi()
    {
        Bm();
        Bm();
        Bm();
    }

    public void Bk()
    {
        int tmp;

        // back corners
        tmp = cube[Bk][2][0];
        cube[Bk][2][0] = cube[Bk][0][0];
        cube[Bk][0][0] = cube[Bk][0][2];
        cube[Bk][0][2] = cube[Bk][2][2];
        cube[Bk][2][2] = tmp;

        // back edges
        tmp = cube[Bk][2][1];
        cube[Bk][2][1] = cube[Bk][1][0];
        cube[Bk][1][0] = cube[Bk][0][1];
        cube[Bk][0][1] = cube[Bk][1][2];
        cube[Bk][1][2] = tmp;

        // outside corners 1
        tmp = cube[Tp][0][0];
        cube[Tp][0][0] = cube[Rt][2][2];
        cube[Rt][2][2] = cube[Bm][2][2];
        cube[Bm][2][2] = cube[Lt][2][2];
        cube[Lt][2][2] = tmp;

        // outside corners 2
        tmp = cube[Tp][2][0];
        cube[Tp][2][0] = cube[Rt][0][2];
        cube[Rt][0][2] = cube[Bm][0][2];
        cube[Bm][0][2] = cube[Lt][0][2];
        cube[Lt][0][2] = tmp;

        // outside edges
        tmp = cube[Tp][1][0];
        cube[Tp][1][0] = cube[Rt][1][2];
        cube[Rt][1][2] = cube[Bm][1][2];
        cube[Bm][1][2] = cube[Lt][1][2];
        cube[Lt][1][2] = tmp;
    }

    public void Bki()
    {
        Bk();
        Bk();
        Bk();
    }
}
