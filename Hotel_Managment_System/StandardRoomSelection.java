package javaapplication;

/**
*
* @author lahir
*/
class StandardRoomSelection implements RoomSelectionStrategy {
   public Rooms selectRoom() {
       return RoomFactory.createRoom("Standard"); 
   }
}