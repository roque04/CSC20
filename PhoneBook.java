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
        return "Array of contacts: \n" + contacts;
    }
    /**
    * Sorts the phonebook by first name using the bubble sort algorithm.
    */
    public void bubbleSort(){
        for(int i = 0; i < contacts.size(); i++){ // for every contact in the list.
            for(int j = i+1; j < contacts.size(); j++){ // compare a contact to every other contact.
                //if a name that is further down the list is out of place.
                //it will be switched to be in its right place.
                if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName())<0){ 


                    Contact temp = contacts.get(i);
                    contacts.set(i, contacts.get(j));
                    contacts.set(j, temp);

                
                }
            } 
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

                    smallestIndex = j;

                }
            }
            if(smallestIndex != i){ // if the smallest index is not itself, the contacts will switch places.


                Contact temp = contacts.get(smallestIndex);
                contacts.set(smallestIndex, contacts.get(i));
                contacts.set(i, temp);
                
            }
        }
    }

    
	/**
	 * This function searches for a contact by last name using binary search.
	 * @param lastName The last name of the contact to search for.
	 * @return true if the contact is found, false otherwise.
	 */
	public boolean binarySearch(String lastName){
		
		if(this.contacts.size()>=0){
			
			if(this.contacts.size() < 14){
				this.selectionSort();

			}
			// Variables for binary search.
			int foundIndex, min = 0, max = contacts.size()-1;

			// Keep searching until we have searched the entire array.
			while (min <= max){
				// Find the middle index of the array.
				int middle = (min+max)/2;
				// Compare the last name of the contact at the middle index to the last name we are searching for.
				int current = lastName.compareToIgnoreCase(String.valueOf(contacts.get(middle).getLastName()));

				// If the last names match, we have found the contact.
				if(current == 0){
					
					System.out.println(contacts.get(middle).toString());
					// Return true to indicate that the contact was found.
					return true;
				} else if (current < 0){
					
					max = middle - 1;
				} else {
					
					min = middle + 1;
				}
			}
		}
		// If we have searched the entire array and the contact was not found, return false.
		return false;
	}
}