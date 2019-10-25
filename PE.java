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
    /*
    // instance variables - replace the example below with your own
    private ListOfUsers listOfUsers;
    private ListOfHalls listOfHalls;
    private ListOfBookings listOfBookings;
    private ListOfReviews listOfReviews;
    private ListOfQuotations listOfQuotations;
    private Vector userDetails;
    private String currentUserRole;
    private boolean hasConcession;
    private int selectedHallId;
    private boolean login = false;

    public PE()
    {
        // initialise instance variables
        listOfUsers = new ListOfUsers();
        listOfHalls = new ListOfHalls();
        listOfBookings = new ListOfBookings();
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
            case 1 :    userLogin();
            break;

            case 2 :    displayRegisterForm();
            break;

            default:    System.out.println("Invalid choice, please try again");
                        displayLoggedInUserMenu();
        }
    }  

    private void userLogin()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#       You are in Loign menu       #");
        System.out.println("#-----------------------------------#");
        listOfUsers.loadUsers();
        while(!login)
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username : ");
            String username = sc.nextLine();
            System.out.print("Enter password : ");
            String pwd = sc.nextLine();
            userDetails = listOfUsers.checkValidUserAndGetDetails(username, pwd);
            //System.out.println(userDetails.get(0).getClass().getSimpleName());
            if ((Boolean)userDetails.get(0) == true) 
            {
                login = true;
                //System.out.println("user id is " + (int)userDetails.get(4));
                hasConcession = (Boolean)userDetails.get(3);
                System.out.println(" ");
                System.out.println("             Welcome " + username);
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
        System.out.println("1. View halls & Request Quotation ");
        System.out.println("2. Manage Bookings");
        System.out.println("3. Review Booking");

        int userChoice = sc.nextInt();  
        switch(userChoice)
        {
            case 1 :    System.out.println("#--------------------------------------------------------#");
                        System.out.println("#       You are in View Halls and Request Quotation      #");
                        System.out.println("#--------------------------------------------------------#");
                        hallAndQuotaion();
                        break;

            case 2 :    System.out.println("#-----------------------------------#");
                        System.out.println("#     You are in Manage Booking     #");
                        System.out.println("#-----------------------------------#");
                        manageBooking();
                        break;

            case 3 :    System.out.println("#-----------------------------------#");
                        System.out.println("#     You are in Review Booking     #");
                        System.out.println("#-----------------------------------#");
                        reviewBooking();
                        break;

            default:    System.out.println("Invalid choice, please try again");
                        displayLoggedInUserMenu();
        }
    }
    
    public void reviewBooking()
    {
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("You can provide review for the following bookings ");
        listOfBookings.displayBookingByUserId((int)userDetails.get(4));
        System.out.print("Select any booking Id to make Review - ");
        int bookingId = sc.nextInt();
        if(listOfBookings.checkReviewMade(bookingId))
        {
            System.out.println("You have already provided review for this booking ");
            reviewBooking();
        }
        else
        {
            Vector data = listOfBookings.getBookingDetails(bookingId);
            System.out.print("Please provide rating [1-5] ");
            float rating = sc.nextFloat();
            System.out.print("Please provide comment [cannot be more than 2000 charaters] ");
            Scanner sc4 = new Scanner(System.in);
            String comment = sc4.nextLine();
            System.out.print("Would to like to save the review? [Y/N] ");
            Scanner sc5 = new Scanner(System.in);
            String choice = sc5.nextLine();
            if (choice.equals("Y") || choice.equals("y"))
            {
                //
                int reviewId = listOfReviews.getNoOfReviews();
                reviewId = reviewId + 1;
                listOfReviews.addReview(reviewId, (int)data.get(0), (int)data.get(1), 
                    (int)data.get(2), rating, comment);
                listOfHalls.setAvgRatingForHall((int)data.get(1), rating);
                listOfBookings.updateReviewComplete((int)data.get(0));
                System.out.println("Review saved successfully ");
            }
            else
            {
                System.out.println("Review not saved ");
            }
        }
        displayLoggedInUserMenu();
    }
    
    public void hallAndQuotaion()
    {
        //
        Scanner sc = new Scanner(System.in);
        listOfHalls.displayAllHalls();
        System.out.println("There are total " + listOfHalls.getNoOfHalls() + " halls");
        System.out.println("Select any hall to request quotation ");
        int hallIDChoice = sc.nextInt();
        listOfHalls.displayHallById(hallIDChoice);
        listOfHalls.displayHallAvailabilityById(hallIDChoice);
        
        System.out.println("Enter S.no of the slot ");
        int sno = sc.nextInt();
        System.out.println(" -> You selected " + sno + "" );
        System.out.println("S.no       Slot        Status" );
        String bookingDate = listOfHalls.chooseSlot(sno, hallIDChoice);
        System.out.print("Please select slot ");
        int slot = sc.nextInt();
        listOfHalls.changeSlotAvail((sno-1), (slot-1), hallIDChoice, false);
        //userDetails.set(3) = true;
        System.out.println("______________________________________________");
        int quotaionNo = listOfQuotations.getNoOfQuotations();
        quotaionNo = quotaionNo + 1;
        System.out.print("Enter number of guests ");
        int noOfGuests = sc.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Would you like to have catering?[Y/N] ");
        String catering = sc2.nextLine();
        boolean cateringBool = false;
        if(catering.equals("Y") || catering.equals("y"))
        {
            cateringBool = true;
        }
        String discountCode = "NONE";
        double totalPrice = 0.0;
        String newdiscountCode = "-";
        System.out.println("price by id " + listOfHalls.getHallPriceById(hallIDChoice));
        if((Boolean)userDetails.get(3) == true)
        {
            //
            System.out.println("Concession found. You get 20% discount ");
            discountCode = "VETERAN";
            if(cateringBool)
                totalPrice = (noOfGuests * (listOfHalls.getHallPriceById(hallIDChoice) * 0.80 + 20));
            else
                totalPrice = (noOfGuests * listOfHalls.getHallPriceById(hallIDChoice) * 0.80);
            System.out.println(totalPrice);
        }
        else
        {
            System.out.println("No Concession found. ");
            System.out.print("Would you like to enter a discount code?[Y/N] ");
            Scanner sc1 = new Scanner(System.in);
            String choice = sc1.nextLine();
            if(choice.equals("Y") || choice.equals("y"))
            {
                System.out.print("Enter the code - ");
                boolean success = false;
                while(!success)
                {
                    newdiscountCode = sc1.nextLine();
                    if (newdiscountCode.equals("PRIME"))
                    {
                        System.out.println("15% discount is applied ");
                        if(cateringBool)
                            totalPrice = (noOfGuests * (listOfHalls.getHallPriceById(hallIDChoice) * 0.80 + 20));
                        else
                            totalPrice = (noOfGuests * listOfHalls.getHallPriceById(hallIDChoice) * 0.80);
                        success = true;
                    }
                    else
                    {
                        System.out.println("Please enter a valid code  ");
                    }
                }

            }
            else
            {
                totalPrice = (noOfGuests * listOfHalls.getHallPriceById(hallIDChoice));
            }
        }
        System.out.println("____________________________________________________");
        System.out.println("Hall ID          - " + hallIDChoice);
        System.out.println("Guests           - " + noOfGuests);
        String cat = cateringBool ? "Yes" : "No";
        System.out.println("Catering         - " + cat);
        System.out.println("Discount Code    - " + newdiscountCode);
        System.out.println("Total Price      - " + totalPrice);
        System.out.println("____________________________________________________");
        System.out.print("Would you like to send Quotation? [Y/N] ");
        Scanner sc3 = new Scanner(System.in);
        String choice = sc3.nextLine();
        if(choice.equals("Y") || choice.equals("y"))
        {
            listOfQuotations.addQuotation(quotaionNo, hallIDChoice, (int)userDetails.get(4), noOfGuests, cateringBool, 
            bookingDate, (slot-1), true, newdiscountCode, totalPrice);
            System.out.println("Quotation sent successfully");
        }
        else
        {
            System.out.println("Quotation has been cancelled");
            hallAndQuotaion();
        }
        displayLoggedInUserMenu();
    }
    
    public void manageBooking()
    {
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View all Quotaions & Create Booking");
        System.out.println("2. View my Bookings");
        System.out.println("3. Go to Main menu");
        int choice = sc.nextInt();
        if(choice == 1)
        {
            listOfQuotations.displayQuotationByUserId((int)userDetails.get(4));
            System.out.println("Enter quotation id to book a hall ");
            int quotaionId = sc.nextInt();
            listOfQuotations.displayQuotationByUserIdAndQuotationID((int)userDetails.get(4), quotaionId);
            Vector quotationData = listOfQuotations.getQuotationDetailsByUserAndQuotation((int)userDetails.get(4), quotaionId);
            System.out.println("Would you like to make payment for this hall[Y/N]");
            Scanner sc1 = new Scanner(System.in);
            String check = sc1.nextLine();
            if(check.equals("Y") || check.equals("y"))
            {
                System.out.println("Payment Successful ");
                
                int id = listOfBookings.getNoOfBookings();
                id = id+1;
                listOfBookings.addBooking(id, (int)quotationData.get(0), (int)quotationData.get(1), (String)quotationData.get(2), 
                    (double)quotationData.get(3), (int)quotationData.get(4), (boolean)quotationData.get(5), 
                    (String)quotationData.get(6), false);
                manageBooking();
            }
        }
        else if(choice == 2)
        {
            //
            System.out.println("chosen 2");
            listOfBookings.displayBookingByUserId((int)userDetails.get(4));
            manageBooking();
        }
        else
        {
            //go to main menu
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
    }*/
}
