import java.util.Scanner;

public class TwoDimensional2048 implements TwoDimensional{
    public static void main(String[] args) {
        int[][] b, br, brc;
        int[][] b2;
        int tmp;

        int[][] initb = {
                {0,2,0,0,2},
                {0,2,0,0,0},
                {0,2,0,2,0},
                {0,2,0,2,2},
                {2,0,2,0,0}};
        int[][] lb = {
                {4,0,0,0,0},
                {2,0,0,0,0},
                {4,0,0,0,0},
                {4,2,0,0,0},
                {4,0,0,0,0}};
        int[][] ub = {
                {2,4,2,4,4},
                {0,4,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};
        int[][] rb = {
                {0,0,0,0,4},
                {0,0,0,0,2},
                {0,0,0,0,4},
                {0,0,0,2,4},
                {0,0,0,0,4}};
        int[][] db = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,4,0,0,0},
                {2,4,2,4,4}};
        int[][] multb = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,4},
                {0,0,0,0,16}};
        int[][] bprerot = {
                {0,0,2,2},
                {0,2,2,0},
                {0,2,0,2},
                {2,0,0,0},
                {0,2,0,2},
                {0,0,0,2},
                {0,0,0,0}};
        int[][] brot1 = {
                {2,0,2,0,2,2,0},
                {2,2,0,0,0,0,0},
                {0,2,2,0,2,0,0},
                {0,0,0,2,0,0,0}};
        int[][] brot3 = {
                {0,0,0,2,0,0,0},
                {0,0,2,0,2,2,0},
                {0,0,0,0,0,2,2},
                {0,2,2,0,2,0,2}};

        // Check the creation of boards, and adding new values
        // to the board.
        
        TwoDimensional2048 T =new TwoDimensional2048();
        b = T.blankBoard(5, 5);
        assert(T.validateBoard(b));

        for (int i = 0 ; i < 10 ; i++) {
            T.addNewValue(b);
        }
        assert(T.validateBoard(b));
        tmp = b[1][4];
        b[1][4] = 33;
        assert(!T.validateBoard(b));
        b[1][4] = tmp;
        assert(T.identicalBoard(initb, b));

        // Check if the randCoord method works
        brc = T.blankBoard(5, 6);
        // add in some random values
        brc[0][0] = 2;
        brc[1][1] = 2;
        brc[2][2] = 2;
        brc[3][3] = 2;
        brc[4][4] = 2;
        brc[4][5] = 2;
        int[][] coordAnswers = {
                {0, 1},
                {3, 2},
                {2, 0},
                {0, 4}};
        for (int i = 0 ; i < 4 ; i++) {
            int[] coord = T.randCoord(brc, (i * 41)%T.numUnoccupied(brc));
            assert(coord[0] == coordAnswers[i][0] &&
                    coord[1] == coordAnswers[i][1]);
        }

        // Check rotation.
        br = T.blankBoard(7, 4);
        for (int i = 0 ; i < 10 ; i++) {
            T.addNewValue(br);
        }
        assert(T.validateBoard(br));
        assert(T.identicalBoard(br, bprerot));
        br = T.rotateLeft(br);
        assert(T.identicalBoard(br, brot1));
        br = T.rotateLeft(T.rotateLeft(br));
        assert(T.identicalBoard(br, brot3));

        // Check the movement operations.
        b2 = b;
        b = T.left(b2);
        assert(T.identicalBoard(lb, b));
        b = T.up(b2);
        assert(T.identicalBoard(ub, b));
        b = T.right(b2);
        assert(T.identicalBoard(rb, b));
        b = T.down(b2);
        assert(T.identicalBoard(db, b));

        b = b2;
        b = T.left(b);
        b = T.up(b);
        b = T.right(b);
        b = T.down(b);
        b = T.right(b);
        b = T.down(b);
        assert(T.identicalBoard(multb, b));


        // Please add your checks below

    }    



