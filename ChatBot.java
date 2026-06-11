import java.util.Scanner;

public class ChatBot {

    public void startChat(StudentManager manager) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== Student Assistant ChatBot =====");
        System.out.println("Ask about:");
        System.out.println("- total students");
        System.out.println("- search student");
        System.out.println("- attendance");
        System.out.println("- courses");
        System.out.println("- marks");
        System.out.println("- fees");
        System.out.println("- help");
        System.out.println("- exit");

        while (true) {

            System.out.print("\nYou: ");
            String query = sc.nextLine().toLowerCase();

            if (query.equals("total students")) {

                System.out.println("Bot: Total students are "
                        + manager.getStudentCount());

            } else if (query.equals("search student")) {

                System.out.print("Enter Student ID: ");
                int id = Integer.parseInt(sc.nextLine());

                Student student = manager.searchStudent(id);

                if (student != null) {
                    System.out.println("Bot: " + student);
                } else {
                    System.out.println("Bot: Student not found.");
                }

            } 
            
            else if (query.equals("attendance")) {
                System.out.println("Bot: Attendance tracking feature will be available soon.");
            }
            
            else if (query.equals("courses")) {
                System.out.println("Bot: Available courses include Java, DBMS and Operating Systems.");
            } 
            
            else if (query.equals("marks")) {
                System.out.println("Bot: Marks information can be viewed in the Student Management System.");
            } 
            
            else if (query.equals("fees")) {
                System.out.println("Bot: Fee management module is under development.");    
            } 
            
            else if (query.equals("help")) {

                System.out.println("Bot: Available commands:");
                System.out.println("total students");
                System.out.println("search student");
                System.out.println("attendance");
                System.out.println("courses");
                System.out.println("marks");
                System.out.println("fees");
                System.out.println("exit");

            } else if (query.equals("exit")) {

                System.out.println("Bot: Goodbye!");
                break;

            } else {

                System.out.println(
                        "Bot: Sorry, I don't understand that question.");
            }
        }
    }
}