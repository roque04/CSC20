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

    }
    public PhoneBook(String phoneFile) throws FileNotFoundException {
        Scanner fileReader = null;
        fileReader = new Scanner(new File(phoneFile));
        String[] info;
        String line;

        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
            info = line.split(",");
            contacts.add(info[0], info[1],Integer.valueOf(info[2]),Integer.valueOf(info[3]),info[4]);
        }
        fileReader.close();
    }
    /**
     * add contact to the array list
     * @param c
     */
    public add(Contact c){

    }
    /**
     * returns the entire phone book as string
     */
    public toString(){

    }
    /**
     * Sort phonebook by first name
     */
    public void bubbleSort(){

    }
    /**
     * Sort phone book by last using selection sort algorithm
     */
    public void selectionSort(){

    }
    /**
     * Search contact by last name using binary search.
     * @param name
     * @return return true if contact is found else false.
     */
    public boolean binarySearch(String name){

    }
}