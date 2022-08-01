import Constant.ReservationStatus;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    private String memberId;

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

    public void updateStatus(ReservationStatus status) {
        this.status = status;
    }

    public void sendBookAvailableNotification(String str) {
        System.out.println(str + "is available now!");
    }
}
