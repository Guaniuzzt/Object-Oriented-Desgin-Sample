package ParkingLotSimple;

public class LargetSpot extends ParkingSpot{

    public LargetSpot(){
        this.hourlyRation = 10;
    }


    @Override
    public void park(ParkingLot parkingLot, ParkingSpot spot) {
        parkingLot.largeId++;
        this.parkingLocation = "" + parkingLot.largeId;

        parkingLot.availableLargeSpot--;
        parkingLot.largeSpotMap.put(""+parkingLot.largeId, spot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot spot) {
        parkingLot.largeSpotMap.remove(spot.parkingLocation);
        parkingLot.availableLargeSpot++;
    }
}
