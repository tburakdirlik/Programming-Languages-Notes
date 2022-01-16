/*
                                                                     PROBLEM

Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine 
if the string is a valid username according to the following rules:

1. The username is between 4 and 25 characters.
2. It must start with a letter.
3. It can only contain letters, numbers, and the underscore character.
4. It cannot end with an underscore character.

If the username is valid then your program should return the string true, otherwise return the string false.
Examples
Input: "aa_"
Output: false
Input: "u__hello_world123"
Output: true
Tags

*/
//                                                                    SOLVE

import java.util.*; 
import java.io.*;

class Main {

  public static boolean CodelandUsernameValidation(String str) {
   
    boolean lengthControl = false;
    boolean startLetter= false;
    boolean letterNumberUnderscoreControl= false;
    boolean lastcharControl = false;
    boolean result = false;
    
    char  letter [] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','y','z','w','x','q',
                       'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','Y','Z','Q','W','X'
    };
    
    char all [] =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','y','z','w','x','q',
                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','Y','Z','Q','W','X', 
                    '0','1','2','3','4','5','6','7','8','9','_'
    };
    
    //1st statement
    if (str.length() >= 4 && str.length() <=25){
        lengthControl = true;
    }
    //2nd statement
    for (int i =0; i< letter.length; i++){
        if (str.charAt(0) == letter[i]){
            startLetter = true;
        }
    }
    //3rd statement
    for (int i=0; i< all.length; i++){
        for (int j=0; j< str.length(); j++){
            if (str.charAt(j) == all [i]){
                letterNumberUnderscoreControl = true;
            }
        }
    }
    //4th statement
    if (str.charAt(str.length()-1) != '_'){
        lastcharControl = true;
    }
    //CONTROLS OF ALL STATEMENTS 
    if (lengthControl == true && startLetter == true && letterNumberUnderscoreControl==true  && lastcharControl == true ){
        result = true;
    }
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(CodelandUsernameValidation(s.nextLine())); 
  }
}
