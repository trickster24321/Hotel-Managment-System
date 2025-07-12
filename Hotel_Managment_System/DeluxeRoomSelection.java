package javaapplication;

/**
*
* @author lahir
*/
class DeluxeRoomSelection implements RoomSelectionStrategy {
   public Rooms selectRoom() {
       return RoomFactory.createRoom("Deluxe"); 
   }
}
