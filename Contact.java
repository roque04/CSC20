/**
 * @author Roque Busto
 * Date: 4/27/2023
 */
public class Contact {
    private String firstName;
    private String lastName;
    private long homeNumber;
    private long officeNumber;
    private String emailAddress;

    public Contact(){
        firstName = "";
        lastName = "";
        homeNumber = 0;
        officeNumber = 0;
        emailAddress = "";
    }
    /**
     * Contructor setting all details.
     * @param firstName
     * @param lastName
     * @param homeNumber
     * @param officeNumber
     * @param emailAddress
     */
    public Contact(String firstName, String lastName, long homeNumber, long officeNumber, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeNumber = homeNumber;
        this.officeNumber = officeNumber;
        this.emailAddress = emailAddress;
    }
    // Getters //
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public long getHomeNumber(){
        return homeNumber;
    }
    public long getOfficeNumber(){
        return officeNumber;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    // Setters //
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setHomeNumber(long homeNumber){
        this.homeNumber = homeNumber;
    }
    public void setOfficeNumber(long officeNumber){
        this.officeNumber = officeNumber;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    // toString //
    public String toString(){
        return "";

    //write this method using printf or if/else to format the output correctly.

    }
}