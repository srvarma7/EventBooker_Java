/**


import java.util.Scanner;
import java.util.ArrayList;

public class PrimeEvents
{
    // instance variables - replace the example below with your own
    //private ListOfHalls halls;
    
    
    //FOR LINES
    
    private Quotation qu = new Quotation();
    //private Review re = new Review();
    private ListOfUsers users = new ListOfUsers();
    private ListOfBookings bookings = new ListOfBookings();
    private ListOfReviews reviews = new ListOfReviews();
    

    
    public PrimeEvents()
    {
        halls = new ListOfHalls();
    }

    public PrimeEvents(ListOfHalls newHalls)
    {
        halls = newHalls;
    }

    public ListOfHalls getHalls()
    {
        return halls;
    }

    public void setHalls(ListOfHalls newHalls)
    {
        halls = newHalls;
    }

   
    public void mainPage()
    {
        System.out.println("##############################");
        System.out.println("# Welcome to Prime Events!!! #");
        System.out.println("#    1. Loign                #");
        System.out.println("#    2. Register             #");
        System.out.println("#    3. View the halls       #");
        System.out.println("#    4. Search a hall        #");
        System.out.println("##############################");
    }

    public int action()
    {
        System.out.print("Please select a number(1-4): ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == 1)
        {
            login();
        }
        return number;
    }

    public void login()
    {
        System.out.println("##############################");
        System.out.println("#    Who are you?            #");
        System.out.println("#    1. Owner                #");
        System.out.println("#    2. Administrator        #");
        System.out.println("#    3. Customer             #");
        System.out.println("##############################");
        System.out.print("Please select a number(1-3): ");
        Scanner sc1 = new Scanner(System.in);
        int number = sc1.nextInt();
        if (number == 1)
        {
            System.out.print("Please enter your username: ");
            Scanner sc2 = new Scanner(System.in);
            String username = sc2.nextLine();
            System.out.print("Please enter your password: ");
            Scanner sc3 = new Scanner(System.in);
            String password = sc3.nextLine();
            System.out.println("Welcome! " + username);
            while(true)
            {
                int choice = ownerLogedIn();
                if (choice == 2)
                {
                    createAHall();
                }
                if (choice == 3)
                {
                    editAHall();
                }
                if (choice == 6)
                {
                    mainPage();
                    break;
                }
            }
        }
        if (number == 3)
        {
            System.out.print("Please enter your username: ");
            Scanner sc2 = new Scanner(System.in);
            String username = sc2.nextLine();
            System.out.print("Please enter your password: ");
            Scanner sc3 = new Scanner(System.in);
            String password = sc3.nextLine();
            System.out.println("Welcome! " + username);
            while(true)
            {
                int choice = customerLogedIn();
                if (choice == 1)
                {
                    System.out.println("##############################");
                    System.out.println("View the halls");
                }
                if (choice == 2)
                {
                    System.out.println("##############################");
                    System.out.println("Search a hall               ");
                }
                if (choice == 3)
                {
                    System.out.println("##############################");
                    System.out.println("Request quotation               ");
                }
                if (choice == 4)
                {
                    System.out.println("##############################");
                    System.out.println("Book a hall                              ");
                }
                if (choice == 5)
                {
                    mainPage();
                    break;
                }
            }
        }
    }

    public int ownerLogedIn()
    {
        System.out.println("##############################");
        System.out.println("#    What do you want to do  #");
        System.out.println("#    1. Reply quotation      #");
        System.out.println("#    2. Create a hall                       #");
        System.out.println("#    3. Edit a hall          #");
        System.out.println("#    4. View the halls       #");
        System.out.println("#    5. Search a hall        #");
        System.out.println("#    6. Logout                                             #");
        System.out.println("##############################");
        System.out.print("Please select a number(1-6): ");
        Scanner sc4 = new Scanner(System.in);
        int choice = sc4.nextInt();
        return choice;
    }

    public int customerLogedIn()
    {
        System.out.println("##############################");
        System.out.println("#    What do you want to do  #");
        System.out.println("#    1. View the halls       #");
        System.out.println("#    2. Search a hall                    #");
        System.out.println("#    3. Request quotation                   #");
        System.out.println("#    4. Book a hall                         #");
        System.out.println("#    5. Logout               #");
        System.out.println("##############################");
        System.out.print("Please select a number(1-5): ");
        Scanner sc4 = new Scanner(System.in);
        int choice = sc4.nextInt();
        return choice;
    }

    public void createAHall()
    {
        System.out.println("##############################");
        System.out.println("You decide to create a hall");
        System.out.println("##############################");
        System.out.println("Please enter a hall number");
        Scanner sc5 = new Scanner(System.in);
        String hallnumber = sc5.nextLine();
        System.out.println("Please enter a hall name");
        Scanner sc6 = new Scanner(System.in);
        String hallname = sc6.nextLine();
        System.out.println("Please enter a hall location");
        Scanner sc7 = new Scanner(System.in);
        String halllocation = sc7.nextLine();
        System.out.println("Please enter a hall size");
        Scanner sc8 = new Scanner(System.in);
        int hallsize = sc8.nextInt();
        System.out.println("Please enter a hall description");
        Scanner sc9 = new Scanner(System.in);
        String halldescription = sc9.nextLine();
        System.out.println("****************************************");
        System.out.println("You have created a hall");
        System.out.println("Hall Number: " + hallnumber);
        System.out.println("Hall Name: " + hallname);
        System.out.println("Hall Location: " + halllocation);
        System.out.println("Hall Size: " + hallsize);
        System.out.println("Hall Description: " + halldescription);
        System.out.println("****************************************");
        halls.addHall(hallnumber, hallname, halllocation, hallsize, halldescription, true, 0.0);
    }

    public void editAHall()
    {
        System.out.println("##############################");
        System.out.println("You decided to edit a hall");
        System.out.println("##############################");
        System.out.println("Please enter the hall number to edit");
        Scanner sc10 = new Scanner(System.in);
        String hallnumber = sc10.nextLine();
        for(int i = 0; i < halls.getHalls().size(); i++)
        {
            if (hallnumber.equals(halls.getHalls().get(i).getHallnumber()))
            {
                System.out.println("Originally hall information is: ");
                String oriNumber = halls.getHalls().get(i).getHallnumber();
                String oriName = halls.getHalls().get(i).getHallname();
                String oriLocation = halls.getHalls().get(i).getHalllocation();
                int oriSize = halls.getHalls().get(i).getHallsize();
                String oriDescription = halls.getHalls().get(i).getHalldescription();
                Boolean oriAvailability = halls.getHalls().get(i).getAvailability();
                System.out.println("Hall Number: " + oriNumber);
                System.out.println("Hall Name: " + oriName);
                System.out.println("Hall Location: " + oriLocation);
                System.out.println("Hall Size: " + oriSize);
                System.out.println("Hall Description: " + oriDescription);
                System.out.println("Hall Availability: " + oriAvailability);
                String newHallnumber = "";
                String newHallname = "";
                String newHalllocation = "";
                int newHallsize = 0;
                String newHalldescription = "";
                while(true)
                {
                    System.out.println("########################################");
                    System.out.println("#  Which section do you want to edit?  #");
                    System.out.println("#    1. Hall Number                    #");
                    System.out.println("#    2. Hall Name                                     #");
                    System.out.println("#    3. Hall Location                  #");
                    System.out.println("#    4. Hall Size                                                    #");
                    System.out.println("#    5. Hall Description               #");
                    System.out.println("#    6. Hall Availability                                         #");
                    System.out.println("#    7. Get away from edit a hall                            #");
                    System.out.println("########################################");
                    System.out.print("Please select a number(1-7): ");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    if(choice == 1)
                    {
                        System.out.println("Please enter a new hall number");
                        Scanner sc11 = new Scanner(System.in);
                        newHallnumber = sc11.nextLine();
                        halls.getHalls().get(i).setHallnumber(newHallnumber);
                    }
                    if(choice == 2)
                    {
                        System.out.println("Please enter a new hall name");
                        Scanner sc12 = new Scanner(System.in);
                        newHallname = sc12.nextLine();
                        halls.getHalls().get(i).setHallname(newHallname);
                    }
                    if(choice == 3)
                    {
                        System.out.println("Please enter a new hall location");
                        Scanner sc13 = new Scanner(System.in);
                        newHalllocation = sc13.nextLine();
                        halls.getHalls().get(i).setHalllocation(newHalllocation);
                    }
                    if(choice == 4)
                    {
                        System.out.println("Please enter a new hall size");
                        Scanner sc14 = new Scanner(System.in);
                        newHallsize = sc14.nextInt();
                        halls.getHalls().get(i).setHallsize(newHallsize);
                    }
                    if(choice == 5)
                    {
                        System.out.println("Please enter a new hall description");
                        Scanner sc15 = new Scanner(System.in);
                        newHalldescription = sc15.nextLine();
                        halls.getHalls().get(i).setHalldescription(newHalldescription);
                    }
                    if(choice == 6)
                    {

                    }
                    if(choice == 7)
                    {
                        break;
                    }
                }
                System.out.println("New edit hall information is: ");
                String newNumber1 = halls.getHalls().get(i).getHallnumber();
                String newName1 = halls.getHalls().get(i).getHallname();
                String newLocation1 = halls.getHalls().get(i).getHalllocation();
                int newSize1 = halls.getHalls().get(i).getHallsize();
                String newDescription1 = halls.getHalls().get(i).getHalldescription();
                Boolean newAvailability1 = halls.getHalls().get(i).getAvailability();
                System.out.println(newNumber1 + " " + newName1 + " " + newLocation1 + " " + newSize1 + " " + newDescription1 + " " + newAvailability1);
            }
        }
    }

    public void register()
    {

    }

    public void play()
    {
        mainPage();
        action();
    }
    
    public void bookAHall()
    {
        int nmbOfGuests = 0;
        String eventType = "";
        System.out.println("Please enter number of guests");
        Scanner sc14 = new Scanner(System.in);
        //nmbOfGuests = sc14.nextLine();
        System.out.println("Please enter a type of event");
        Scanner sc15 = new Scanner(System.in);
        eventType = sc15.nextLine();
        System.out.println("");
    }
}
*/