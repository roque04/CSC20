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
    
    public static void phoneMenu(){
        menu = "\n Contact Book Menu Options \n\n"+
        "P: Print Phonebook\n"+
        "B: Sort phone book by first name\n"+
        "L: Sort phone book by last name\n"+
        "S: Search contact by last name\n"+
        "A: Add contact to phone book\n"+
        "Q. Quit\n";

        try {
            phoneBook = new PhoneBook("ContactDetail.txt");
            scan = new Scanner(System.in);
            boolean running = true;

            while(running){
                System.out.println(menu);
                System.out.print("Please enter your choice: ");
                String choice = scan.nextLine().toUpperCase();

                switch(choice){
                    case "P":
                        break;
                    case "B":
                        break;
                    case "L":
                        break;
                    case "S":
                        break;
                    case "A":
                        break;
                    case "Q":
                        running = false;
                        break;
                    default:
                        throw new InputMismatchException("INCORRECT INPUT");
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        System.out.println("Good bye!");
    }

}
