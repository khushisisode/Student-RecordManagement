import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUDMain {
    static ArrayList<Learner> learners = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Learner Management System ---");
            System.out.println("1. Add Learner");
            System.out.println("2. View Learners");
            System.out.println("3. Update Learner");
            System.out.println("4. Delete Learner");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addLearner();
                case 2 -> viewLearners();
                case 3 -> updateLearner();
                case 4 -> deleteLearner();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);
    }

    static void addLearner() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        learners.add(new Learner(id, name, marks));
        System.out.println("Learner added successfully.");
    }

    static void viewLearners() {
        if (learners.isEmpty()) {
            System.out.println("No learners found.");
        } else {
            for (Learner l : learners) {
                System.out.println(l);
            }
        }
    }

    static void updateLearner() {
        System.out.print("Enter Learner ID to update: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Learner l : learners) {
            if (l.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                l.setName(sc.nextLine());
                System.out.print("Enter new marks: ");
                l.setMarks(sc.nextInt());
                System.out.println("Learner updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Learner not found.");
        }
    }

    static void deleteLearner() {
        System.out.print("Enter Learner ID to delete: ");
        int id = sc.nextInt();
        boolean removed = learners.removeIf(l -> l.getId() == id);
        if (removed) {
            System.out.println("Learner deleted successfully.");
        } else {
            System.out.println("Learner not found.");
        }
    }
}
