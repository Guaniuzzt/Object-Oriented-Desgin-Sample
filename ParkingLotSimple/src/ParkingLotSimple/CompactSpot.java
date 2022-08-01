package ParkingLotSimple;

public class CompactSpot extends ParkingSpot{

    public CompactSpot(){
        this.hourlyRation = 5;
    }
    @Override
    public void park(ParkingLot parkingLot, ParkingSpot spot) {
        parkingLot.compactId++;
        this.parkingLocation = "" + parkingLot.compactId;

        parkingLot.availableCompatSpot--;
        parkingLot.compactSpotMap.put(""+parkingLot.compactId, spot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot spot) {
        parkingLot.compactSpotMap.remove(spot.parkingLocation);
        parkingLot.availableCompatSpot++;
    }
}
