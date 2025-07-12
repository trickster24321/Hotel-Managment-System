package javaapplication;

/**
*
* @author lahiru
*/
class Rooms {
   private String roomNo;
   private String roomType;
   private int roomPrice;
   
   // Constructor
   public Rooms(String roomNo, String roomType, int roomPrice) {
       this.roomNo = roomNo;
       this.roomType = roomType;
       this.roomPrice = roomPrice;
   }
   // Getters
   public String getRoomNo() {
       return roomNo;
   }
   public String getRoomType() {
       return roomType;
   }
   public int getRoomPrice() {
       return roomPrice;
   }
   // Setters
   public void setRoomNo(String roomNo) {
       this.roomNo = roomNo;
   }
   public void setRoomType(String roomType) {
       this.roomType = roomType;
   }
   public void setRoomPrice(int roomPrice) {
       this.roomPrice = roomPrice;
   }
   public void showRoomInfo() {
       System.out.println("Room No: " + roomNo);
       System.out.println("Room Type: " + roomType);
       System.out.println("Room Price: " + roomPrice);
   }
   @Override
   public String toString() {
       return "Room No: " + roomNo + ", Room Type: " + roomType + ", Room Price: " + roomPrice;
   }
}