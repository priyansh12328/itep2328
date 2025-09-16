/*
write a class book with autor  name edition year and page no and create a array of 3 bok obj and find out 
the name of bookwhich have highest no of pages*/



import java.util.Scanner;

class book  {
    String Author;
    int year;
    int pages;

    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the author name: ");
        Author = sc.nextLine();
        
        System.out.print("Enter the editon year : ");
       year = sc.nextInt();
        System.out.print("Enter n of pages in book: ");
        pages  = sc.nextInt();
    }
        void display() {
        System.out.println(Author + "\t" + year + "\t\t" + pages);
    }
}
class Q12 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the no of book you have : ");
        int size = sc.nextInt();
        book bobj[] = new book[size];


        //loop used for the book details 
        for (int i = 0; i < size; i++) {
            bobj[i] = new book();
            bobj[i].getData();
        }

        // Displaying all books we entered forshow 
        System.out.println("\nbook Details\n");
        for (book b : bobj)
            b.display();
                   

        book maxbook = bobj[0];
        

        // Fin
        for (int i = 1; i <bobj.length; i++) {
            if (bobj[i].pages > maxbook.pages) {
                maxbook = bobj[i];
            }
            
        }

            System.out.println(    "higest no of book " +maxbook.pages);


    }


}