

public class Booking
{
    // instance variables - replace the example below with your own
    private int bookingId;
    private int hallId;
    private int userId;
    private String bookingDate;
    private double totalPrice;
    private int noOfGuests;
    private boolean isCatering;
    private String slot;
    
    private boolean reviewStatus;

    public Booking()
    {
        // initialise instance variables
        bookingId = 0;
        hallId = 0;
        userId = 0;
        bookingDate = "date";
        totalPrice = 0.0;
        noOfGuests = 0;
        isCatering = false;
        reviewStatus = false;
    }

    public void addBooking(int newBookingId, int newHallId, int newUserId, String newBookingDate, double newTotalPrice,  int newNoOfGuests,
        boolean newIsCatering, String newSlot, boolean newReviewStatus)
    {
        // initialise instance variables
        bookingId = newBookingId;
        hallId = newHallId;
        userId = newUserId;
        bookingDate = newBookingDate;
        totalPrice = newTotalPrice;
        noOfGuests = newNoOfGuests;
        isCatering = newIsCatering;
        slot = newSlot;
        reviewStatus = newReviewStatus;
    }

    public int getBookingId()
    {
        return bookingId;
    }

    public void setBookingId(int newBookingId)
    {
        bookingId = newBookingId;
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

    public String getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate(String newBookingDate)
    {
        bookingDate = newBookingDate;
    }
    
    public String getSlot()
    {
        return slot;
    }

    public void setSlot(String newSlot)
    {
        slot = newSlot;
    }
    
    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(double newTotalPrice)
    {
        totalPrice = newTotalPrice;
    }

    public int getNoOfGuests()
    {
        return noOfGuests;
    }

    public void setNoOfGuests(int newNoOfGuests)
    {
        noOfGuests = newNoOfGuests;
    }

    public boolean getIsCatering()
    {
        return isCatering;
    }
    
    public void setIsCatering(boolean newIsCatering)
    {
        isCatering = newIsCatering;
    }
    
    public void setReviewStatus(boolean status)
    {
        reviewStatus = status;
    }
    
    public boolean getReviewStatus()
    {
        return reviewStatus;
    }
}