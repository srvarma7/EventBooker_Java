import java.util.*;
/**
 * Write a description of class ListofBookings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfBookings
{
    // instance variables - replace the example below with your own
    private ArrayList<Booking> bookingList;
    /**
     * Constructor for objects of class ListofBookings
     */
    public ListOfBookings()
    {
        // initialise instance variables
        bookingList = new ArrayList<Booking>();
        loadBookings();
    }
    
    public void updateReviewComplete(int bookingId)
    {
        for (Booking ob : bookingList)
        {
            if(ob.getBookingId() == bookingId)
            {
                ob.setReviewStatus(true);
            }
        }
    }
    
    public void loadBookings()
    {
        //
        addBooking(1, 1, 2, "17/10/2019", 1200, 30, false, "Morning", true);
        addBooking(2, 1, 2, "18/10/2019", 1400, 34, true, "Arvo", true);
        addBooking(3, 1, 2, "19/10/2019", 1600, 38, true, "Evening", true);
    }

    public int getNoOfBookings()
    {
        return bookingList.size();
    }
    
    public void addBooking(int newBookingId, int newHallId, int newUserId, String newBookingDate, double newTotalPrice,  
        int newNoOfGuests, boolean newIsCatering, String newSlot, boolean newReviewStatus)
    {
        // put your code here
        Booking newBooking = new Booking();
        newBooking.addBooking(newBookingId, newHallId, newUserId, newBookingDate, newTotalPrice, 
            newNoOfGuests,newIsCatering, newSlot, newReviewStatus);
        bookingList.add(newBooking);
    }
    
    public boolean checkReviewMade(int bookingId)
    {
        boolean status = false;
        for (Booking ob : bookingList)
        {
            if(ob.getBookingId() == bookingId)
            {
                status = ob.getReviewStatus();
            }
        }
        return status;
    }
    
    public void displayBookings()
    {
        //
        for (Booking ob : bookingList)
        {
            //if(ob.getUserId() == userID)
            {
                //
                System.out.println("__________________________________________________");
                System.out.println("Booking Id       - " + ob.getBookingId());
                System.out.println("Hall Id          - " + ob.getHallId());
                System.out.println("User Id          - " + ob.getUserId());
                System.out.println("Booking Date     - " + ob.getBookingDate());
                System.out.println("Slot             - " + ob.getSlot());
                System.out.println("Total Price      - " + ob.getTotalPrice());
                System.out.println("No of Guests     - " + ob.getNoOfGuests());
                String catering = ob.getIsCatering() ? "Yes" : "No";
                System.out.println("Catering Status  - " + catering);
                String rating = ob.getReviewStatus() ? "Completed review" : "Review not Made";
                System.out.println("Review Completed - " + rating);
                System.out.println("__________________________________________________");
            }
        }
    }
    
    public void displayBookingByUserId(int userID)
    {
        //
        for (Booking ob : bookingList)
        {
            if(ob.getUserId() == userID)
            {
                //
                System.out.println("__________________________________________________");
                System.out.println("Booking Id       - " + ob.getBookingId());
                System.out.println("Hall Id          - " + ob.getHallId());
                System.out.println("User Id          - " + ob.getUserId());
                System.out.println("Booking Date     - " + ob.getBookingDate());
                System.out.println("Slot             - " + ob.getSlot());
                System.out.println("Total Price      - " + ob.getTotalPrice());
                System.out.println("No of Guests     - " + ob.getNoOfGuests());
                String catering = ob.getIsCatering() ? "Yes" : "No";
                System.out.println("Catering Status  - " + catering);
                String rating = ob.getReviewStatus() ? "Completed review" : "Review not Made";
                System.out.println("Review Completed - " + rating);
                System.out.println("__________________________________________________");
            }
        }
    }
    
    public Vector getBookingDetails(int bookingId)
    {
        Vector data = new Vector();
        int bookingID = 0;
        int hallID = 0;
        int userID = 0;
        for (Booking ob : bookingList)
        {
            if(ob.getBookingId() == bookingId)
            {
                //
                bookingID = ob.getBookingId();
                hallID = ob.getHallId();
                userID = ob.getUserId();
            }
        }
        data.add(bookingID);
        data.add(hallID);
        data.add(userID);
        return data;
    }
    
    public void displayBookingByBookingId(int bookingId)
    {
        //
        for (Booking ob : bookingList)
        {
            if(ob.getBookingId() == bookingId)
            {
                //
                System.out.println("__________________________________________________");
                System.out.println("Booking Id       - " + ob.getBookingId());
                System.out.println("Hall Id          - " + ob.getHallId());
                System.out.println("User Id          - " + ob.getUserId());
                System.out.println("Booking Date     - " + ob.getBookingDate());
                System.out.println("Slot             - " + ob.getSlot());
                System.out.println("Total Price      - " + ob.getTotalPrice());
                System.out.println("No of Guests     - " + ob.getNoOfGuests());
                String catering = ob.getIsCatering() ? "Yes" : "No";
                System.out.println("Catering Status  - " + catering);
                String rating = ob.getReviewStatus() ? "Completed review" : "Review not Made";
                System.out.println("Review Completed - " + rating);
                System.out.println("__________________________________________________");
            }
        }
    }
}
