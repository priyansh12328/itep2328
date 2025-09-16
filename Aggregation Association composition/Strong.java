// Strong Composition Example
import java.util.Scanner;

class Book {
    int pages;
    String bookName;

    // Constructor for Book
    Book(Scanner sc) {
        System.out.println("Enter no. of pages : ");
        pages = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter bookName : ");
        bookName = sc.nextLine();
    }
}

class Library {
    private Book[] books;  // Library HAS-A Books

    // Library creates Books internally (Strong Composition)
    Library(int num, Scanner sc) {
        books = new Book[num];
        for (int i = 0; i < num; i++) {
            System.out.println("\nEnter details of Book " + (i + 1));
            books[i] = new Book(sc);  // Book created inside Library
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

class Strong {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of books : ");
        int num = sc.nextInt();
        sc.nextLine();

        // Library itself owns and manages Books
        Library library = new Library(num, sc);
        library.showData();
    }
}
