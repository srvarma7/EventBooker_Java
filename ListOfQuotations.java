import java.util.*;
/**
 * Write a description of class ListofReviews here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfQuotations
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Quotation> quotaionList;

    /**
     * Constructor for objects of class ListofReviews
     */
    public ListOfQuotations()
    {
        // initialise instance variables
        quotaionList = new ArrayList<Quotation>();
        loadQuotations();
    }
    
    public ArrayList<Quotation> getListOfQuotations()
    {
        return quotaionList;
    }
    
    public void loadQuotations()
    {
        //
        addQuotation(1,1,2,30,false,"17/10/2019",0,true, "PRIME", 1300);
        addQuotation(2,1,2,34,true,"18/10/2019",1,true, " - ", 1380);
        addQuotation(3,1,2,36,true,"19/10/2019",2,true, "PRIME", 1300);
    }
    
    public void addQuotation(int quotaionNo, int hallIDChoice, int uid, int noOfGuests, boolean catering, 
            String bookingDate, int slot, boolean quotationStatus, String discountCode, double totalPrice)
    {
        //
        Quotation quotation = new Quotation();
        quotation.addQuotaion(quotaionNo, hallIDChoice, uid, noOfGuests, catering,
        bookingDate, slot, quotationStatus, discountCode, totalPrice);
        quotaionList.add(quotation);
    }
    
    public Vector getQuotationDetailsByUserAndQuotation(int userID, int quotaionId)
    {
        //
        Vector data = new Vector();
        //int qno = ob.getQuotationId();
        int hno = 0;
        int uid = 0;
        int guests = 0;
        boolean cat = false;
        String bookingDate  = "-";
        String slot = "-";
        double totalPrice  = 0.0;
        
        for (Quotation ob : quotaionList)
        {
            if(ob.getUserId() == userID && ob.getQuotationId() == quotaionId)
            {
                //
                hno = ob.getHallId();
                uid = ob.getUserId();
                guests = ob.getNoOfGuests();
                cat = ob.getCatering();
                bookingDate = ob.getBookingDate();
                if(ob.getBookingSlot() == 0)
                {
                    slot = "Morning";
                }
                else if (ob.getBookingSlot() == 1)
                {
                    slot = "Arvo";
                }
                else
                    slot = "Evening";
                totalPrice = ob.getTotalPrice();
            }
        }
        data.add(hno);
        data.add(uid);
        data.add(bookingDate);
        data.add(totalPrice);
        data.add(guests);
        data.add(cat);
        data.add(slot);
        
        return data;
    }
    
    public void displayQuotationByUserId(int userID)
    {
        //
        for (Quotation ob : quotaionList)
        {
            if(ob.getUserId() == userID)
            {
                //
                System.out.println("__________________________________________________");
                System.out.println("Quotaion Number  - " + ob.getQuotationId());
                System.out.println("Hall Id          - " + ob.getHallId());
                System.out.println("Booking Date     - " + ob.getBookingDate());
                System.out.println("Total Price      - " + ob.getTotalPrice());
                System.out.println("__________________________________________________");
            }
        }
    }
    
    public void displayQuotationByUserIdAndQuotationID(int userID, int quotaionId)
    {
        for (Quotation ob : quotaionList)
        {
            if(ob.getUserId() == userID && ob.getQuotationId() == quotaionId)
            {
                //
                System.out.println("__________________________________________________");
                System.out.println("Quotaion Number  - " + ob.getQuotationId());
                System.out.println("Hall ID          - " + ob.getHallId());
                System.out.println("User ID          - " + ob.getUserId());
                System.out.println("Guests           - " + ob.getNoOfGuests());
                System.out.println("Catering         - " + ob.getCatering());
                System.out.println("Booking Date     - " + ob.getBookingDate());
                String slot = "nil";
                if(ob.getBookingSlot() == 0)
                {
                    slot = "Morning";
                }
                else if (ob.getBookingSlot() == 1)
                {
                    slot = "Arvo";
                }
                else
                    slot = "Evening";
                System.out.println("Slot             - " + slot);
                System.out.println("Quotation Status - " + ob.getQuotaionStatus());
                System.out.println("Discount Code    - " + ob.getDiscountCode());
                System.out.println("Total Price      - " + ob.getTotalPrice());
                System.out.println("__________________________________________________");
            }
        }
    }

    public void displayAllQuotations()
    {
        for (Quotation ob : quotaionList)
        {
            System.out.println("__________________________________________________");
            System.out.println("Quotaion Number  - " + ob.getQuotationId());
            System.out.println("Hall ID          - " + ob.getHallId());
            System.out.println("User ID          - " + ob.getUserId());
            System.out.println("Guests           - " + ob.getNoOfGuests());
            System.out.println("Catering         - " + ob.getCatering());
            System.out.println("Booking Date     - " + ob.getBookingDate());
            String slot = "nil";
            if(ob.getBookingSlot() == 0)
            {
                slot = "Morning";
            }
            else if (ob.getBookingSlot() == 1)
            {
                slot = "Arvo";
            }
            else
                slot = "Evening";
            System.out.println("Slot             - " + slot);
            System.out.println("Quotation Status - " + ob.getQuotaionStatus());
            System.out.println("Discount Code    - " + ob.getDiscountCode());
            System.out.println("Total Price      - " + ob.getTotalPrice());
            System.out.println("__________________________________________________");
        }
    }
    
    public int getNoOfQuotations()
    {
        return quotaionList.size();
    }
}
