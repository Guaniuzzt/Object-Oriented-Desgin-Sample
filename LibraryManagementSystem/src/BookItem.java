import Constant.BookFormat;
import Constant.BookStatus;

import java.util.Date;

public class BookItem extends Book{
    private String barcode;



    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

    public BookItem() {
    }

    public boolean getIsReferenceOnly() {
        return isReferenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        isReferenceOnly = referenceOnly;
    }
    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public boolean checkout(String memberId) {
        if(this.getIsReferenceOnly()) {
            System.out.println("This book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(this.getBarcode(), memberId)){
            return false;
        }
        this.updateBookItemStatus(BookStatus.LOANED);
        return true;
    }

    private void updateBookItemStatus(BookStatus loaned) {
    }


}
