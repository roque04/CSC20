import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;
/**
 * @author Roque Busto
 * Date: 4/27/2023
 */
public class PhoneBook{
    public ArrayList<Contact> contacts;

    /**
     * create arraylist of contacts by reading data from the file
     */
    public PhoneBook(){
        contacts = new ArrayList<>();
    }
    /*public PhoneBook(String phoneFile) throws FileNotFoundException {
        contacts = new ArrayList<>();
        Scanner fileReader = null;
        fileReader = new Scanner(new File(phoneFile));
        String[] info;
        String line;

        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
            info = line.split(",");
            contacts.add(info[0], info[1],Long.valueOf(info[2]),Long.valueOf(info[3]),info[4]);
        }
        fileReader.close();
    }*/

    public PhoneBook(File file){
        contacts = new ArrayList<>();
        Scanner fileReader = null;
        try{
            fileReader = new Scanner(file);
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        String firstName, lastName, emailAddress;
        long homeNumber, officeNumber;

        String[] info;
        int index = 0;
        while(fileReader.hasNextLine()){
            info = fileReader.nextLine().split(",");
            /*if(info.get(index).contains("-")){
                info = "Zero";
            }*/
            Contact information = new Contact(info[0], info[1],Long.valueOf(info[2]),Long.valueOf(info[3]),info[4]);

            contacts.add(information);
        }
        fileReader.close();
        
    }
    /**
     * add contact to the array list
     * @param c
     */
    public void add(Contact c){
        contacts.add(c);
    }
    /**
     * returns the entire phone book as string
     */
    public String toString(){
        return "";
    }
    /**
     * Sort phonebook by first name
     */
    public void bubbleSort(){
        for(int i = 0; i < contacts.size(); i++){ // for every contact in the list.
            for(int j = i+1; j < contacts.size(); j++){ // compare a contact to every other contact.
                //if a name that is further down the list is out of place.
                //it will be switched to be in its right place.
                if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName())<0){ 

                    // add code here to perform the bubble sort

                }
            } // -1 0 1
        }
    }
    /**
     * Sort phone book by last using selection sort algorithm
     */
    public void selectionSort(){
        for(int i = 0; i < contacts.size(); i++){ // for every contact in the list.
            Contact smallest = contacts.get(i); // a counter for the smallest last name is set
            int smallestIndex = i; // smallestIndex counter is declared.

            for(int j = i; j < contacts.size(); j++){ // compare a contacts to every other contacts.
                String value = contacts.get(j).getLastName();
                if(value.compareTo(smallest.getLastName()) < 0){ // if the last name is out of place.

                    // add code here

                }
            }
            if(smallestIndex != i){ // if the smallest index is not itseld, the contacts will switch places.

                // add code here

                // use the above comments as hints to craft your program

            }
        }
    }
    /**
     * Search contact by last name using binary search.
     * @param name
     * @return return true if contact is found else false.
     */
    public boolean binarySearch(String name){
        return false;
    }
}