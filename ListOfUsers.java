import java.util.ArrayList;
import java.util.Vector;
/**
  * Write a description of class ListOfUsers here.
  *
  * @author Chola Kallepalli
  * @version 23/09/19
  */
public class ListOfUsers
{
    // instance variables - replace the example below with your own
    private ArrayList<User> userList;
    
    /**
     * Constructor for objects of class ListOfUsers
     */
    public ListOfUsers()
    {
        // initialise instance variables
        userList = new ArrayList<User>();
        loadUsers();
    }
    
    public void loadUsers()
    {
        //addUser(String username, String pwd, String role, boolean status, boolean hasConcession)
        addUser(1, "admin","admin","Admin",true, false);
        addUser(2, "sai", "sai", "Customer", true, false);
        //System.out.println("*****Users loaded*****");
    }
    
    public int getNoOfUsers()
    {
        int no = userList.size();
        return no;
    }
    
    public void displayAllUsers()
    {
        for (User ob : userList)
        {
            System.out.println("Email - " + ob.getUsername());
            //System.out.println("Password - " + ob.getPwd());
            System.out.println("Role - " + ob.getRole());
            System.out.println("Account status - " + ob.getStatus());
            System.out.println("Has concession - " + ob.getHasConcession());
            System.out.println("--------------------------------------");
        }
    }
    
    public void displayUserById(String username)
    {
        for (User ob : userList)
        {
            if (ob.getUsername() == username)
            {
                System.out.println("Email - " + ob.getUsername());
                //System.out.println("Password - " + ob.getPwd());
                System.out.println("Role - " + ob.getRole());
                System.out.println("Account status - " + ob.getStatus());
                System.out.println("Has concession - " + ob.getHasConcession());
                System.out.println("--------------------------------------");
            }
        }
    }
    
    public boolean checkUsername(String email)
    {
        boolean statusName = false;
        for (User ob : userList)
        {
            if (ob.getUsername() == email)
            {
                statusName = true;
            }
        }
        return statusName;
    }
    
    public boolean validUser(String username , String pwd)
    {
        boolean statusUser = false;
        for (User ob : userList)
        {
            if (ob.getUsername().equals(username) && ob.getPwd().equals(pwd))
            {
                statusUser = true;
                break;
            }
        }
        return statusUser;
    }
    
    public Vector checkValidUserAndGetDetails(String username, String pwd)
    {
        boolean statusUser = false;
        String userName = " ";
        String userRole = "not found";
        boolean accountStatus = false;
        boolean hasConcession = false;
        Vector list = new Vector();
        
        for (User ob : userList)
        {
            if (ob.getUsername().equals(username) && ob.getPwd().equals(pwd))
            {
                statusUser = true;
                if (statusUser)
                {
                    userName = ob.getUsername();
                    userRole = ob.getRole();
                    accountStatus = ob.getStatus();
                    hasConcession = ob.getHasConcession();
                }
            }
        }
        list.add(statusUser);
        list.add(userRole);
        list.add(accountStatus);
        list.add(hasConcession);
        return list;
    }

    public void addUser(int uid, String username, String pwd, String role, boolean status, boolean hasConcession)
    {
        User newUser = new User();
        newUser.addUser(uid, username, pwd, role, status, hasConcession);
        userList.add(newUser);
    }
    
    public boolean updateUserDetails(int item, String email, boolean newUserStatus, String newPwd)
    {
        boolean changeStatus = false;
        for (User ob : userList)
        {
            if (ob.getUsername() == email)
            {
                if (item == 1)
                {
                    ob.setStatus(newUserStatus);
                    changeStatus = true;
                }
                if (item == 2)
                {
                    ob.setPwd(newPwd);
                    changeStatus = true;
                }
            }
        }
        return changeStatus;
    }
}
