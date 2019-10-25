import java.text.*;
import java.util.*;
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
    private boolean availability[][];
    private double pricePerPerson;
    private double avgRating;
    private int dates = 12;
    private int slots = 3;
    
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
        availability = new boolean[dates][slots];
        pricePerPerson = 0.0;
        avgRating = 0.0;
    }
    
    public void addHall(int newNumber, String newName, String newDescription, String newLocation, 
        int newCapacity, int newOwnerId, double newDiscount, double newpricePerPerson, double newavgRating)
    {
        // initialise instance variables
        hId = newNumber;
        name = newName;
        description = newDescription;
        location = newLocation;
        capacity = newCapacity;
        ownerId = newOwnerId;
        discount = newDiscount;
        //making hall available for 12 days
        setHallAvailability();
        pricePerPerson = newpricePerPerson;
        avgRating = newavgRating;
    }
    
    public void displayHallAvailability()
    {
        int day = 1;
        System.out.println("S.no " + "       Date  " + "         Morning " + "          Arvo  " + "          Evening    "); 
        for(int date = 0; date < 12; date++)
        {
            if(date < 9)
            {   
                System.out.print("  " + (date+1) + "      "+ getDate(date) + "   ");
            }
            else
            {
                System.out.print(" " + (date+1) + "      "+ getDate(date) + "   ");
            }
            
            for(int slot = 0; slot < 3; slot++)
            {
                if(availability[date][slot])
                {
                    //
                    System.out.print( "   " + " Available " + "   ");
                }
                else
                {
                    System.out.print( "   " + "Unavailable" + "   ");
                }
            }
            System.out.println("");
        }
    }
    
    public String chooseSlot(int date)
    {
        //
        for(int slot = 0; slot < 3; slot++)
        {
            //
            if(availability[date-1][slot])
            {
                if(slot==0)
                {
                    System.out.println("  " + (slot+1)  + "       Morning" + "     Available  ");
                }
                if(slot==1)
                {
                    System.out.println("  " + (slot+1)  + "        Arvo " + "      Available  ");
                }
                if(slot==2)
                {
                    System.out.println("  " + (slot+1)  + "       Evening" + "     Available  ");
                }
            }
        }
        return getDate(date);
    }
    
    private String currentDate()
    {
        //
        String dateInString =new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return dateInString;
    }
    
    /**
     * REFERENCE FROM STACKOVERFLOW
     */
    public String getDate(int day)
    {
        //
        String dateInString =new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
	try{
	   //Setting the date to the given date
	   c.setTime(sdf.parse(dateInString));
	}
	catch(ParseException e){
		e.printStackTrace();
	}
	//Number of Days to add
	c.add(Calendar.DAY_OF_MONTH, day);  
	//Date after adding the days to the given date
	String newDate = sdf.format(c.getTime());
	return newDate;
    }
    
    public void setHallAvailability()
    {
        //
        for(int date = 0; date < 12; date++)
        {
            for(int slot = 0; slot < 3; slot++)
            {
                availability[date][slot] = true;
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
    
    public boolean getHallAvailablity(int date, int slot)
    {
        //
        return availability[date][slot];
    }
    
    public void setHallAvailablity(int date, int slot, boolean status)
    {
        //
        availability[date][slot] = status;
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
    
    public double getpricePerPerson()
    {
        return pricePerPerson;
    }
    
    public void setpricePerPerson(double newpricePerPerson)
    {
        pricePerPerson = newpricePerPerson;
    }
    
    public double getAvgRating()
    {
        return avgRating;
    }
    
    public void setAvgRating(double newavgRating)
    {
        avgRating = newavgRating;
    }
    
    public void updateAvgRating(double newavgRating)
    {
        avgRating = (newavgRating + avgRating)/2;
    }
}
