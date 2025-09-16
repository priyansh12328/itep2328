//3) WAP to check whether entered character is vowel or not

import java.util.Scanner;

class Q03 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0); 

        //lowercase krne m aata h 
        ch = Character.toLowerCase(ch);

        // Check if vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.println(ch + " is a Vowel.");
        } else {
            System.out.println(ch + " is NOT a Vowel.");
        }

        
    }
}
