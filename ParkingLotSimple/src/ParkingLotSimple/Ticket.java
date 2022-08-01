package ParkingLotSimple;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class Ticket {

    private String parkingLoaction;
    private Timestamp enter;

    public Timestamp getExit() {
        return exit;
    }


    private Timestamp exit;

    public float getChargeAmout() {
        return chargeAmout;
    }

    public String getParkingLoaction() {
        return parkingLoaction;
    }

    public void setParkingLoaction(String parkingLoaction) {
        this.parkingLoaction = parkingLoaction;
    }

    public Timestamp getEnter() {
        return enter;
    }

    public void setEnter(Timestamp enter) {
        this.enter = enter;
    }

    public float getHourlyRatio() {
        return hourlyRatio;
    }

    public void setHourlyRatio(float hourlyRatio) {
        this.hourlyRatio = hourlyRatio;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    private float hourlyRatio;
    private float chargeAmout;
    private ParkingSpot parkingSpot;

    public void calculate(){
        this.exit = Timestamp.from(Instant.now());
        Duration duration = Duration.between(enter.toLocalDateTime(), this.exit.toLocalDateTime());
        this.chargeAmout = duration.toHours() * hourlyRatio;
    }


}
