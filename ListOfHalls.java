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
    private ArrayList<Hall> hallsList = new ArrayList<Hall>();;
    

    /**
     * Constructor for objects of class ListOfHalls
     */
    public ListOfHalls()
    {
        String des1 = "This inviting space is ideal for everything from intimate gatherings, engagement parties, Christmas breakups, work drinks, birthdays and more!";
        addHall(1, "The Pier Hotel", des1, "Frankston, Melbourne", 150, 1, 0.0, true, 500, 5.0);
        addHall(2, "Caulfield Racecourse", des1, "Caulfield East, Melbourne", 100, 1, 0.0, true, 200, 4.8);
        addHall(3, "CQ Functions", des1, "Queen Street, Melbourne", 50, 1, 0.0, false, 70, 4.5);
    }
    
    public void displayAllHalls()
    {
        for (Hall ob : hallsList)
        {
            System.out.println("Hall Number - " + ob.getHId());
            System.out.println("Name - " + ob.getName());
            System.out.println("Description - " + ob.getDescription());
            System.out.println("Location - " + ob.getLocation());
            System.out.println("Size - " + ob.getCapacity());
            System.out.println("Discount - " + ob.getDiscount());
            System.out.println("Availability - " + ob.getAvailability());
            System.out.println("Price - " + ob.getPrice());
            System.out.println("Rating - " + ob.getRating());
            System.out.println("--------------------------------------");
        }
    }
    
    public void addHall(int hallnumber, String hallname, String halldescription, String halllocation, 
        int hallsize, int ownerId, double discount, boolean availability, double price, double rating)
    {
        Hall newHall = new Hall();
        newHall.addHall(hallnumber, hallname, halldescription, halllocation, hallsize, ownerId, 
            discount, availability, price, rating);
        hallsList.add(newHall);
    }
    
    public int getNoOfHalls()
    {
        return hallsList.size();
    }
}
