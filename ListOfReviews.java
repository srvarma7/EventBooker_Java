import java.util.ArrayList;
/**
 * Write a description of class ListofReviews here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListOfReviews
{
    // instance variables - replace the example below with your own
    private ArrayList<Review> reviewList;
    /**
     * Constructor for objects of class ListofReviews
     */
    public ListOfReviews()
    {
        // initialise instance variables
        reviewList = new ArrayList<Review>();
        loadReviews();
    }
    
    public void loadReviews()
    {
        //
        addReview(1, 1, 1, 2, 4.5, "Good place for events");
        addReview(2, 2, 1, 2, 4.5, "Nice place to hangout");
        addReview(3, 3, 1, 2, 4.5, "Nice place to hangout");
    }

    public void addReview(int newReviewId, int newBookingId, int newHallId, int newUserId, 
        double newRating, String newComment)
    {
        //
        Review review = new Review();
        review.addReview(newReviewId, newBookingId, newHallId, newUserId, newRating, newComment);
        reviewList.add(review);
    }
    
    public void displayReviewByHallId(int hallId)
    {
        //
        for (Review ob : reviewList)
        {
            if (ob.getHallId() == hallId)
            {
                System.out.println("Review Id - " + ob.getReviewId());
                System.out.println("Rating - " + ob.getRating());
                System.out.println("Account status - " + ob.getComment());
                System.out.println("------------------------------------------------------------");
            }
        }
    }
    
    public int getNoOfReviews()
    {
        return reviewList.size();
    }
}
