package ParkingLotSimple;

public class ParkingFullException extends Exception{

    ParkingFullException(){
        super("This parking lot is full");
    }
}
