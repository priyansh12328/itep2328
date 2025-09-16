/*
25.Create a class Publication with two data members (title and price).Declare two member function:-
a)getData():- for accepting data from user.
b)putData():- for displaying data.

Create another class Sales with three data member ((s1,s2,s3) which accepts the sales of three months).
Declare two member function :-
a)getSales():- for accepting three month sales. 
b)showsales():- for displaying sales.

Create one more class Book with one data member (pages).
Declare two member function :- 
a)getBookDetail():- which accepts the book details which includes title, price, sales and pages. 
b)showBookDetail():- which displays the book details which includes title, price, sales and pages.

*/

class Publication {
    String title;
    double price;

    void getData(String t, double p) { title = t; price = p; }
    void putData() { System.out.println("Title: " + title + ", Price: " + price); }
}

class Sales {
    double s1, s2, s3;
    void getSales(double a, double b, double c) { s1 = a; s2 = b; s3 = c; }
    void showSales() { System.out.println("Sales: " + s1 + ", " + s2 + ", " + s3); }
}

class Book extends Publication {
    int pages;
    Sales sales = new Sales();

    void getBookDetail(String t, double p, int pg, double s1, double s2, double s3) {
        getData(t, p);
        pages = pg;
        sales.getSales(s1, s2, s3);
    }

    void showBookDetail() {
        putData();
        sales.showSales();
        System.out.println("Pages: " + pages);
    }
}

public class Q25 {
    public static void main(String[] args) {
        Book b = new Book();
        b.getBookDetail("Java Programming", 450.0, 350, 1200, 1500, 1800);
        b.showBookDetail();
    }
}
