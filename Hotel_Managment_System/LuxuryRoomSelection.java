package javaapplication;

/**
*
* @author lahir
*/
class LuxuryRoomSelection implements RoomSelectionStrategy {
   public Rooms selectRoom() {
       return RoomFactory.createRoom("Luxury"); 
   }
}