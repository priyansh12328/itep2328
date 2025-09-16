import java.io.IOException;

public class one {

    public static String readPassword(String prompt) throws IOException {
        System.out.print(prompt);
        StringBuilder password = new StringBuilder();

        while (true) {
            int ch = System.in.read();

            // Enter key (newline) => break
            if (ch == '\n' || ch == '\r') {
                break;
            }

            // Backspace handle
            if (ch == 8 || ch == 127) { 
                if (password.length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    System.out.print("\b \b"); // cursor back, space, back
                }
            } else {
                password.append((char) ch);
                System.out.print("*"); // show star instead of char
            }
        }

        System.out.println();
        return password.toString();
    }

    public static void main(String[] args) throws IOException {
        String pass = readPassword("Enter Password: ");
        System.out.println("Captured Password: " + pass);
    }
}
