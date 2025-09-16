/*
22.Create a class FourWheeler with two data member(category and amount).Declare two members functions.
a)char getCategory() :- which returns category
b)int getamount():- which returns amount

Create another class Car with two data members (brand and model).
Declare two member function:- 
a)getDetail():- which accepts the brand, model, category and amount of a Car
b)showDetail():- which displays the category, amount, brand and model.
*/
class FourWheeler {
    private char category;
    private int amount;

    FourWheeler(char c, int a) {
        category = c;
        amount = a;
    }

    char getCategory() { return category; }
    int getAmount() { return amount; }
}

class Car {
    private String brand, model;
    private FourWheeler fw;

    void getDetail(String b, String m, char c, int a) {
        brand = b;
        model = m;
        fw = new FourWheeler(c, a);
    }

    void showDetail() {
        System.out.println("Category: " + fw.getCategory() + 
                           ", Amount: " + fw.getAmount() + 
                           ", Brand: " + brand + 
                           ", Model: " + model);
    }
}

public class Q22 {
    public static void main(String[] args) {
        Car c = new Car();
        c.getDetail("Hyundai", "i20", 'A', 750000);
        c.showDetail();
    }
}
