package javaapplication;

/**
*
* @author lahir
*/
class Guest extends Customer {
   private String dob;
   private String address;
   private Rooms room;
   private PaymentMethod paymentMethod;
   
   // Constructor
   public Guest(String name, String dob, String address, String id, Rooms room, PaymentMethod paymentMethod) {
       super(name, id);
       this.dob = dob;
       this.address = address;
       this.room = room;
       this.paymentMethod = paymentMethod;
   }
   
   // Getters
   public String getDob() {
       return dob;
   }
   public String getAddress() {
       return address;
   }
   public Rooms getRoom() {
       return room;
   }
   public PaymentMethod getPaymentMethod() { 
       return paymentMethod; 
   }
   
   // Setters
   public void setDob(String dob) {
       this.dob = dob;
   }
   public void setAddress(String address) {
       this.address = address;
   }
   public void setRoom(Rooms room) {
       this.room = room;
   }
   public void setPaymentMethod(PaymentMethod paymentMethod) { 
       this.paymentMethod = paymentMethod; 
   }
   
   // Display method
   public void displayGuest() {
       System.out.println("Customer Name: " + getName());
       System.out.println("Customer DOB: " + dob);
       System.out.println("Customer ID Card No: " + getId());
       System.out.println("Address: " + address);
       System.out.println("Room Info:");
       room.showRoomInfo();
        System.out.println("Payment Method: " + paymentMethod.processPayment());
   }
}
