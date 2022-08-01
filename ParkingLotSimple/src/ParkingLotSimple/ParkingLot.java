package ParkingLotSimple;



import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    Map<String, ParkingSpot> largeSpotMap = new HashMap<>();
    Map<String, ParkingSpot> compactSpotMap = new HashMap<>();
    Map<String, ParkingSpot> handicapSpotMap = new HashMap<>();
    Map<String, Ticket> ticketMap = new HashMap<>();

    int availableLargeSpot = 100;
    int availableCompatSpot = 100;
    int availableHandicapSpot = 100;

    int largeId = 0;
    int compactId = 100;
    int handicapId = 200;


    public Ticket park(String vehicleType) throws Exception, ParkingFullException{

        if(checkFull(vehicleType)){
            throw new ParkingFullException();
        }

        ParkingSpot parkingSpot = getParkingSpot(vehicleType);
        parkSpotUpdate(parkingSpot);

        Ticket ticket = new Ticket();
        ticket.setEnter(Timestamp.from(Instant.now().minus(3, ChronoUnit.HOURS)));
        ticket.setParkingLoaction(parkingSpot.parkingLocation);
        ticket.setHourlyRatio(parkingSpot.hourlyRation);
        ticket.setParkingSpot(parkingSpot);
        ticketMap.put(parkingSpot.parkingLocation, ticket);

        System.out.println("Welcome Enter Parking Lot: You enter at time:" + ticket.getEnter());
        System.out.println("Your vehicle type is:" + vehicleType);
        return ticket;

    }

    public Ticket exit(String parkingLocation){
        Ticket ticket = ticketMap.get(parkingLocation);
        //update parking spaces
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.exit(this, parkingSpot);

        //calculate fee
        ticket.calculate();
        System.out.println("You have parked from:" + ticket.getEnter() + "to" + ticket.getExit());
        System.out.println("Total free is:" +ticket.getChargeAmout() + "| hourlyRatio = " + ticket.getHourlyRatio());
        return ticket;
    }

    private void parkSpotUpdate(ParkingSpot parkingSpot){
        parkingSpot.park(this,parkingSpot);
    }

    private ParkingSpot getParkingSpot(String vehicleType){
        if(vehicleType.equals("large")){
            return new LargetSpot();
        }else if(vehicleType.equals("compact")){
            return new CompactSpot();
        }else{
            return new HandicapSpot();
        }
    }

    private boolean checkFull(String vehicleType) throws Exception{
        if(vehicleType.equals("large")){
            return availableLargeSpot <= 0;
        }else if(vehicleType.equals("compact")){
            return availableCompatSpot <= 0;
        }else if(vehicleType.equals("handicap")){
            return availableHandicapSpot <= 0;
        }
        throw new Exception("Invaild Vehicle type");
    }
}
