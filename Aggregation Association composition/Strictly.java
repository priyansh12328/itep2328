import java.util.Scanner;

class Book {
    int pages;
    String bookName;

    void getData(Scanner sc) {
        System.out.println("Enter no. of pages : ");
        pages = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter bookName : ");
        bookName = sc.nextLine();
    }
}

class Library {
    private Book[] books;   // Library HAS-A Book[]

    // Library will create Book objects itself
    Library(int num, Scanner sc) {
        books = new Book[num];
        for (int i = 0; i < num; i++) {
            books[i] = new Book();
            books[i].getData(sc);
        }
    }

    void showData() {
        System.out.println("\nShow books Details\n");
        System.out.println("BookName\t\tPage Number");
        for (Book bk : books) {
            System.out.println(bk.bookName + "\t" + bk.pages);
        }
    }
}

public class Strictly {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of books : ");
        int num = sc.nextInt();

        Library library = new Library(num, sc);  // Library internally creates Books
        library.showData();
    }
}
