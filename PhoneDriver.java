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
                    print();
                    break;
                case "B":
                    System.out.println("Sorting by the First Name\n\n");
                    phoneBook.bubbleSort();
                    break;
                case "L":
                    System.out.println("Sorting by the Last Name\n\n");
                    phoneBook.selectionSort();
                    break;
                case "S":
                    System.out.println("Searching by Last Name\n\n");
                    search();
                    break;
                case "A":
                    System.out.println("Adding contact\n\n");
                    add();
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
    public static void add(){
        String firstName, lastName, emailAddress;
        long homeNumber, officeNumber;

        System.out.println("Enter First Name: ");
        firstName = scan.nextLine();
        System.out.println("Enter Last Name: ");
        lastName = scan.nextLine();
        System.out.println("Enter Home Number: ");
        homeNumber = scan.nextLong();
        System.out.println("Enter Office Number: ");
        officeNumber = scan.nextLong();
        System.out.println("Enter Email Address: ");
        emailAddress = scan.nextLine();
        emailAddress = scan.nextLine();
        
        System.out.println("Adding: "+firstName + " " + lastName + " " + homeNumber + " " + officeNumber + " " + emailAddress);

        phoneBook.add(new Contact(firstName, lastName, homeNumber, officeNumber, emailAddress));

    }
    public static void print(){
        phoneBook.displayMethod();
    }
    public static void search(){
        String lastName = scan.nextLine();

        if(!phoneBook.binarySearch(lastName)){
            System.out.println("Contact not found");
        } else {
            System.out.println("Contact found");
        }
    }
}
