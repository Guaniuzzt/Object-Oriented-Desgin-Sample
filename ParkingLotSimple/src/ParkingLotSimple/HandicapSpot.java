package ParkingLotSimple;

public class HandicapSpot extends ParkingSpot{

    public HandicapSpot(){
        this.hourlyRation = 2;
    }

    @Override
    public void park(ParkingLot parkingLot, ParkingSpot spot) {
        parkingLot.handicapId--;
        this.parkingLocation = "" + parkingLot.handicapId;

        parkingLot.availableHandicapSpot--;
        parkingLot.handicapSpotMap.put(""+parkingLot.handicapId, spot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot spot) {
        parkingLot.handicapSpotMap.remove(spot.parkingLocation);
        parkingLot.availableHandicapSpot++;
    }
}
