import java.util.ArrayList;
/**
 * Write a description of class ListOfHalls here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfHalls
{
    // instance variables - replace the example below with your own
    private ArrayList<Hall> hallsList;
    
    /**
     * Constructor for objects of class ListOfHalls
     */
    public ListOfHalls()
    {
        hallsList = new ArrayList<Hall>();
        String des1 = "This space is ideal for gatherings, engagement parties, birthdays and more!";
        addHall(1, "The Pier Hotel", des1, "Frankston, Melbourne", 150, 1, 0.0, 50, 4.5);
        addHall(2, "Caulfield Racecourse", des1, "Caulfield East, Melbourne", 100, 1, 0.0, 20, 0);
        changeAvailableSlot();
    }
    
    public void setAvgRatingForHall(int hallID, double rating)
    {
        //
        for (Hall ob : hallsList)
        {
            if (ob.getHId() == hallID)
            {
                ob.updateAvgRating(rating);
            }
        }
    }
    
    public void addHall(int hallnumber, String hallname, String halldescription, String halllocation, 
        int hallCapacity, int ownerId, double discount, double price, double rating)
    {
        Hall newHall = new Hall();
        newHall.addHall(hallnumber, hallname, halldescription, halllocation, hallCapacity, ownerId, 
            discount, price, rating);
        hallsList.add(newHall);
    }
    
    public void displayAllHalls()
    {
        for (Hall ob : hallsList)
        {
            System.out.println("Hall Number - " + ob.getHId());
            System.out.println("Name - " + ob.getName());
            System.out.println("Location - " + ob.getLocation());
            System.out.println("Average Rating - " + ob.getAvgRating());
            System.out.println("--------------------------------------------");
        }
    }
    
    public double getHallPriceById(int hallID)
    {
        //
        double price = 1.0;
        for (Hall ob : hallsList)
        {
            if (ob.getHId() == hallID)
            {
                 price = ob.getpricePerPerson();
            }
        }
        return price;
    }
    
    public void displayHallById(int hallId)
    {
        for (Hall ob : hallsList)
        {
            if (ob.getHId() == hallId)
            {
                System.out.println("Hall Number - " + ob.getHId());
                System.out.println("Name - " + ob.getName());
                System.out.println("Description - " + ob.getDescription());
                System.out.println("Location - " + ob.getLocation());
                System.out.println("Capacity - " + ob.getCapacity());
                System.out.println("Discount - " + ob.getDiscount());
                System.out.println("Price - " + ob.getpricePerPerson());
                System.out.println("Average Rating - " + ob.getAvgRating());
                System.out.println("--------------------------------------");
            }
        }
    }
    
    public void displayHallAvailabilityById(int hallId)
    {
        //
        for (Hall ob : hallsList)
        {
            if (ob.getHId() == hallId)
            {
                System.out.println("--------------------------------------");
                ob.displayHallAvailability();
                System.out.println("--------------------------------------");
            }
        }
    }
    
    public String chooseSlot(int date, int hallId)
    {
        //
        String data = "not found";
        for (Hall ob : hallsList)
        {
            if (ob.getHId() == hallId)
            {
                System.out.println("--------------------------------------");
                data = ob.chooseSlot(date);
                System.out.println("--------------------------------------");
            }
        }
        return data;
    }
    
    public void changeSlotAvail(int date, int slot, int hallId, boolean status)
    {
        //
        for (Hall ob : hallsList)
        {
            if (ob.getHId() == hallId)
            {
                ob.setHallAvailablity(date, slot, status);
            }
        }
    }
    
    public void changeAvailableSlot()
    {
        for (Hall ob : hallsList)
        {
            ob.setHallAvailablity(6, 0, false);
            ob.setHallAvailablity(7, 1, false);
            ob.setHallAvailablity(8, 2, false);
        }
    }
    
    public int getNoOfHalls()
    {
        return hallsList.size();
    }
}
