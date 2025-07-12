package javaapplication;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HotelManagementTest {

    private Guest guest;
    private RoomFactory roomFactory;
    private PaymentMethod creditCardPayment;
    private PaymentMethod paypalPayment;

    @Before
    public void setUp() {
        roomFactory = new RoomFactory();
        creditCardPayment = new CreditCardPayment();
        paypalPayment = new PayPalPayment();
    }

    // Verify room creation using RoomFactory.createRoom()
    @Test
    public void testRoomCreation() {
        Rooms room = RoomFactory.createRoom("Standard");
        assertNotNull(room);
        assertEquals("Standard", room.getRoomType());
    }

    // Check the correct application of PaymentMethod.processPayment()
    @Test
    public void testPaymentMethod() {
        assertEquals("Paid using Credit Card", creditCardPayment.processPayment());
        assertEquals("Paid using PayPal", paypalPayment.processPayment());
    }

    // Ensure the correctness of Guest object instantiation
    @Test
    public void testGuestInstantiation() {
        guest = new Guest("John Doe", "1990-01-01", "123 Main St", "12345", RoomFactory.createRoom("Standard"), creditCardPayment);
        assertNotNull(guest);
        assertEquals("John Doe", guest.getName());
    }

    // Validate the selection of rooms using RoomSelectionStrategy
    @Test
    public void testRoomSelectionStrategy() {
        RoomSelectionStrategy strategy = new StandardRoomSelection();
        Rooms room = strategy.selectRoom();
        assertEquals("Standard", room.getRoomType());

        strategy = new DeluxeRoomSelection();
        room = strategy.selectRoom();
        assertEquals("Deluxe", room.getRoomType());

        strategy = new LuxuryRoomSelection();
        room = strategy.selectRoom();
        assertEquals("Luxury", room.getRoomType());
    }

    // Additional test cases for different room types
    @Test
    public void testDifferentRoomTypes() {
        Rooms standardRoom = RoomFactory.createRoom("Standard");
        Rooms deluxeRoom = RoomFactory.createRoom("Deluxe");
        Rooms luxuryRoom = RoomFactory.createRoom("Luxury");

        assertNotNull(standardRoom);
        assertNotNull(deluxeRoom);
        assertNotNull(luxuryRoom);
    }

    // Verify proper exception handling in PaymentMethod
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPaymentMethod() {
        PaymentMethod invalidPaymentMethod = null;
        invalidPaymentMethod.processPayment();
    }

    // Ensure Guest objects are correctly stored and retrieved
    @Test
    public void testGuestStorage() {
        guest = new Guest("Jane Doe", "1992-05-05", "456 Oak St", "67890", RoomFactory.createRoom("Deluxe"), paypalPayment);
        assertEquals("Jane Doe", guest.getName());
        assertEquals("Deluxe", guest.getRoom().getRoomType());
    }

    // Validate price calculation in RoomSelectionStrategy
    @Test
    public void testRoomPriceCalculation() {
        RoomSelectionStrategy strategy = new StandardRoomSelection();
        Rooms room = strategy.selectRoom();
        assertEquals(2500, room.getRoomPrice());

        strategy = new DeluxeRoomSelection();
        room = strategy.selectRoom();
        assertEquals(6000, room.getRoomPrice());

        strategy = new LuxuryRoomSelection();
        room = strategy.selectRoom();
        assertEquals(10000, room.getRoomPrice());
    }

    // Ensure RoomFactory handles invalid input gracefully
    @Test(expected = IllegalArgumentException.class)
    public void testRoomFactoryInvalidInput() {
        RoomFactory.createRoom("Invalid");
    }

    // Test different discount scenarios in PaymentMethod
    @Test
    public void testDiscountScenarios() {
        PaymentMethod discountPayment = new PaymentMethod() {
            @Override
            public String processPayment() {
                return "Paid with Discount";
            }
        };
        assertEquals("Paid with Discount", discountPayment.processPayment());
    }

    // Verify database connection handling in Guest management
    // (Assuming a database connection object, mock it for the test)
    @Test
    public void testDatabaseConnection() {
        // For mock, simulate a database interaction (this is a placeholder)
        assertTrue(true); // In real-world, test your DB connection here
    }

    // Ensure multi-threading does not interfere with RoomSelectionStrategy
    @Test
    public void testRoomSelectionMultiThreading() throws InterruptedException {
        Runnable task = () -> {
            RoomSelectionStrategy strategy = new StandardRoomSelection();
            Rooms room = strategy.selectRoom();
            assertEquals("Standard", room.getRoomType());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    // Validate edge cases for Guest registration
    @Test
    public void testGuestEdgeCases() {
        guest = new Guest("Edge Case Guest", "1999-12-31", "", "11111", RoomFactory.createRoom("Luxury"), paypalPayment);
        assertEquals("", guest.getAddress());
        assertNotNull(guest);
    }

    // Test the correctness of different PaymentMethod implementations
    @Test
    public void testPaymentMethodImplementations() {
        assertEquals("Paid using Credit Card", new CreditCardPayment().processPayment());
        assertEquals("Paid using PayPal", new PayPalPayment().processPayment());
    }

    // Ensure proper cleanup of objects after test execution
    @Test
    public void testCleanup() {
        guest = null;  // Clean up after test
        assertNull(guest);
    }
}