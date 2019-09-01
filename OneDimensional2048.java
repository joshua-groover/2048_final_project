public class OneDimensional2048 implements OneDimensional 
{
  // Fill-in methods to implement the OneDimensional interface
  public  boolean identicalRows(int[] row1, int[] row2) 
  {
    //your code here
    if(row1.length != row2.length)
    {
      return false;
    }
    
    int flag = 0;
    for(int i=0; i<row1.length; i++)
    {
      if(row1[i] == row2[i])
      {
        flag = flag+1;
      }
    }
    //System.out.println(flag);
     if(flag == row1.length)
     {
       return true;
     }
    
    return false;
  }


  public  boolean validateValue(int val, int maxPowerOfTwo)
  {
    //your code here
    
    int thresh = 0;
    
    //check if val is equal to 0, if it is return tru
    if(val == 0)
    {
      return true;
    }
    
    //run a for loop to check for every possible value of 2squared btween 2 and 2048
    for(int i=1; i<12; i++)
    {
      thresh = 2;
      
      //run a for loop to get 2^i (so that you can check if the val equals one of the 2s squared
      for(int j=1; j<i; j++)
      {
        thresh = thresh*2;
      }
      
      //if val is equal to one of the 2^is between 2 and 2048 and val is less than or equal to max, return true
      if((val == thresh) && (val <= maxPowerOfTwo))
      {
        return true;
      }
    }
    //This return is a default
    return false;
  }

  public  boolean validateRow(int[] row) 
  {
    
    OneDimensional2048 d =new OneDimensional2048();
    int max=2048;
    //your code here
    
    //Check to ensure each character is valid
    for(int i=0; i<row.length; i++)
    {
      if(!d.validateValue(row[i], max))
      {
        return false;
      }
    }
    //This return is a default
    return true;
  }

  public  boolean moveLeft(int[] row) 
  {
    //your code here
    OneDimensional2048 d =new OneDimensional2048();
    
    int l = row.length;
    
    //check to ensure row is valid
    if(!d.validateRow(row))
    {
      return false;
    }
    
    //use one counter to keep track of how many positions are filled by a non-zero number, when a number is not zero set it equal to the space and increment counter by 1
    //use second counter to keep track of number of zeros
    int cnt1 = 0;
    int cnt2 = 0;
    for(int i=0; i<l; i++)
    {
      if(row[i] !=0)
      {
        row[cnt1] = row[i];
        cnt1++;
      }
      
      else
      {
        cnt2++;
      }
    }
    
    // for(int k=0; k<l; k++)
//     {
//       System.out.print(row[k]);
//     }
    
    int disp = l-cnt2;
    
   
    //set the end of the array (the 
    for(int j=0; j<cnt2; j++)
    {
      row[disp+j] = 0;
    }
    
    // for(int m=0; m<l; m++)
//     {
//       System.out.print(row[m]);
//     }
    
    //This return is a default, write your code here
    return true;
  }

  public  boolean combineLeft(int[] row) 
  {
    //your code here
    OneDimensional2048 d =new OneDimensional2048();
    
    if(!d.validateRow(row))
    {
      return false;
    }
    
    d.moveLeft(row);
    
    for(int i=0; i<(row.length-1); i++)
    {
      if(row[i] == row[i+1])
      {
        row[i] = 2*row[i];
        
        for(int j=1; j<(row.length-i-1); j++)
        {
          row[i+j] = row[i+j+1];
        }
        row[row.length-1]=0;
      }
    }

    //This return is a default, write your code here
    return true;
  }

  public static void main(String[] argc) 
  {
    int[] row;
    // These asserts have no message as output but will cause exeptions and highlight the line.
    // feel free to add messages to help you debug.
    OneDimensional2048 d =new OneDimensional2048();
    assert(!d.validateValue(8, 4));
    assert(d.validateValue(8, 8));
    assert(d.validateValue(8, 16));
    assert(d.validateValue(0, 16));
    assert(d.validateValue(2, 2048));
    assert(!d.validateValue(7, 2048));
    assert(!d.validateValue(1023, 2048));
    assert(!d.validateValue(1025, 2048));

    assert(d.validateRow(new int[]{2, 2, 2, 2}));
    assert(d.validateRow(new int[]{0, 2, 4, 0, 32}));
    assert(!d.validateRow(new int[]{2, 2, 0, 3, 4, 0}));
    assert(d.validateRow(new int[]{}));
    assert(!d.validateRow(new int[]{8, 2, 64, 32, 30}));

    row = new int[]{0,0,4,0,0};
    assert(d.identicalRows(new int[]{4,0,0,0,0}, new int[]{4,0,0,0,0}));
    assert(d.moveLeft(row) && d.identicalRows(new int[]{4,0,0,0,0}, row));
    row = new int[]{0,0,4,0,0};
    assert(d.moveLeft(row) && !d.identicalRows(new int[]{4,0,0,0,0,0}, row));
    row = new int[]{2,0,4,0,0,16};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{2,4,16,0,0,0}, row));
    row = new int[]{0,0,0};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{0,0,0}, row));
    assert(!d.moveLeft(new int[]{2,0,31}));
    row = new int[]{4,16,2048};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{4,16,2048}, row));

    row = new int[]{8,8,16,16,32,32};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{16,32,64,0,0,0}, row));
    row = new int[]{2,0,2,8,0,8,64,0,64,0};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{4,16,128,0,0,0,0,0,0,0}, row));
    row = new int[]{2,0,8,2,0,64,4,0,64,0};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
    row = new int[]{2,0,8,2,0,64,4,0,64,0};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
    row = new int[]{0,0,2,2,128,64,0,64};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{4,128,128,0,0,0,0,0}, row));
    row = new int[]{0,0,2,2,128,1234,64,0,64};
    assert(!d.combineLeft(row));
    row = new int[]{};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{}, row));

    row = new int[]{0,1024,512,256,128,64,32,16,8,4,2,0,2,0};
    assert(d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) &&
            d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) &&
            d.  combineLeft(row) && d.combineLeft(row) && d.identicalRows(new int[]{2048,0,0,0,0,0,0,0,0,0,0,0,0,0}, row));
  }

}