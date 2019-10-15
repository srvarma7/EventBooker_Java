import java.util.Scanner;
import java.util.Vector;
/**
 * Write a description of class PE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PE
{
    // instance variables - replace the example below with your own
    private ListOfUsers listOfUsers;
    private ListOfHalls listOfHalls;
    private ListOfBookings listOfBooks;
    private ListOfReviews listOfReviews;
    private ListOfQuotations listOfQuotations;
    private Vector userDetails;
    private String currentUserRole;
    private boolean hasConcession;
    private int selectedHallId;
    
    private boolean login = false;
    
    /**
     * Constructor for objects of class PE
     */
    public PE()
    {
        // initialise instance variables
        
        listOfUsers = new ListOfUsers();
        listOfHalls = new ListOfHalls();
        listOfBooks = new ListOfBookings();
        listOfReviews = new ListOfReviews();
        listOfQuotations = new ListOfQuotations();
        userDetails = new Vector();
        hasConcession = false;
        //welcome();
    }
    
    public void mainMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("##############################");
        System.out.println("# Welcome to Prime Events!!! #");
        System.out.println("#       1. Loign             #");
        System.out.println("#       2. Register          #");
        System.out.println("##############################");
        int choice = sc.nextInt();
        menuAction(choice);
    }
    
    private void menuAction(int choice)
    {
        Scanner sc = new Scanner(System.in);
        switch(choice)
        {
            case 1 :    displayLoginMenu();
                        break;
                            
            case 2 :    displayRegisterForm();
                        break;
                        
            default:    System.out.println("Invalid choice, please try again");
                        displayLoggedInUserMenu();
        }
    }  
    
    private void displayLoginMenu()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#      You are in Loign screen      #");
        System.out.println("#-----------------------------------#");
        listOfUsers.loadUsers();
        while(!login)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username : ");
            String username = sc.nextLine();
            System.out.println("Enter password : ");
            String pwd = sc.nextLine();
            userDetails = listOfUsers.checkValidUserAndGetDetails(username, pwd);
            //System.out.println(userDetails.get(0).getClass().getSimpleName());
            if ((Boolean)userDetails.get(0) == true) 
            {
                login = true;
                System.out.println((Boolean)userDetails.get(3));
                hasConcession = (Boolean)userDetails.get(3);
                System.out.println("Welcome " + username);
                displayLoggedInUserMenu();
            }
            else {
                System.out.println("Invalid credentials");
                System.out.println("Please try again");
            }
        }
    }
    
    private void displayRegisterForm() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("#-----------------------------------#");
        System.out.println("#      You are in Register menu     #");
        System.out.println("#-----------------------------------#");
        int backChoice = 1;
        while (backChoice != 0)
        {
            System.out.println("Enter 0 to go back");
            backChoice = sc.nextInt();
            if (backChoice == 0)
            {
                mainMenu();
            }
            
        }
    }
    
    private void displayLoggedInUserMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("#-----------------------------------#");
        System.out.println("#     You are in User Main Menu     #");
        System.out.println("#-----------------------------------#");
        System.out.println("1. View halls");
        System.out.println("2. Manage Bookings");
        System.out.println("3. Review Booking");
        System.out.println("4. Request Quotation");
        
        int userChoice = sc.nextInt();  
        switch(userChoice)
        {
            case 1 :    System.out.println("#-----------------------------------#");
                        System.out.println("#       You are in View Halls       #");
                        System.out.println("#-----------------------------------#");
                        listOfHalls.
                        displayAllHalls();
                        System.out.println("There are total " + listOfHalls.getNoOfHalls() + " halls");
                        //System.out.println("Select any hall to request quotation ");
                        System.out.println("Enter 0 to go back");
                        int choice = sc.nextInt();
                        while (choice < 0 || choice > listOfHalls.getNoOfHalls())
                        {
                            System.out.println("Enter valid choice " );
                            choice = sc.nextInt();
                        }
                        
                        if (choice == 0)
                        {
                            displayLoggedInUserMenu();
                        }
                        else {
                            System.out.println("Booking menu" );
                            //bookHall();
                        }
                        
                        
                        break;
                        
            case 2 :    System.out.println("#-----------------------------------#");
                        System.out.println("#     You are in Manage Booking     #");
                        System.out.println("#-----------------------------------#");
                        int backChoice2 = 1;
                        while (backChoice2 != 0)
                        {
                            System.out.println("Enter 0 to go back");
                            backChoice2 = sc.nextInt();
                            if (backChoice2 == 0)
                            {
                                displayLoggedInUserMenu();
                            }
                        }
                        break;
                        
            case 3 :    System.out.println("#-----------------------------------#");
                        System.out.println("#     You are in Review Booking     #");
                        System.out.println("#-----------------------------------#");
                        int backChoice3 = 1;
                        while (backChoice3 != 0)
                        {
                            System.out.println("Enter 0 to go back");
                            backChoice3 = sc.nextInt();
                            if (backChoice3 == 0)
                            {
                                displayLoggedInUserMenu();
                            }
                        }
                        break;
                        
            case 4 :    System.out.println("#-----------------------------------#");
                        System.out.println("#    You are in Request Quotation   #");
                        System.out.println("#-----------------------------------#");
                        listOfHalls.displayAllHalls();
                        int backChoice4 = 1;
                        while (backChoice4 != 0)
                        {
                            System.out.println("Enter 0 to go back");
                            backChoice4 = sc.nextInt();
                            if (backChoice4 == 0)
                            {
                                displayLoggedInUserMenu();
                            }
                            else 
                            {
                                reqQuotaion(backChoice4);
                            }
                        }
                        break;
                        
            default:    System.out.println("Invalid choice, please try again");
                        displayLoggedInUserMenu();
        }
    }
    
    private void reqQuotaion(int hallNo)
    {
        //
        Scanner sc = new Scanner(System.in);
        listOfHalls.displayHallById(hallNo);
        System.out.println("Enter 1 to continue to request quotation");
        int choice = sc.nextInt();
        if(choice == 1)
        {
            //
            System.out.println("Request quotaion process ");
            System.out.println("Please enter number of guests ");
            int noOfGuests = sc.nextInt();
            System.out.println("Please enter booking date");
            String bookingDate = sc.nextLine();
            System.out.println("Please enter booking slot ");
            int slot = sc.nextInt();
            System.out.println("Please enter discount if you have any or enter 0 ");
            double discount = sc.nextDouble();
            
        }
        else
        {
            //
            displayLoggedInUserMenu();
        }
    }
    
    private void prepareQuotation()
    {
        //
        
    }
}
