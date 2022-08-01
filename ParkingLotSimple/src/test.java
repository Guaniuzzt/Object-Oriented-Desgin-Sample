import ParkingLotSimple.ParkingLot;
import ParkingLotSimple.Ticket;

public class test {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park("large");
        System.out.println();
        Ticket ticket1 = parkingLot.exit("1");
    }
}
