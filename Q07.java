/*
7.Store six user’s account information using class created
 in above problem and calculate
-total money deposited in all accounts
-list all account number with balance greater than 1000
*/

public class Q07 {
    public static void main(String[] args) {
        Account[] arr = new Account[6];
        float total = 0;

        for (int i = 0; i < 6; i++) {
            arr[i] = new Account();
            arr[i].getdata();
            total += arr[i].balance;
        }

        System.out.println("Total money deposited: " + total);
        System.out.println("Accounts with balance > 1000:");
        for (Account a : arr) {
            if (a.balance > 1000) {
                System.out.println("AccNo: " + a.accno);
            }
        }
    }
}
