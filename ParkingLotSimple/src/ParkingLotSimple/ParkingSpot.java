package ParkingLotSimple;

public abstract class ParkingSpot {

    public String parkingLocation;
    public float hourlyRation;
    public abstract void park(ParkingLot parkingLot, ParkingSpot spot);
    public abstract void exit(ParkingLot parkingLot, ParkingSpot spot);
}
