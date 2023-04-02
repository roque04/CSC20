import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.*;

public class Directory {

    public String names; //Person's name
    public String numbers; //Person's number
    public static HashMap<String, String> directory = new HashMap<String, String>();

    /**
     * Constructor: reads names and numbers from the file into the
     * called directory.
     * @param names String of a person's name
     * @throws FileNotFoundException
     */
    public Directory(String names) throws FileNotFoundException{
        Scanner input = new Scanner(new File("names.txt"));

        while (input.hasNext()){
            
            String inline = input.nextLine();
            String tokens[] = inline.split(":");

            directory.put(tokens[0], tokens[1]);
        }
    }
    /**
     * Looks up given name and gets their phone number.
     * @param name String of a person's name
     * @return Return a person's number
     */
    public String getPhoneNumber(String name){
        if(directory.containsKey(name)){
            return numbers;
        } else {
           return "";
        }
    }
    /**
     * Removes a directory entry.
     * @param name String of a person's name
     */
    public void delete(String name){
        directory.remove(name);
        System.out.println(name+ " REMOVED");
    }
    /**
     * Adds a persons name and number.
     * @param name String of a person's name to be added
     * @param number String of a person's phone number to be added
     */
    public void add(String name, String number){
        this.names = name;
        this.numbers = number;
        directory.put(name, number);
        System.out.println("Adding: "+ name +" "+ number);
    }
    /**
     * Changes the person's number.
     * @param name String of a person's name
     * @param number String of a person's phone number
     */
    public void change(String name, String number){
        this.names = name;
        this.numbers = number;
        directory.replace(name, directory.get(name), number);
        System.out.println("Changing: "+ name +" "+ number);
    }
    public void displayDirectory(){
        directory.forEach((name, number) -> {
            System.out.println(name+"\t\t"+number);
        });
    }
}