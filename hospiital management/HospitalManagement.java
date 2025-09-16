import java.util.Scanner;

// ---------------- Patient Class ----------------
class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Disease: " + disease);
    }
}

// ---------------- Doctor Class ----------------
class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Specialization: " + specialization);
    }
}

// ---------------- Medicine Class ----------------
class Medicine {
    int id;
    String name;
    double price;

    Medicine(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Price: Rs." + price);
    }
}

// ---------------- Main Hospital Management Class ----------------
public class HospitalManagement {
    static Scanner sc = new Scanner(System.in);

    // Arrays of objects
    static Patient[] patients = new Patient[100];
    static Doctor[] doctors = new Doctor[100];
    static Medicine[] medicines = new Medicine[100];

    // Counters
    static int pCount = 0, dCount = 0, mCount = 0;

    // ---------------- Add Methods ----------------
    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients[pCount++] = new Patient(id, name, age, disease);
        System.out.println("Patient added successfully!");
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors[dCount++] = new Doctor(id, name, specialization);
        System.out.println(" Doctor added successfully!");
    }

    static void addMedicine() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Medicine Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        medicines[mCount++] = new Medicine(id, name, price);
        System.out.println(" Medicine added successfully!");
    }

    // ---------------- Display Methods ----------------
    static void displayPatients() {
        if (pCount == 0) System.out.println("No Patients available.");
        else {
            System.out.println("\n--- Patient List ---");
            for (int i = 0; i < pCount; i++) patients[i].display();
        }
    }

    static void displayDoctors() {
        if (dCount == 0) System.out.println("No Doctors available.");
        else {
            System.out.println("\n--- Doctor List ---");
            for (int i = 0; i < dCount; i++) doctors[i].display();
        }
    }

    static void displayMedicines() {
        if (mCount == 0) System.out.println("No Medicines available.");
        else {
            System.out.println("\n--- Medicine List ---");
            for (int i = 0; i < mCount; i++) medicines[i].display();
        }
    }

    // ---------------- Search Methods ----------------
    static void searchPatientById(int id) {
        for (int i = 0; i < pCount; i++) {
            if (patients[i].id == id) {
                patients[i].display();
                return;
            }
        }
        System.out.println(" Patient not found!");
    }

    static void searchDoctorById(int id) {
        for (int i = 0; i < dCount; i++) {
            if (doctors[i].id == id) {
                doctors[i].display();
                return;
            }
        }
        System.out.println(" Doctor not found!");
    }

    static void searchMedicineById(int id) {
        for (int i = 0; i < mCount; i++) {
            if (medicines[i].id == id) {
                medicines[i].display();
                return;
            }
        }
        System.out.println(" Medicine not found!");
    }

    // ---------------- Main Menu ----------------
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n====== Hospital Management System ======");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Medicine");
            System.out.println("4. Display Patients");
            System.out.println("5. Display Doctors");
            System.out.println("6. Display Medicines");
            System.out.println("7. Search Patient by ID");
            System.out.println("8. Search Doctor by ID");
            System.out.println("9. Search Medicine by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: addDoctor(); break;
                case 3: addMedicine(); break;
                case 4: displayPatients(); break;
                case 5: displayDoctors(); break;
                case 6: displayMedicines(); break;
                case 7:
                    System.out.print("Enter Patient ID: ");
                    searchPatientById(sc.nextInt());
                    break;
                case 8:
                    System.out.print("Enter Doctor ID: ");
                    searchDoctorById(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Enter Medicine ID: ");
                    searchMedicineById(sc.nextInt());
                    break;
                case 0: System.out.println("Exiting System..."); break;
                default: System.out.println(" Invalid choice!");
            }
        } while (choice != 0);
    }
}
    