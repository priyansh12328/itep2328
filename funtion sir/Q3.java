



import java.util.Scanner;

class Q3 {
    
    // Function to check and convert
    void convert(char ch) {
        if (Character.isUpperCase(ch)) {
            char lower = Character.toLowerCase(ch);
            System.out.println("Uppercase entered. Converted to lowercase: " + lower);
        } else {
            System.out.println("Not an uppercase character.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        Q3 obj = new Q3();
        obj.convert(ch);
    }
}
