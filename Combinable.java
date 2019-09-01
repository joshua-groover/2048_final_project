import java.lang.*;

public interface Combinable
{
  // Validate each Char
  public boolean validateChar(char ch);
  
  // Validate each Char in row with size 3
  public boolean validateRow(String row);
  
  // Moving the Row to the left "_24" > "24_" or "__2" > "2__"
  public String moveLeft(String row);
  
  // This Method validates the row and then takes the String row 
  // and combines pairs of 2's or 4's and shifts to the left
  public String combineLeft(String row);
  
}