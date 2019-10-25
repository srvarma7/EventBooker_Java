
/**
 * Write a description of class Quotation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quotation
{
    // instance variables - replace the example below with your own
    public int qId;
    public int hallId;
    public int userId;
    public int bookingId;
    
    public int noOfGuests;
    public boolean catering;
    //public boolean bookingAvailability[][];
    public String bookingDate;
    public int bookingSlot;
    
    public boolean quotaionStatus;
    public String discountCode;
    
    public double totalPrice;
    
    /**
     * Constructor for objects of class Quotation
     */
    public Quotation()
    {
        // initialise instance variables
        discountCode = "NILL";
    }
    
    public void addQuotaion(int newQid, int newHallId, int newUserId, int newNoOfGuests, boolean newCatreing,
        String newBookingDate, int newBookingSlot, boolean newquotaionStatus, String newDiscountCode, double newTotalPrice)
    {
        //
        qId = newQid;
        hallId = newHallId;
        userId = newUserId;
        //bookingId = 0;
        noOfGuests = newNoOfGuests;
        catering = newCatreing;
        //setNewHallAvailability();
        
        bookingDate = newBookingDate;
        bookingSlot = newBookingSlot;
        quotaionStatus = true;
        discountCode = newDiscountCode;
        totalPrice = newTotalPrice;
    }
    
    public int getQuotationId()
    {
        return qId;
    }
    
    public void setQuotationId(int newQid)
    {
        qId = newQid;
    }
    
    public int getHallId()
    {
        return hallId;
    }
    
    public void setHallId(int newHallId)
    {
        hallId = newHallId;
    }
    
    public int getUserId()
    {
        return userId;
    }
    
    public void setUserId(int newUserId)
    {
        userId = newUserId;
    }
    
    public int getNoOfGuests()
    {
        return noOfGuests;
    }
    
    public void setNoOfGuests(int newNoOfGuests)
    {
        noOfGuests = newNoOfGuests;
    }
    
    public boolean getCatering()
    {
        return catering;
    }
    
    public void setCatering(boolean newCatreing)
    {
        catering = newCatreing;
    }
    
    public String getBookingDate()
    {
        return bookingDate;
    }
    
    public void setBookingDate(String newBookingDate)
    {
        bookingDate = newBookingDate;
    }
    
    public int getBookingSlot()
    {
        return bookingSlot;
    }
    
    public void setBookingSlot(int newBookingSlot)
    {
        bookingSlot = newBookingSlot;
    }
    
    public boolean getQuotaionStatus()
    {
        return quotaionStatus;
    }
    
    public void setQuotaionStatus(boolean newQuotaionStatus)
    {
        quotaionStatus = newQuotaionStatus;
    }
    
    public String getDiscountCode()
    {
        return discountCode;
    }
    
    public void setDiscountCode(String newDiscountCode)
    {
        discountCode = newDiscountCode;
    }
    
    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    public void setDiscountCode(double newTotalPrice)
    {
        totalPrice = newTotalPrice;
    }
}
