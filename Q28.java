/*
28.Create a class BankAccount with one data member(balance).
Declare four methods
a)BankAccount() :- which initialize the member function with 0. 
b)void deposit(double amount) :- which adds balance in amount.
c)void withdraw(double amount) :- which deducts balance in amount.
d)double getBalance() :- which returns the balance.
Create a class SavingAccount with two data members(interest_rate and min_balance).

Declare a member function
a) setInterestRate() :- which sets the interest and use the above methods to calculate the account balance.

*/
class BankAccount {
    double balance;

    BankAccount() { balance = 0; }
    void deposit(double amt) { balance += amt; }
    void withdraw(double amt) {
        if (amt <= balance) balance -= amt;
        else System.out.println("Insufficient Balance!");
    }
    double getBalance() { return balance; }
}

class SavingAccount extends BankAccount {
    double interest_rate, min_balance;

    void setInterestRate(double rate, double min) {
        interest_rate = rate;
        min_balance = min;
        if (balance >= min_balance) {
            balance += (balance * interest_rate / 100);
        }
    }
}

public class Q28 {
    public static void main(String[] args) {
        SavingAccount sa = new SavingAccount();
        sa.deposit(10000);
        sa.setInterestRate(5, 2000);
        System.out.println("Balance after Interest = " + sa.getBalance());
    }
}
