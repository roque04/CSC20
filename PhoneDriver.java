import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Roque Busto
 * Date: 4/27/2023
 */
public class PhoneDriver {
    private static String menu;
    private static Scanner scan;
    private static PhoneBook phoneBook;
    

    public static void main(String[] args){
        phoneMenu();
    }
    
    
    public static void phoneMenu(){
        menu = "\n Phone Book Menu Options \n\n"+
        "P: Print Phonebook\n"+
        "B: Sort phone book by first name\n"+
        "L: Sort phone book by last name\n"+
        "S: Search contact by last name\n"+
        "A: Add contact to phone book\n"+
        "Q. Quit\n";

        phoneBook = new PhoneBook(new File("ContactDetails.txt"));
        scan = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println(menu);
            System.out.print("Please enter your choice: ");
            String choice = scan.nextLine().toUpperCase();

            switch(choice){
                case "P":
                    phoneBook.toString();
                    break;
                case "B":
                    System.out.println("Sorting by the First Name");
                    phoneBook.bubbleSort();
                    break;
                case "L":
                    System.out.println("Sorting by the Last Name");
                    phoneBook.selectionSort();
                    break;
                case "S":
                    System.out.println("Searching by Last Name");
                    if(!phoneBook.binarySearch(scan.nextLine())){
                        System.out.println("Contact not found");
                    } else {
                        System.out.println("Contact found");
                    }
                    break;
                case "A":
                    System.out.println("Adding contact");

                    break;
                case "Q":
                    running = false;
                    break;
                default:
                    throw new InputMismatchException("INCORRECT INPUT");
            }
        }
        System.out.println("Good bye!");
    }

}
