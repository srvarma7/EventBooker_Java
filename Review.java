
/**
 * Write a description of class Review here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Review
{
    // instance variables - replace the example below with your own
    private int reviewId;
    private int bookingId;
    private int hallId;
    private int userId;
    private double rating;
    private String comment;
    
    /**
     * Constructor for objects of class Review
     */
    public Review()
    {
        // initialise instance variables
    }
    
    public void addReview(int newReviewId, int newBookingId, int newHallId, int newUserId, double newRating, String newComment)
    {
        //
        reviewId = newReviewId;
        bookingId = newBookingId;
        hallId = newHallId;
        userId = newUserId;
        rating = newRating;
        comment = newComment;
    }
    
    public int getReviewId()
    {
        return reviewId;
    }
    
    public void setReviewId(int newReviewId)
    {
        reviewId = newReviewId;
    }
    
    public int getBookingId()
    {
        return bookingId;
    }
    
    public void setBookingId(int newBookingId)
    {
        bookingId = newBookingId;
    }
    
    public int getHallId()
    {
        return hallId;
    }
    
    public void setHallId(int newHallId)
    {
        hallId = newHallId;
    }
    
    public int getUserId()
    {
        return userId;
    }
    
    public void setUserId(int newUserId)
    {
        userId = newUserId;
    }
    
    public double getRating()
    {
        return rating;
    }
    
    public void setRating(double newRating)
    {
        rating = newRating;
    }
    
    public String getComment()
    {
        return comment;
    }
    
    public void getComment(String newcomment)
    {
        comment = newcomment;
    }
}
