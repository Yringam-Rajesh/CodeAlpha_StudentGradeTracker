package StudentGradeTracker;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Average Score");
            System.out.println("4. Find Highest Score");
            System.out.println("5. Find Lowest Score");
            System.out.println("6. Search Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();

                    students.add(new Student(name, grade));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        double sum = 0;

                        for (Student s : students) {
                            sum += s.getGrade();
                        }

                        double average = sum / students.size();

                        System.out.printf("Average Score: %.2f%n", average);
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        Student highest = students.get(0);

                        for (Student s : students) {
                            if (s.getGrade() > highest.getGrade()) {
                                highest = s;
                            }
                        }

                        System.out.println("Highest Score:");
                        System.out.println(highest);
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        Student lowest = students.get(0);

                        for (Student s : students) {
                            if (s.getGrade() < lowest.getGrade()) {
                                lowest = s;
                            }
                        }

                        System.out.println("Lowest Score:");
                        System.out.println(lowest);
                    }
                    break;

                case 6:
                    if (students.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        System.out.print("Enter Student Name to Search: ");
                        String searchName = sc.nextLine();

                        boolean found = false;

                        for (Student s : students) {
                            if (s.getName().equalsIgnoreCase(searchName)) {
                                System.out.println("Student Found:");
                                System.out.println(s);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Student not found.");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
