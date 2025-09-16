import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    void setData(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of Patient " + (i + 1));
        id = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter name of the Patient " + (i + 1));
        name = sc.nextLine();

        System.out.println("Enter age of the Patient " + (i + 1));
        age = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter disease of the Patient " + (i + 1));
        disease = sc.nextLine();
    }

    void getData(int i) {
        System.out.println("The id of Patient " + (i + 1) + " : " + id);
        System.out.println("Name of the Patient " + (i + 1) + " : " + name);
        System.out.println("Age of the Patient " + (i + 1) + " : " + age);
        System.out.println("Disease of the Patient " + (i + 1) + " : " + disease);
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    void setData(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of Doctor " + (i + 1));
        id = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter name of the Doctor " + (i + 1));
        name = sc.nextLine();

        System.out.println("Enter specialization of the Doctor " + (i + 1));
        specialization = sc.nextLine();
    }

    void getData(int i) {
        System.out.println("id of Doctor " + (i + 1) + " : " + id);
        System.out.println("Name of Doctor " + (i + 1) + " : " + name);
        System.out.println("Specialization of the Doctor " + (i + 1) + " : " + specialization);
    }
}

class Medicine {
    int id;
    String name;
    int price;

    void setData(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of Medicine " + (i + 1));
        id = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter name of the Medicine " + (i + 1));
        name = sc.nextLine();

        System.out.println("Enter price of the Medicine " + (i + 1));
        price = sc.nextInt();
    }

    void getData(int i) {
        System.out.println("id of Medicine " + (i + 1) + " : " + id);
        System.out.println("Name of Medicine " + (i + 1) + " : " + name);
        System.out.println("Price of Medicine " + (i + 1) + " : " + price);
    }
}

class hospitalmanagement1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of patients ");
        int nP = sc.nextInt();
        Patient p[] = new Patient[nP];
        int pCount = 0;

        System.out.println("Enter no of Doctor ");
        int nD = sc.nextInt();
        Doctor d[] = new Doctor[nD];
        int dCount = 0;

        System.out.println("Enter no of Medicines ");
        int nM = sc.nextInt();
        Medicine m[] = new Medicine[nM];
        int mCount = 0;

        while (true) {
            System.out.println("\n--- Hospital Management Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Add Doctor");
            System.out.println("5. Display Doctors");
            System.out.println("6. Search Doctor by ID");
            System.out.println("7. Add Medicine");
            System.out.println("8. Display Medicines");
            System.out.println("9. Search Medicine by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Add Patient
                    if (pCount < nP) {
                        p[pCount] = new Patient();
                        p[pCount].setData(pCount);
                        pCount++;
                    } else {
                        System.out.println("Patient list is full!");
                    }
                    break;

                case 2: // Display Patients
                    if (pCount == 0) {
                        System.out.println("No patients found!");
                    } else {
                        for (int i = 0; i < pCount; i++) {
                            System.out.println("\nDetails of Patient " + (i + 1));
                            p[i].getData(i);
                        }
                    }
                    break;

                case 3: // Search Patient by ID
                    System.out.println("Enter the id of patient to search: ");
                    int pid = sc.nextInt();
                    boolean foundP = false;
                    for (int i = 0; i < pCount; i++) {
                        if (p[i].id == pid) {
                            p[i].getData(i);
                            foundP = true;
                        }
                    }
                    if (!foundP) System.out.println("Patient not found!");
                    break;

                case 4: // Add Doctor
                    if (dCount < nD) {
                        d[dCount] = new Doctor();
                        d[dCount].setData(dCount);
                        dCount++;
                    } else {
                        System.out.println("Doctor list is full!");
                    }
                    break;

                case 5: // Display Doctors
                    if (dCount == 0) {
                        System.out.println("No doctors found!");
                    } else {
                        for (int i = 0; i < dCount; i++) {
                            System.out.println("\nDetails of Doctor " + (i + 1));
                            d[i].getData(i);
                        }
                    }
                    break;

                case 6: // Search Doctor by ID
                    System.out.println("Enter the id of Doctor to search: ");
                    int did = sc.nextInt();
                    boolean foundD = false;
                    for (int i = 0; i < dCount; i++) {
                        if (d[i].id == did) {
                            d[i].getData(i);
                            foundD = true;
                        }
                    }
                    if (!foundD) System.out.println("Doctor not found!");
                    break;

                case 7: // Add Medicine
                    if (mCount < nM) {
                        m[mCount] = new Medicine();
                        m[mCount].setData(mCount);
                        mCount++;
                    } else {
                        System.out.println("Medicine list is full!");
                    }
                    break;

                case 8: // Display Medicines
                    if (mCount == 0) {
                        System.out.println("No medicines found!");
                    } else {
                        for (int i = 0; i < mCount; i++) {
                            System.out.println("\nDetails of Medicine " + (i + 1));
                            m[i].getData(i);
                        }
                    }
                    break;

                case 9: // Search Medicine by ID
                    System.out.println("Enter the id of Medicine to search: ");
                    int mid = sc.nextInt();
                    boolean foundM = false;
                    for (int i = 0; i < mCount; i++) {
                        if (m[i].id == mid) {
                            m[i].getData(i);
                            foundM = true;
                        }
                    }
                    if (!foundM) System.out.println("Medicine not found!");
                    break;

                case 0:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
