class TwoThousandFourtyEight implements TwoThousandFourtyEightInt{
   //fields

   private int[][] board;
   public int score;
   
   TwoThousandFourtyEight(int x, int y) {
     TwoDimensional2048 T = new TwoDimensional2048();
     int[][] tempBoard = new int[y][x];
     T.addNewValue(tempBoard);
     board = tempBoard;
   }

   TwoThousandFourtyEight(int[][] b) {
   // Constructor
     board = b;
   }

   public int[][] getBoard() {
      int[][] tempBoard;
      tempBoard = board;
      return tempBoard;
   }


   public int getHighestTile() {
      
      int[][] tempBoard;
      tempBoard = getBoard();
      int h = tempBoard.length;
      int w = tempBoard[0].length;
      int highVal = tempBoard[0][0];
      
      for(int i=0; i<h; i++)
      {
        for(int j=0; j<w; j++)
        {
          if(tempBoard[i][j] > highVal)
          {
            highVal = tempBoard[i][j];
          }
        }
      }
      
      return highVal;	
   }

   private int calculateScore() {
      
      int sum = 0;
      int h = board.length;
      int w = board[0].length;
      int q = 0;
      int t = 0;
      
      for(int i=0; i<h; i++)
      {
        for(int j=0; j<w; j++)
        {
          q = board[j][i];
          t = 0;
          while(q >= 2)
          {
            t = q + t;
            q = q/2;
          }
          sum = sum + t;      
        }
      } 
      return sum;
   }
   
   public int getScore()
   {
     return score;
   }

   public void printBoard() {
   
    int[][] tempBoard;
    tempBoard = getBoard();
    int h = tempBoard.length;
    int w = tempBoard[0].length;
    System.out.println("Board current: ");
    for(int j=0; j<h; j++)
    {
      for(int i=0; i<w; i++)
      {
        System.out.print(tempBoard[j][i]);
      }
      System.out.println();
    }
    System.out.println();
    
   }

    public TwoThousandFourtyEight copy() {
      
      int[][] copyBoard;
      copyBoard = getBoard();     
      TwoThousandFourtyEight copy = new TwoThousandFourtyEight(copyBoard);
      return copy;
   }


    //up action on board
    public boolean up() {
      
      TwoDimensional2048 T = new TwoDimensional2048();
      if(fullBoard() == false)
      {
        int[][] tempBoard;
        tempBoard = getBoard();
        tempBoard = T.up(tempBoard);
        T.addNewValue(tempBoard);
        board = tempBoard;
        //printBoard();
        return true;
      }
      //System.out.println("Up, full board is returning false.");
      //printBoard();
      return false;
   }

    //down action on board
    public boolean down() {
      TwoDimensional2048 T = new TwoDimensional2048();
      if(fullBoard() == false)
      {
        int[][] tempBoard;
        tempBoard = getBoard();
        tempBoard = T.down(tempBoard);
        T.addNewValue(tempBoard);
        board = tempBoard;
        //printBoard();
        return true;
      }
      //System.out.println("Down, full board is returning false.");
      //printBoard();
      return false;
 
   }

     //left action on board
    public boolean left() {
      TwoDimensional2048 T = new TwoDimensional2048();
      if(fullBoard() == false)
      {
        int[][] tempBoard;
        tempBoard = getBoard();
        tempBoard = T.left(tempBoard);
        T.addNewValue(tempBoard);
        board = tempBoard;
        //printBoard();
        return true;
      }
      //System.out.println("Left, full board is returning false.");
      //printBoard();
      return false;
   }

     //rigth action on board
    public boolean right() {
      TwoDimensional2048 T = new TwoDimensional2048();
      if(fullBoard() == false)
      {
        int[][] tempBoard;
        tempBoard = getBoard();
        tempBoard = T.right(tempBoard);
        T.addNewValue(tempBoard);
        board = tempBoard;
        //printBoard();
        return true;
      }
      //System.out.println("Right, full board is returning false.");
      //printBoard();
      return false;
   }
   
   private boolean fullBoard()
   {
     int[][] tempBoard;
     tempBoard = getBoard();
     int h = tempBoard.length;
     int w = tempBoard[0].length;
      
     for(int i=0; i<h; i++)
     {
       for(int j=0; j<w; j++)
       {
         if(tempBoard[i][j] == 0)
         {
           return false;
         }
       }
     }
     
     gameOver();
     return true;
   }
   
   private void gameOver()
   {
    
    score = calculateScore();
    //System.out.println("Game over: your score is " + getScore());
   }
   
}
