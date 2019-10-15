
/**
 * Write a description of class Hall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hall
{
    // instance variables - replace the example below with your own
    private int hId;
    private String name;
    private String description;
    private String location;
    private int capacity;
    private int ownerId;
    private double discount;
    private boolean availability;
    private double price;
    private double rating;
    
    /**
     * Constructor for objects of class Hall
     */
    public Hall()
    {
        // initialise instance variables
        hId = 0;
        name = "" ;
        description = "";
        location = "";
        capacity = 0;
        ownerId = 0;
        discount = 0.0;
        availability = true;
        price = 0.0;
        rating = -1.0;
    }
    
    public void addHall(int newNumber, String newName, String newDescription, String newLocation, 
        int newCapacity, int newOwnerId, double newDiscount, boolean newAvailability, Double newPrice, double newRating)
    {
        // initialise instance variables
        hId = newNumber;
        name = newName;
        description = newDescription;
        location = newLocation;
        capacity = newCapacity;
        ownerId = newOwnerId;
        discount = newDiscount;
        availability = newAvailability;
        price = newPrice;
        rating = newRating;
    }
    
    public int getHId()
    {
        return hId;
    }

    public void setHId(int newNumber)
    {
        hId = newNumber;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }
    
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String newDescription)
    {
        description = newDescription;
    }
    
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
    
    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int newCapacity)
    {
        capacity = newCapacity;
    }
    
    public int getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(int newOwnerId)
    {
        ownerId = newOwnerId;
    }
    
    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double newDiscount)
    {
        discount = newDiscount;
    }
    
    public boolean getAvailability()
    {
        return availability;
    }

    public void setAvailability(boolean newAvailability)
    {
        availability = newAvailability;
    }
    
    public Double getPrice()
    {
        return price;
    }
    
    public void setPrice(Double newPrice)
    {
        price = newPrice;
    }
    
    public double getRating()
    {
        return rating;
    }
    
    public void setRating(double newRating)
    {
        rating = newRating;
    }
    
    public void updateRating(double newRating)
    {
        rating = (rating + newRating)/2;
    }
    
    public void resetRating()
    {
        rating = -1;
    }
}
