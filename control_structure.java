import java.util.Scanner;

public class studentFineSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice, attempts, days, books, items;
        double totalFine = 0;

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        do {
            System.out.println("\n--- Fine Menu ---");
            System.out.println("1. Not Wearing ID");
            System.out.println("2. Not Wearing Shoes");
            System.out.println("3. Casual Leave Taken");
            System.out.println("4. Not Returning Library Book");
            System.out.println("5. Breakage of Lab Item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of attempts: ");
                    attempts = sc.nextInt();
                    totalFine += attempts * 150;
                    break;

                case 2:
                    System.out.print("Enter number of attempts: ");
                    attempts = sc.nextInt();
                    totalFine += attempts * 250;
                    break;

                case 3:
                    System.out.print("Enter number of leave days: ");
                    days = sc.nextInt();
                    if (days > 5)
                        totalFine += days * 10;
                    break;

                case 4:
                    System.out.print("Enter number of books: ");
                    books = sc.nextInt();
                    System.out.print("Enter number of days delayed: ");
                    days = sc.nextInt();
                    totalFine += books * days * 20;
                    break;

                case 5:
                    System.out.print("Enter number of items broken: ");
                    items = sc.nextInt();
                    totalFine += items * 10000;
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        System.out.println("\n----- Fine Details -----");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("Total Fine   : Rs. " + totalFine);

        if (totalFine > 50) {
            System.out.println("WARNING: Suspension warning generated!");
        }

        sc.close();
    }
} 
