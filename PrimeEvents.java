import java.util.*;
public class PrimeEvents
{
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
    private Boundary boudary;
    /**
     * Constructor for objects of class PE
     */
    public PrimeEvents()
    {
        // initialise instance variables
        listOfUsers = new ListOfUsers();
        listOfHalls = new ListOfHalls();
        listOfBookings = new ListOfBookings();
        listOfReviews = new ListOfReviews();
        listOfQuotations = new ListOfQuotations();
        userDetails = new Vector();
        hasConcession = false;
        boudary = new Boundary();
    }

    public void mainMenu()
    {
        Scanner sc = new Scanner(System.in);
        boudary.displayMainMenu();
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
            default:    boudary.displayMessage("Invalid choice, please try again");
                        loggedInUserMenu();
        }
    }  

    private void userLogin()
    {
        boudary.displayUserLoginBanner();
        listOfUsers.loadUsers();
        while(!login)
        {
            Scanner sc = new Scanner(System.in);
            boudary.displayMessage("Enter username : ");
            String username = sc.nextLine();
            boudary.displayMessage("Enter password : ");
            String pwd = sc.nextLine();
            userDetails = listOfUsers.checkValidUserAndGetDetails(username, pwd);
            if ((Boolean)userDetails.get(0) == true) 
            {
                login = true;
                hasConcession = (Boolean)userDetails.get(3);
                System.out.println(" ");
                boudary.displayMessage("             Welcome " + username);
                loggedInUserMenu();
            }
            else {
                boudary.displayMessage("Invalid credentials");
                boudary.displayMessage("Please try again");
            }
        }
    }

    private void displayRegisterForm() 
    {
        Scanner sc = new Scanner(System.in);
        boudary.displayRegistrationFormBanner();
        int backChoice = 1;
        while (backChoice != 0)
        {
            boudary.displayMessage("Enter 0 to go back ");
            backChoice = sc.nextInt();
            if (backChoice == 0)
            {
                mainMenu();
            }
        }
    }
    
    private void loggedInUserMenu()
    {
        Scanner sc = new Scanner(System.in);
        boudary.displayLoggedInUserMenu();
        int userChoice = sc.nextInt();  
        switch(userChoice)
        {
            case 1 :    boudary.displayHallAndQuotationBanner();
                        hallAndQuotaion();
                        break;
            case 2 :    boudary.displayManageBookingBanner();
                        manageBooking();
                        break;
            case 3 :    boudary.displayReviewBookingBanner();
                        reviewBooking();
                        break;
            default:    boudary.displayMessage("Invalid choice, please try again");
                        loggedInUserMenu();
        }
    }
    
    public void hallAndQuotaion()
    {
        //
        Scanner sc = new Scanner(System.in);
        listOfHalls.displayAllHalls();
        boudary.displayMessage("There are total " + listOfHalls.getNoOfHalls() + " halls");
        boudary.displayMessage("Select any hall to request quotation ");
        int hallIDChoice = sc.nextInt();
        listOfHalls.displayHallById(hallIDChoice);
        listOfHalls.displayHallAvailabilityById(hallIDChoice);
        boudary.displayMessage("Enter S.no of the slot ");
        int sno = sc.nextInt();
        boudary.displayMessage(" -> You selected " + sno + "" );
        boudary.displayMessage("S.no       Slot        Status" );
        String bookingDate = listOfHalls.chooseSlot(sno, hallIDChoice);
        boudary.displayMessage("Please select slot ");
        int slot = sc.nextInt();
        listOfHalls.changeSlotAvail((sno-1), (slot-1), hallIDChoice, false);
        System.out.println("______________________________________________");
        int quotaionNo = listOfQuotations.getNoOfQuotations();
        quotaionNo = quotaionNo + 1;
        boudary.displayMessage("Enter number of guests ");
        int noOfGuests = sc.nextInt();
        Scanner sc2 = new Scanner(System.in);
        boudary.displayMessage("Would you like to have catering?[Y/N] ");
        String catering = sc2.nextLine();
        boolean cateringBool = false;
        if(catering.equals("Y") || catering.equals("y"))
        {
            cateringBool = true;
        }
        String discountCode = "NONE";
        double totalPrice = 0.0;
        String newdiscountCode = "-";
        boudary.displayMessage("price by id " + listOfHalls.getHallPriceById(hallIDChoice));
        if((Boolean)userDetails.get(3) == true)
        {
            //
            boudary.displayMessage("Concession found. You get 20% discount ");
            discountCode = "VETERAN";
            if(cateringBool)
                totalPrice = (noOfGuests * (listOfHalls.getHallPriceById(hallIDChoice) * 0.80 + 20));
            else
                totalPrice = (noOfGuests * listOfHalls.getHallPriceById(hallIDChoice) * 0.80);
            System.out.println(totalPrice);
        }
        else
        {
            boudary.displayMessage("No Concession found. ");
            boudary.displayMessage("Would you like to enter a discount code?[Y/N] ");
            Scanner sc1 = new Scanner(System.in);
            String choice = sc1.nextLine();
            if(choice.equals("Y") || choice.equals("y"))
            {
                boudary.displayMessage("Enter the code - ");
                boolean success = false;
                while(!success)
                {
                    newdiscountCode = sc1.nextLine();
                    if (newdiscountCode.equals("PRIME"))
                    {
                        boudary.displayMessage("15% discount is applied ");
                        if(cateringBool)
                            totalPrice = (noOfGuests * (listOfHalls.getHallPriceById(hallIDChoice) * 0.80 + 20));
                        else
                            totalPrice = (noOfGuests * listOfHalls.getHallPriceById(hallIDChoice) * 0.80);
                        success = true;
                    }
                    else
                    {
                        boudary.displayMessage("Please enter a valid code  ");
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
            listOfQuotations.addQuotation(quotaionNo, hallIDChoice, (int)userDetails.get(4), noOfGuests, 
                cateringBool, bookingDate, (slot-1), true, newdiscountCode, totalPrice);
            boudary.displayMessage("Quotation sent successfully");
        }
        else
        {
            boudary.displayMessage("Quotation has been cancelled");
            hallAndQuotaion();
        }
        loggedInUserMenu();
    }
    
    public void manageBooking()
    {
        //
        Scanner sc = new Scanner(System.in);
        boudary.displayManageBookingMenu();
        int choice = sc.nextInt();
        if(choice == 1)
        {
            listOfQuotations.displayQuotationByUserId((int)userDetails.get(4));
            boudary.displayMessage("Enter quotation id to book a hall ");
            int quotaionId = sc.nextInt();
            listOfQuotations.displayQuotationByUserIdAndQuotationID((int)userDetails.get(4), quotaionId);
            Vector quotationData = listOfQuotations.getQuotationDetailsByUserAndQuotation(
                (int)userDetails.get(4), quotaionId);
            boudary.displayMessage("Would you like to make payment for this hall[Y/N]");
            Scanner sc1 = new Scanner(System.in);
            String check = sc1.nextLine();
            if(check.equals("Y") || check.equals("y"))
            {
                boudary.displayMessage("Payment Successful ");
                int id = listOfBookings.getNoOfBookings();
                id = id+1;
                listOfBookings.addBooking(id, (int)quotationData.get(0), (int)quotationData.get(1), 
                    (String)quotationData.get(2), (double)quotationData.get(3), (int)quotationData.get(4), 
                    (boolean)quotationData.get(5), (String)quotationData.get(6), false);
                manageBooking();
            }
        }
        else if(choice == 2)
        {
            //
            listOfBookings.displayBookingByUserId((int)userDetails.get(4));
            manageBooking();
        }
        else
        {
            //go to main menu
            loggedInUserMenu();
        }
    }
    
    public void reviewBooking()
    {
        //
        Scanner sc = new Scanner(System.in);
        boudary.displayMessage("You can provide review for the following bookings ");
        listOfBookings.displayBookingByUserId((int)userDetails.get(4));
        boudary.displayMessage("Select any booking Id to make Review - ");
        int bookingId = sc.nextInt();
        if(listOfBookings.checkReviewMade(bookingId))
        {
            boudary.displayMessage("You have already provided review for this booking ");
            reviewBooking();
        }
        else
        {
            Vector data = listOfBookings.getBookingDetails(bookingId);
            boudary.displayMessage("Please provide rating [1-5] ");
            float rating = sc.nextFloat();
            boudary.displayMessage("Please provide comment [cannot be more than 500 charaters] ");
            Scanner sc4 = new Scanner(System.in);
            String comment = sc4.nextLine();
            boudary.displayMessage("Would to like to save the review? [Y/N] ");
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
                boudary.displayMessage("Review saved successfully ");
            }
            else
            {
                boudary.displayMessage("Review not saved ");
            }
        }
        loggedInUserMenu();
    }

    private void reqQuotaion(int hallNo)
    {
        //
        Scanner sc = new Scanner(System.in);
        listOfHalls.displayHallById(hallNo);
        boudary.displayMessage("Enter 1 to continue to request quotation");
        int choice = sc.nextInt();
        if(choice == 1)
        {
            //
            boudary.displayMessage("Request quotaion process ");
            boudary.displayMessage("Please enter number of guests ");
            int noOfGuests = sc.nextInt();
            boudary.displayMessage("Please enter booking date");
            String bookingDate = sc.nextLine();
            boudary.displayMessage("Please enter booking slot ");
            int slot = sc.nextInt();
            boudary.displayMessage("Please enter discount if you have any or enter 0 ");
            double discount = sc.nextDouble();
        }
        else
        {
            //
            loggedInUserMenu();
        }
    }
}