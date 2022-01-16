/*

First Factorial
Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it. 
For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24. 
For the test cases, the range will be between 1 and 18 and the input will always be an integer.

Examples
Input: 4
Output: 24
Input: 8
Output: 40320

*/

import java.util.*; 
import java.io.*;

class Main {

  public static int FirstFactorial(int num) {
  
  int result = 1;
   for (int i=1; i<=num; i++){
     result = result*i;
   }  
      
    return result;
  }

  public static void main (String[] args) {  
    
    Scanner s = new Scanner (System.in);
    System.out.println(FirstFactorial(Integer.valueOf(s.nextLine())));
  }

}