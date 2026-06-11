import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. ChatBot");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");

                    try {
                        int age = sc.nextInt();
                        manager.addStudent(new Student(id, name, age));

                        manager.saveToFile(); // ADD THIS LINE

                        System.out.println("Student Added!");
                    } catch (Exception e) {
                        System.out.println("Please enter a valid age.");
                        sc.nextLine();
                    }

                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    Student student = manager.searchStudent(id);

                    if (student != null)
                        System.out.println(student);
                    else
                        System.out.println("Student Not Found");
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    if (manager.updateStudent(id, newName, newAge)) {
                        manager.saveToFile();
                        System.out.println("Student Updated!");
                    } else {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    if (manager.deleteStudent(id)) {
                        manager.saveToFile();
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 6:
                    ChatBot bot = new ChatBot();
                    bot.startChat(manager);
                    break;    

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}