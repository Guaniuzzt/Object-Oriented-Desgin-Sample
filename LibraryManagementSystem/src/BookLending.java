import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BookLending {

    private static Map<String, BookLending> bookLendingMap = new HashMap<>();


    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private String bookItemBarcode;
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public static boolean lendBook(String barcode, String memberId) {
        return false;
    }

    public static BookLending fetchLendingDetails(String barcode) {
        return bookLendingMap.get(barcode);
    }

    public Date getDueDate() {
        return this.dueDate;
    }
}
