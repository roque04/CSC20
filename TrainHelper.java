import java.io.FileNotFoundException;
import java.util.*;

public class TrainHelper {

    private static String menu;
    private static Scanner scan;
    private static Train train;

    public static void main(String[] args) {
        trainMenu();
        
    }

    public static void trainMenu(){
        menu = "\nTrain Depot Menu Options\n\n"+
        "Enter A to ATTACH a train car\n"+
        "Enter R to DETACH car at factory\n"+
        "Enter D to DISPLAY all the train cars\n"+
        "Enter S to SEARCH a train car\n"+
        "Enter M to MERGE two train cars\n"+
        "Enter Q to QUIT\n";

        try { 
        train = new Train("car.txt");
        scan = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println(menu);
            System.out.print("Please enter your choice: ");
            String choice = scan.nextLine().toUpperCase();

            switch(choice){
                case "A":
                    createCar();
                    break;
                case "R":
                    delete();
                    break;
                case "D":
                    train.displayTrainCars();
                    break;
                case "S":
                    search();
                    break;
                case "M":
                    merge();
                    break;
                case "Q":
                    running = false;
                    break;
                default:
                    throw new InputMismatchException("INCORRECT INPUT");
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("AHHHH");
    }
        System.out.println("GOOD BYE!!!");
    }
    public static void merge(){
        System.out.println("\nDisplaying existing cars\n");
        train.displayTrainCars();
        System.out.println("\nDisplaying the new cars\n");
        train.merge("update.txt");
    }
    public static void search(){
        System.out.println("\nEnter the Factor name you want to search: ");
        String factName = scan.nextLine();
        System.out.println();
        train.search(factName);
    }
    public static void delete(){
        System.out.println("\nPlease enter the Factory name you wish to Detach: ");
        String name = scan.nextLine();
        System.out.println();
        train.detach(name);
    }
    public static void createCar(){
        String factory,stop, material;
        int stopNum;

        System.out.println("\nPlease enter the factory name:");
        factory = scan.nextLine();
        System.out.println("\nPlease enter the Stop Number:");
        stop = scan.next();
        stopNum =Integer.parseInt(stop);  
        System.out.println("\nPlease enter the Material Name:");
        material = scan.nextLine();
        material = scan.nextLine();
        
        System.out.println("\nAdding a new car - "+factory+" "+stopNum+" "+material+"\n");
        train.attach(factory, stopNum, material);
    }
}
