//java prgram 
// extract a digti in generaliize manner 
//enter any interger = 5678
/*
outbut be like 
digits at position 4:8
digits at position 3:7 
digits at position 2:6
digits at  position 1:5

*/
import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number
        System.out.print("Enter any integer: ");
        int num = sc.nextInt();
        
        // Convert number to string to easily access digits
        String str = Integer.toString(num);  // to string is use for no to string 
        int length = str.length();   // total digits lenghth 
        
        // Loop for last to first forn printing piche se aage 
        for (int i = length - 1; i >= 0; i--) { 
            char digit = str.charAt(i);  // extract digit
            int position = i + 1;        // position from left 
            
            System.out.println("Digit at position " + position + ": " + digit);
        }
        
        
    }
}


    
