class stringMethods {
   public String findChar (String text, int ind){
   
   //Write your Code here
     int lInd = ind + 1;
     int l = text.length();
     
     if (l < lInd) 
     { 
       String error = "none";
       return error;
     }
     
     else 
     {
       String m = text.substring(ind, lInd);
       return m;
     }
   }
   
   
   public boolean userChecker (String newUser, String oldUser)
   {
     //Write your Code here
     
     String one = "1";
     String two = "2";
     String three = "3";
     String four = "4";
     
     if ( newUser.contains(one) || newUser.contains(two) || newUser.contains(three) || newUser.contains(four))
     {
       //checking if newUser contains 1-4 complete
       
       //checking if string does not contain !@?
       String excl = "!";
       String at = "@";
       String q = "?";
       String sp = " ";
       
       if((!newUser.contains(excl)) && (!newUser.contains(at)) && (!newUser.contains(q)))
       {
         //true for checking !, ?, ?
         
         //checking if char @ 0 is an integer
         
         char rj0 = '0';
         char rj1 = '1';
         char rj2 = '2';
         char rj3 = '3';
         char rj4 = '4';
         char rj5 = '5';
         char rj6 = '6';
         char rj7 = '7';
         char rj8 = '8';
         char rj9 = '9';
         
         int charCheckPos = 0;
         char ch = newUser.charAt(charCheckPos);
         
         if ( (!(ch == rj0)) || (!(ch == rj1)) || (!(ch == rj2)) || (!(ch == rj3)) || (!(ch == rj4)) || (!(ch == rj5)) || (!(ch == rj6)) || (!(ch == rj7)) || (!(ch == rj8)) || (!(ch == rj9)))  
         {
           //checking if the integer is in the first position complete
           
           //check is newUser is equal to oldUser
           if(newUser != oldUser)
           {
             //check if newUser = oldUser complete
             return true;
           }
         }
       }
     }
     return false;
   }
   
   public boolean urlChecker (String url){
      
      //Write your Code here
      String com = ".com";
      String net = ".net";
      String edu = ".edu";
      String sp = " ";
      
      //check if url contains com, net or edu
      if (url.contains(com) || url.contains(net) || url.contains(edu))
      {
        
        //check is url contains a space
        if (!url.contains(sp))
        {
          return true;
        }
      }
      
      return false;

   }
   
   public String lengString (String text){
      
   //Write your Code here
     int l = text.length();
     String length = Integer.toString(l);
     return length;
   }
   
   public String emailGen (String text){
   
         //Write your Code here

     int spaceLoc = text.indexOf(' ');
     int lastNameStart = spaceLoc + 1;
     int l = text.length();
     
     char firstLetter = text.charAt(0);
     String lastName = text.substring(lastNameStart, l);
     String email = "info@" + firstLetter + lastName + ".com"; 
     return email;
   }
   
   public String domainGen (String text){
     int spaceLoc = text.indexOf(' ');
     int lastNameStart = spaceLoc + 1;
     int l = text.length();
     
     String firstName = text.substring(0, spaceLoc).toLowerCase();
     String lastName = text.substring(lastNameStart, l).toLowerCase();
     String url = "www." + firstName + "-" + lastName + ".com"; 
     return url;

   }
}
public class Stringfunc{
   public static void main(String[] args){
      
      stringMethods M1=new stringMethods();
      String s="CS1111 is the best class that I have ever taken.";
      assert "none".equals(M1.findChar(s,100)) : "100 is larger than the length of the string";
      assert "t".equals(M1.findChar(s,10)) : "The character in the 10th place should be S";
      assert "1".equals(M1.findChar(s,2)) : "The character in the 3d place should be 1";
      
      //User Check
      
      String username="user one 23";
      assert M1.userChecker(username,""): "User has space and not accepted";
      username="userone1234?!";
      assert !M1.userChecker(username,""): "user is accepted";
      username="";
      assert !M1.userChecker(username,""): "Empty username is not accepted";
      username="User1";
      assert !M1.userChecker(username,"User1"): "username is already taken";

      //URL Check
      String url="http:\\www.gwu. edu";
      assert !M1.urlChecker(url): "url contains a space";
      url="http:\\www.gwu.edu";
      assert M1.urlChecker(url): "url not verfied";
      url="www.gwu.edu";
      assert M1.urlChecker(url): "url not verfied";
      url="ww.gwuedu";
      assert !M1.urlChecker(url): "url verfied by mistake";
      url="http:\\ww.gwuedu";
      assert !M1.urlChecker(url): "url verfied by mistake";
      //casting 
      
      assert "3".equals(M1.lengString("ABC")): "ABC length is 3";
      assert "6".equals(M1.lengString("ABCDEF")): "ABCDEF length is 6";
      assert "7".equals(M1.lengString("ABCDEF1")): "ABCDEF1 length is 7";
      
      //String gen
      String name ="Magic Johnson";
      assert "info@MJohnson.com".equals(M1.emailGen(name)): "name is not converted to the email address properly";
      assert "www.magic-johnson.com".equals(M1.domainGen(name)):"name is not converted to the domain address properly";
   }
}