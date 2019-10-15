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
    private String currentUserRole;
    private ListOfUsers lou = new ListOfUsers();
    private ListOfHalls loh = new ListOfHalls();
    private ListOfBookings lob = new ListOfBookings();
    private ListOfReviews listOfReviews = new ListOfReviews();
    private ListOfQuotations listOfQuotations = new ListOfQuotations();
    private Vector userDetails = new Vector();
    boolean login = false;
    
    /**
     * Constructor for objects of class PE
     */
    public PE()
    {
        // initialise instance variables
        //welcome();
    }
    
    public void displayWelcome()
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
                            /*
                            System.out.println("Please enter your username : ");
                            Scanner sc3 = new Scanner(System.in);
                            String username = sc3.nextLine();
                            boolean stat = lou.checkUsername(username);
                            System.out.println(lou.checkUsername(username));
                            if (lou.checkUsername(username))
                            {
                                System.out.println("Please enter your password : ");
                                
                                String pwd = sc.nextLine();
                                userDetails = lou.checkValidUserAndGetDetails(username, pwd);
                                System.out.println("TEST" + userDetails.get(0));
                                //if (userDetails.get(0))
                                {
                                    login = true;
                                }
                            }
                            else
                            {
                                System.out.println("Invalid username");
                                System.out.println("Please try again");
                            }
                            }
                            break;
                                /*
                            
                                */
                        
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
        lou.loadUsers();
        while(!login)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username : ");
            String username = sc.nextLine();
            System.out.println("Enter password : ");
            String pwd = sc.nextLine();
            userDetails = lou.checkValidUserAndGetDetails(username, pwd);
            //System.out.println(userDetails.get(0).getClass().getSimpleName());
            if ((Boolean)userDetails.get(0) == true) 
            {
                login = true;
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
                displayWelcome();
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
        
        int userChoice = sc.nextInt();  
        switch(userChoice)
        {
            case 1 :    System.out.println("#-----------------------------------#");
                        System.out.println("#       You are in View Halls       #");
                        System.out.println("#-----------------------------------#");
                        loh.displayAllHalls();
                        System.out.println("There are total " + loh.getNoOfHalls() + " halls");
                        System.out.println("Select any hall to request quotation ");
                        System.out.println("Enter 0 to go back");
                        int choice = sc.nextInt();
                        while (choice < 0 || choice > loh.getNoOfHalls())
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
                        
            default:    System.out.println("Invalid choice, please try again");
                        displayLoggedInUserMenu();
        }
    }
}
