class Combine implements Combinable {

  // Validate each Char
  public boolean validateChar(char ch)
  {
    char ac1 = '_';
    char ac2 = '2';
    char ac3 = '4';
    
    if (ch == ac1 || ch == ac2 || ch == ac3)
    {
      return true;
    }
   
    else
    {
      return false;
    }
  }
  
  // Validate each Char in row with size 3
  public boolean validateRow(String row)
  {
    int l = row.length();
    
    if (l == 3)
    {
      String pos1 = row.substring(0, 1);
      String pos2 = row.substring(1, 2);
      String pos3 = row.substring(2,3);
      String sp = "_";
      String two = "2";
      String four = "4";

      //check if the first number is valid
      if (pos1.equals(sp) || pos1.equals(two) || pos1.equals(four))
      {
        //check if the second entry is valid
        if (pos2.equals(sp) || pos2.equals(two) || pos2.equals(four))
        {
          //check if the third entry is valid
          if (pos3.equals(sp) || pos3.equals(two) || pos3.equals(four))
          {
            return true;
          }
        }
      }
      
    }
    
    //System.out.println("false on verification of the numbers");
    return false;
    
  }
  
  // Moving the Row to the left "_24" > "24_" or "__2" > "2__"
  public String moveLeft(String row)
  {
    Combine A = new Combine(); 
    
    if(A.validateRow(row) == true)
    {
      String pos1 = row.substring(0, 1);
      String pos2 = row.substring(1, 2);
      String pos3 = row.substring(2,3);
      String leBlanc = "_";
      String two = "2";
      String four = "4";
      String returnVal = "";
      
      //check is first entry is leBlank
      if (pos1.equals(leBlanc))
      {
        
        //check if second entry is leBlank
        if (pos2.equals(leBlanc))
        {
          returnVal = pos3 + "__";
          return returnVal;
        }
        
        //check if third entry is leBlank
        if (pos3.equals(leBlanc))
        {
          returnVal = pos2 + "__";
          return returnVal;
        }
        
        returnVal = pos2 + pos3 +"_";
        return returnVal;
      }
      
      //check if second entry blank
      if (pos2.equals(leBlanc))
      {
        returnVal = pos1 + pos3 + "_";
        return returnVal;
      }
      
      else 
      {
        returnVal = pos1 + pos2 + pos3;
        return returnVal;
      }
    }
    else
    {
      return row;
    }

  }
  
  // This Method validates the row and then takes the String row 
  // and combines pairs of 2's or 4's and shifts to the left
  public String combineLeft(String row)
  {
    Combine A = new Combine(); 
    
    if(A.validateRow(row) == true)
    {
      String newRow = A.moveLeft(row);
      String pos1 = newRow.substring(0, 1);
      String pos2 = newRow.substring(1, 2);
      String pos3 = newRow.substring(2,3);
      String leBlanc = "_";
      String two = "2";
      String four = "4";
      String eight = "8";
      String stringVal = "";
      String returnVal = "";
      
      //check if first and second positions are the same
      if (pos1.equals(pos2))
      {
        //check if the positions are empty
        if (pos1.equals(leBlanc))
        {
          return newRow;
        }
        
        //check if the first pos is two then make the first input 4
        else if (pos1.equals(two))
        {
          stringVal = four + pos3 + "_";
          
          //check if the third input is 4 and if it is make the first input 8
          if (pos3.equals(four))
          {
            stringVal = eight + "__";
            return stringVal;
          }
          
          else
          {
            return stringVal;
          } 
          
        }
       
        //first val is equal to 4
        else
        {
          stringVal = eight + pos3 + "_";
          return stringVal;
        }

      }
      
      //check if the second and third enteries are the same
      else if (pos2.equals(pos3))
      {
        //check if the positions are empty
        if (pos2.equals(leBlanc))
        {
          stringVal = pos1 + "__";
          return stringVal;
        }
        
        //check if the first pos is two then make the first input 4
        else if (pos2.equals(two))
        {
          stringVal = pos1 + four + "_";
          
          //check if the third input is 4 and if it is make the first input 8
          if (pos1.equals(four))
          {
            stringVal = eight + "__";
            return stringVal;
          }
          
          else
          {
            return stringVal;
          } 
          
        }
       
        //first val is equal to 4
        else
        {
          stringVal = pos1 + eight + "_";
          return stringVal;
        }
      }
      else
      {
        return newRow;
      }
    }
    
    else
    {
      return row;
    }
  }
  

  // The main is used to test your code
  public static void main(String[] args)
  {
    // The following are asserts used to test your code
    Combine A = new Combine(); 
    
    assert A.validateChar('2')    : "2 should be a valid char";
    assert A.validateChar('4')    : "4 should be a valid char";
    assert A.validateRow("242")   : "242 should be valid";
    assert !A.validateRow("246")   : "246 should NOT be valid";
    assert "4__".equals(A.moveLeft("__4")) : "__4 doesn't change to 4__";
    assert "24_".equals(A.moveLeft("2_4")) : "2_4 doesn't change to 24_";
    assert "242".equals(A.combineLeft("242")) : "242 doesn't change to 242";
    assert "4__".equals(A.combineLeft("22_")) : "22_ doesn't change to 4__";
    assert "8__".equals(A.combineLeft(A.combineLeft("422"))) : "Double invocation doesn't work!";
    assert "84_".equals(A.combineLeft(A.combineLeft("444"))) : "Double invocation doesn't work!";
    assert "4__".equals(A.combineLeft("_22")) : "0";
    assert "4__".equals(A.combineLeft("2_2")) : "1";
    assert "4__".equals(A.combineLeft("_4_")) : "2";
    assert "_8_".equals(A.combineLeft("_8_")) : "2";
    assert "___".equals(A.combineLeft("___")) : "2";

    //You should be using your own validation asserts to check for erroneous inputs!
    assert "__".equals(A.combineLeft("__"))     : "__ should be invalid!";
    
    System.out.println("All tests passed.  VICTORY!");
  }

}    
