/*

34. Create a class Person with properties (name and age) with following features.
a. Default age of person should be 18;
b. A person object can be initialized with name and age;
c. Method to display name and age of person34. 
Create and use copy constructor for above problem.
*/
class Person {
    String name;
    int age;

    Person() { 
        age = 18; 
        }

    Person(String n, int a) {
     name = n; age = a; 
     }

    Person(Person p) { 
        this.name = p.name; this.age = p.age;
         }

    void display() {
         System.out.println("Name: " + name + ", Age: " + age); 
         }
}

public class Q34 {
    public static void main(String[] args) {
        Person p1 = new Person("roni", 25);
        Person p2 = new Person(p1);
        p1.display();
        p2.display();
    }
}