///All the return values are set to default. You need to replace it with the correct format.

    public boolean validateBoard(int[][] b){
        
        OneDimensional2048 J = new OneDimensional2048();
        int rows = b.length;
        int entries = 0;
        
        if(b.length <= 0)
        {
          return false;
        }
        
        for(int i=0; i<rows; i++)
        {
          if(!J.validateRow(b[i]))
          {
            System.out.println("Error: Row enteries are not valid.");            
            return false;
          }
        }
        
        for(int j=0; j<rows; j++)
        {
          entries = entries + b[j].length;
          
          if(entries % b[j].length != 0)
          {
            System.out.println("Error: The rows are not equal in length.");
            return false;
          }
        }
        
        //System.out.println(b.length);
        // for(int a=0; a<b[0].length; a++)
//         {
//           System.out.print(b[0][a]);
//         }
        
        if((entries / b[0].length) != rows)
        {
          return false;
        }
        
        return true;
    }
    public int[][] blankBoard(int x, int y) {
        
        int[][] board = new int[x][y];
        return board;
    }
    public boolean identicalBoard(int[][] m, int[][] n) {
        
        int q = 0;
        if(!validateBoard(m) && !validateBoard(n))
        {
          System.out.println("fAIL: validate Board");
          return false;
        }
        
        
        if(m.length != n.length)
        {
          System.out.println("fAIL: rows not equal");
          return false;
        }
        
        if(m[q].length != n[q].length)
        {
          System.out.println("fAIL: cols not equal");
          return false;
        }

        // for(int i=0; i<m.length; i++)
//         {
//           System.out.println("");
//           for(int j=0; j<m[0].length; j++)
//           {
//             System.out.print(m[i][j]);
//           }
//         }
        
       //  for(int i=0; i<n.length; i++)
//         {
//           System.out.println("");
//           for(int j=0; j<n[0].length; j++)
//           {
//             System.out.print(n[i][j]);
//           }
//         }
//         
        for(int i=0; i<m.length; i++)
        {
          for(int j=0; j<m[0].length; j++)
          {
            if(m[i][j] != n[i][j])
            {
              
              System.out.println("Error: The boards are not equal. At row " + i + " and col " + j + " Val: " + m[i][j] + " " + n[i][j]);
              return false;
            }
          }
        }
                
        return true;
    }
    public int numUnoccupied(int[][] b) {
        
        int count = 0;
        
        for(int i=0; i<b.length; i++)
        {
          for(int j=0; j<b[0].length; j++)
          {
            if(b[i][j] == 0)
            {
              count++;
            }
          }
        } 
        
        return count;
    }
    public int[] randCoord(int[][] b, int offset) {
        
        int offsetCnt = -1;
        int[] rtnCoordinate = new int[2];
        
        int a = numUnoccupied(b);
        
        if(a < offset)
        {
          System.out.println("Error: Offset is larger than number of avaliable spaces");
          return new int[] {-1,-1};
        }
        
        if(offset<0)
        {
          System.out.println("Error: Offset is less than 0");
          return new int[] {-1,-1};
        }
        
        for(int i=0; i<b.length; i++)
        {
          for(int j=0; j<b[0].length; j++)
          {
            if(b[i][j] == 0)
            {
              offsetCnt++;
              
              if(offsetCnt == offset)
              {
                rtnCoordinate[0] = i;
                rtnCoordinate[1] = j;
                
                return rtnCoordinate;
              }
            }
          }
        }
        return new int[]{-1, -1};
    }
    public boolean addNewValue(int[][] b) {
      
      int val = Rnd2048.randValue();
      int offset = Rnd2048.randNum(numUnoccupied(b));
      int[] coord = new int[2];
      coord = randCoord(b, offset);
      int coord1 = coord[0];
      int coord2 = coord[1];
      
      b[coord1][coord2] = val;
      
      //System.out.println(coord[0] + " " + coord[1]);
      
          
      return true;
    }
    public int[][] combineLeft(int[][] b) {
        OneDimensional2048 J = new OneDimensional2048();        
        int[][] lol = copyBoard(b);
      //  System.out.println("lol board");
      //  printBoard(lol);
       // System.out.println("B board");
       // printBoard(b);
        
        for(int i=0; i<b.length; i++)
        {
          J.combineLeft(b[i]);
        }

       // System.out.println("B NEW Combined board");        
        //printBoard(b);
        return b;
    }
    public int[][] rotateLeft(int[][] b) {
        
        int row = b.length;
        
        int col = b[0].length;
        int colP = col - 1;
        
        int[][] WOW = new int[col][row];
        
        for(int i=0; i<row; i++)
        {
          for(int j=0; j<col; j++)
          {
            WOW[colP-j][i] = b[i][j];
          }
        } 
        return WOW;

    }
    
    public int[][] left(int[][] b) {      
        
        int[][] temp = new int[b.length][b[0].length];
        for(int i=0; i<b.length; i++)
        {
          for(int j=0; j<b[0].length; j++)
          {
            temp[i][j] = b[i][j];
          }
        }
        
        temp = combineLeft(temp);      
        return temp;
    }
    public int[][] right(int[][] b) {
        
        b = rotateLeft(b);
        b = rotateLeft(b);
        b = combineLeft(b);
        b = rotateLeft(b);
        b = rotateLeft(b); 
        return b;
    }
    public int[][] up(int[][] b) {
       
        b = rotateLeft(b);
        b = combineLeft(b);
        b = rotateLeft(b);       
        b = rotateLeft(b);
        b = rotateLeft(b); 
        //System.out.print("Up complete");
        //printBoard(b);
        return b;

    }
    public int[][] down(int[][] b) {
        b = rotateLeft(b);
        b = rotateLeft(b);       
        b = rotateLeft(b);
        b = combineLeft(b);
        b = rotateLeft(b); 
        return b;
    }

    ////////////////////////optional methods
    public int numMax(int[][] b){
        return 0;
    }
    public int numOccupied(int[][] b){
        return 0;
    }
    public boolean addValue(int[][] b, int x, int y,int val){
        return true;
    }
    public int[][] copyBoard(int[][] b){
        
        int[][] copy = new int[b.length][b[0].length];
        
        for(int i=0; i<b.length; i++)
        {
          for(int j=0; j<b[0].length; j++)
          {
            copy[i][j] = b[i][j];
          }
        }
        return copy;
    }
    public void printBoard(int[][] b){
      for(int i=0; i<b.length; i++)
      {
        System.out.println("");
        for(int j=0; j<b[0].length; j++)
        {
          System.out.print(b[i][j]);
        }
      }
    }
}