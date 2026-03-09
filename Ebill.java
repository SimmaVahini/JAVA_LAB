import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        // Use the Scanner class to read input from the console
        Scanner sc = new Scanner(System.in);
                                                       
        // 1. Reading Customer Details
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Connection Type (Domestic / Non-Domestic): ");
        String type = sc.nextLine();
        System.out.print("Enter Previous Reading: ");
        double previousReading = sc.nextDouble();
        System.out.print("Enter Current Reading: ");
        double currentReading = sc.nextDouble();

        // Calculate total units consumed
        double units = currentReading - previousReading;
        double totalBill = 0;

        // 2. Control Structure (If-Else) to apply rates based on criteria
        if (type.equalsIgnoreCase("Domestic")) {
            // Apply Domestic Slabs
            if (units <= 100) {
                totalBill = units * 4.80; // Up to 100 units at 4.80
            } else if (units <= 200) {
                totalBill = (100 * 4.80) + ((units - 100) * 5.80); // 101-200 units at 5.80
            } else {
                totalBill = (100 * 4.80) + (100 * 5.80) + ((units - 200) * 6.50); // Above 200 units at 6.50
            }
        } 
        else if (type.equalsIgnoreCase("Non-Domestic")) {
            // Apply Non-Domestic Criteria
            if (units <= 100) {
                totalBill = units * 6.05; // Up to 100 units at 6.05
            } else {
                // Assuming flat rate or provided specific logic for units > 100
                totalBill = units * 6.05; 
            }
        } 
        else {
            System.out.println("Error: Invalid Connection Type.");
            sc.close();
            return;
        }

        // 3. Print the final bill
        System.out.println("\n----------- Electricity Bill -----------");
        System.out.println("Customer Name    : " + name);
        System.out.println("Connection Type  : " + type);
        System.out.println("Units Consumed   : " + units);
        System.out.printf("Total Payable    : Rs. %.2f\n", totalBill);
        System.out.println("----------------------------------------");

        sc.close();
    }
}
