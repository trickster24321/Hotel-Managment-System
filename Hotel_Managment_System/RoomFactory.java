package javaapplication;

/**
*
* @author lahiru
*/
class RoomFactory {
   public static Rooms createRoom(String type) {
       switch (type) {
           case "Standard": return new Rooms("s1", "Standard", 2500);
           case "Deluxe": return new Rooms("d1", "Deluxe", 6000);
           case "Luxury": return new Rooms("L1", "Luxury", 10000);
           default: throw new IllegalArgumentException("Invalid Room Type");
       }
   }
}
