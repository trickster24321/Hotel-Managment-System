package javaapplication;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author lahir
 */
public class booking {
	
    public static void main(String[] args) {
        
        // User input
        Scanner scanner = new Scanner(System.in);
        
       System.out.println("Please enter Customer's name: ");
        String name = scanner.nextLine();
        
        System.out.println("Please enter Customer's Date of Birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        
        System.out.println("Please enter Customer's Address: ");
        String address = scanner.nextLine();
        
        System.out.println("Please enter Customer's Identity Card No.: ");
        String id = scanner.nextLine();
        
        
        
        //Room Selection
        System.out.println("Please select the number for the room type: ");
        System.out.println("(entering any other character will change the selection to standard room)");
        System.out.println("1. Standard");
        System.out.println("2. Deluxe");
        System.out.println("3. Luxury");
        
        int choose = scanner.nextInt();
        scanner.nextLine();
       
         RoomSelectionStrategy strategy;
        switch (choose) {
            case 1: strategy = new StandardRoomSelection(); 
            break;
            case 2: strategy = new DeluxeRoomSelection(); 
            break;
            case 3: strategy = new LuxuryRoomSelection(); 
            break;
            default:
                System.out.println("Invalid response, Selection changed to Standrd Room.");
                strategy = new StandardRoomSelection();
        }
        Rooms roomSelected = strategy.selectRoom();
        
        //payment method
        System.out.println("Please select the number for the payment method: ");
        System.out.println("(entering any other character will change the selection to credit card.)");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        
         int paymentChoice = scanner.nextInt();
        scanner.nextLine();
        
        PaymentMethod paymentMethod;
        switch (paymentChoice) {
            case 1: paymentMethod = new CreditCardPayment(); break;
            case 2: paymentMethod = new PayPalPayment(); break;
            default:
                System.out.println("Invalid response, Selection changed to Credit Card.");
                paymentMethod = new CreditCardPayment();
        }
        // Create guest and display details
        Guest guest = new Guest(name, dob, address, id, roomSelected, paymentMethod);
        guest.displayGuest();
        
        scanner.close();
    }
}
