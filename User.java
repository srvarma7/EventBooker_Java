import java.util.ArrayList;
/**
 * Write a description of class User here.
 *
 * @author Chola Kallepalli
 * @version 23/09/19
 */
public class User
{
    // instance variables - replace the example below with your own
    
    private int uId;
    private String username;
    private String pwd;
    private String role;
    private boolean status;
    private boolean hasConcession;
    
    /**
     * Constructor for objects of class User
     */
    public User()
    {
        // initialise instance variables
    }
    
    public void addUser(int newUId, String newUserName, String newPwd, String newRole, boolean newStatus, boolean hasConcession)
    {
        uId = newUId;
        username = newUserName;
        pwd = newPwd;
        role = newRole;
        status = newStatus;
        hasConcession = hasConcession;
    }
    
    public void setUId(int newUId)
    {
        uId = newUId;
    }
    
    public int getUId()
    {
        return uId;
    }

    public void setUsername(String newUsername)
    {
        username = newUsername;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPwd(String newPwd)
    {
        pwd = newPwd;
    }
    
    public String getPwd()
    {
        return pwd;
    }
    
    public void setRole(String newRole)
    {
        role = newRole;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void setStatus(boolean newStatus)
    {
        status = newStatus;
    }
    
    public boolean getStatus()
    {
        return status;
    }
    
    public void setHasConcession(boolean newHasConcession)
    {
        hasConcession = newHasConcession;
    }
    
    public boolean getHasConcession()
    {
        return hasConcession;
    }
}
