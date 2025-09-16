/*
Create a class account with data members (accno, name, balance).
 Create function members
a)getdata() to accept member data from user
b)deposit(float money) to deposit money in account
c)withdraw(float money) to withdraw money from account 
d)display() to show account info
*/



import java.util.Scanner;

class Account {
    int accno;
    String name ;
    float balance;

    void getdata(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account no : ");
        accno = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Balance: ");
        balance = sc.nextFloat();
    }
    void deposit(float money) {
        balance += money;
    }
      void withdraw(float money) {
        if (money <= balance) balance -= money;
        else System.out.println("Insufficient balance!");
    }
    
    void display() {
        System.out.println("AccNo: " + accno + ", Name: " + name + ", Balance: " + balance);
    }
}

public class Q06 {
    public static void main(String[] args) {
        Account a = new Account();
        a.getdata();
        a.deposit(500);
        a.withdraw(200);
        a.display();
    }
}

