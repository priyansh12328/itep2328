/*
5.Write a program to Define a class TEST in java 
with following description: Private Members
TestCode of type integer 
Description of type string
Candidates of type integer (total candidates appearing) 
CenterReqd (number of centers required) of type integer
*/

import java.util.Scanner;
 class Test {
    private int testcode , candidates,  centerReqd;
    private  String description;
     
     private int calcCenter(){
        return(int) Math.ceil(candidates/50.0);

     } 
     public void schedule(){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter Test code ");

        testcode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a description : ");
        description = sc.nextLine();
         
          System.out.print("enter Candidate:");
          candidates = sc.nextInt();
          centerReqd = calcCenter();


     }

     public void displayTest(){
        System.out.println("Test Code: " + testcode);
        System.out.println("Description: " + description);
        System.out.println("Candidates: " + candidates);
        System.out.println("Centers Required: " + centerReqd);
     }
 }
 
 class Q05 {
    public static void main(String args[]) {
        Test t = new Test();
        t.schedule();
        t.displayTest();
    }
}