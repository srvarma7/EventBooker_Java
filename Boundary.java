import java.util.*;
/**
 * Write a description of class Boundary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Boundary
{
    
    public Boundary()
    {
        // initialise instance variables
    }
    
    public void displayMainMenu()
    {
        System.out.println("##############################");
        System.out.println("# Welcome to Prime Events!!! #");
        System.out.println("#       1. Loign             #");
        System.out.println("#       2. Register          #");
        System.out.println("##############################");
    }
    
    public void displayUserLoginBanner()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#       You are in Loign menu       #");
        System.out.println("#-----------------------------------#");
    }
    
    public void displayRegistrationFormBanner()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#      You are in Register menu     #");
        System.out.println("#-----------------------------------#");
    }
    
    public void displayHallAndQuotationBanner()
    {
        System.out.println("#--------------------------------------------------------#");
        System.out.println("#       You are in View Halls and Request Quotation      #");
        System.out.println("#--------------------------------------------------------#");
    }
    
    public void displayManageBookingBanner()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#     You are in Manage Booking     #");
        System.out.println("#-----------------------------------#");
    }
    
    public void displayReviewBookingBanner()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#     You are in Review Booking     #");
        System.out.println("#-----------------------------------#");
    }
    
    public void displayLoggedInUserMenu()
    {
        System.out.println("#-----------------------------------#");
        System.out.println("#     You are in User Main Menu     #");
        System.out.println("#-----------------------------------#");
        System.out.println("1. View halls & Request Quotation ");
        System.out.println("2. Manage Bookings");
        System.out.println("3. Review Booking");
    }
    
    public void displayManageBookingMenu()
    {
        System.out.println("1. View all Quotaions & Create Booking");
        System.out.println("2. View my Bookings");
        System.out.println("3. Go to Main menu");
    }

    public void displayMessage(String data)
    {
        System.out.println(data);
    }
    
}
