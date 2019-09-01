import java.util.Random;

public class Ai2048 {
	
  public static void main(String[] argv)
  {
    TwoThousandFourtyEight board = new TwoThousandFourtyEight(4, 4);
    playAI(board);
  }
  static void playLeft(TwoThousandFourtyEight board) {
		
    // idea: take the current board and use 4 calls that check which configuration will give you the most combinations
    // ie use a counter and see if in a row or col (moving backwards or forwards)how many combinations you can get
    // check for left, right, up, down then whichever way gives you the most combinations do that
    // check for something: see how to win 2048. If the goal is to keep everything in a small corner, maybe do that 
    // ex. only do left and down instead of all 4 directions to keep the maximum tile in one corner
    // minimize occupied spaces, maximize unoccupied spaces
    // play with the idea that when there is only one to two unoccupied spaces
    // Try to keep tiles in a consecutive order next to each other
    //if on the bottom row the highest value is on the left or right end of the options, move the board to that direction and switch which way it combines
    while (board.left()) {
			// loop until the board is full!
		}
	}

	static void playRandom(TwoThousandFourtyEight board) {
	  
    int check = 0;
    //TwoThousandFourtyEight T = new TwoThousandFourtyEight(4, 4);
    
    while(check != 1)
    {
      Random rand = new Random(); 
      int x = rand.nextInt(4);
      if(x == 0)
      {
        if(!board.up())
        {
          check = 1;
        }
      }
      else if(x == 1)
      {
        if(!board.down())
        {
          check = 1;
        }
      }
      else if(x == 2)
      {
        if(!board.left())
        {
          check = 1;
        }
      }
      else if(x == 3)
      {
        if(!board.right())
        {
          check = 1;
        }
      }
    }
  }

  
  static void playAI(TwoThousandFourtyEight board) {
  
    //TwoThousandFourtyEight AI = new TwoThousandFourtyEight(4, 4);
    TwoDimensional2048 Tester = new TwoDimensional2048();
    int[][] tempBoard;
    int check = 0;
    int unoccupiedLeft = 0;
    int unoccupiedDown = 0;
    int sum = 0;
    int h = 0;
    int w = 0;
    int q = 0;
    int t = 0;
    int scoreLeft = 0;
    int scoreDown = 0;
    int leftODown = 0;
    int downOLeft = 0;
    int leftEDown = 0;
    
    
    // //print board
//     int h = tempBoard.length;
//     int w = tempBoard[0].length;
//     for(int j=0; j<h; j++)
//     {
//       for(int i=0; i<w; i++)
//       {
//         System.out.print(tempBoard[j][i]);
//       }
//       System.out.println();
//     }
//     //print board
    
    
    //make the first move
    board.left();
    
    //while runs until the board is ful
    while(check != 1)
    {
      tempBoard = board.getBoard();
      tempBoard = Tester.left(tempBoard);
      unoccupiedLeft = Tester.numUnoccupied(tempBoard);
      //System.out.println(unoccupiedLeft);
      
      tempBoard = board.getBoard();
      tempBoard = Tester.down(tempBoard);
      unoccupiedDown = Tester.numUnoccupied(tempBoard);
      //System.out.println(unoccupiedDown);
      
      // if(unoccupiedLeft == unoccupiedDown && unoccupiedDown == 0)
//       {
//         check = 1;
//       }
      
      if(unoccupiedLeft > unoccupiedDown)
      {
        leftODown++;
        if(!board.left())
        {
          check = 1;
        }
      }
      
      else if(unoccupiedDown > unoccupiedLeft)
      {
        downOLeft++;
        if(!board.down())
        {
          //System.out.println("Left over down: " + leftODown);
          //System.out.println("Down over left: " + downOLeft);
          //System.out.println("Left equal down: " + leftEDown);
          check = 1;
        }
      }
      
      else if(unoccupiedDown == unoccupiedLeft)
      {
        leftEDown++;
        sum = 0;
        h = tempBoard.length;
        w = tempBoard[0].length;
        q = 0;
        t = 0;
          
        for(int i=0; i<h; i++)
        {
          for(int j=0; j<w; j++)
          {
            q = tempBoard[j][i];
            t = 0;
            while(q >= 2)
            {
              t = q + t;
              q = q/2;
            }
            sum = sum + t;      
          }
        } 
        scoreDown = sum;
        
        tempBoard = board.getBoard();
        tempBoard = Tester.left(tempBoard);
        sum = 0;
        h = tempBoard.length;
        w = tempBoard[0].length;
        q = 0;
        t = 0;
          
        for(int i=0; i<h; i++)
        {
          for(int j=0; j<w; j++)
          {
            q = tempBoard[j][i];
            t = 0;
            while(q >= 2)
            {
              t = q + t;
              q = q/2;
            }
            sum = sum + t;      
          }
        } 
        scoreLeft = sum;
        
        if(scoreLeft > scoreDown)
        {
          if(!board.left())
          {
            //System.out.println("AI Done"); 
            //System.out.println("Left over down: " + leftODown);
            //System.out.println("Down over left: " + downOLeft);
            //System.out.println("Left equal down: " + leftEDown);
            check = 1;
          }
        }
        
        else if(scoreDown > scoreLeft)
        {
          if(!board.down())
          {
            //System.out.println("AI Done");
            //System.out.println("Left over down: " + leftODown);
            //System.out.println("Down over left: " + downOLeft);
            //System.out.println("Left equal down: " + leftEDown);
            check = 1;
          }
        }
        
        else
        {
          if(!board.left())
          {
            //System.out.println("AI Done");
            //System.out.println("Left over down: " + leftODown);
            //System.out.println("Down over left: " + downOLeft);
            //System.out.println("Left equal down: " + leftEDown);
            check = 1;
          }
        }

        //System.out.println("The score is " + sum);
        //gets score (sum)
      }
      
   }
    
//     //gets score
//     int sum = 0;
//     int h = tempBoard.length;
//     int w = tempBoard[0].length;
//     int q = 0;
//     int t = 0;
//       
//     for(int i=0; i<h; i++)
//     {
//       for(int j=0; j<w; j++)
//       {
//         q = tempBoard[j][i];
//         t = 0;
//         while(q >= 2)
//         {
//           t = q + t;
//           q = q/2;
//         }
//         sum = sum + t;      
//       }
//     } 
//     //System.out.println("The score is " + sum);
//     //gets score (sum)

  

    
	}

}
