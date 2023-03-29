import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Directory {

    public String names;
    public String number;
    public HashMap<String, String> directory = new HashMap<String, String>();

    /**
     * Constructor: reads names and numbers from the file into the
     * called directory.
     * @param names
     * @throws FileNotFoundException
     */
    public Directory(String names) throws FileNotFoundException{
        Scanner input = new Scanner(new File("names.txt"));

        while (input.hasNext()){
            names = input.next();
            number = input.next();
            directory.put(names, number);
        }
    }
    /**
     * Looks up given name and gets their phone number.
     * @param name
     * @return
     */
    public String getPhoneNumber(String name){
        if(directory.containsValue(name)){
            return "YESYES";
        } else {
            return "NONO";
        }
    }
    /**
     * Removes a directory entry.
     * @param name
     */
    public void delete(String name){
        directory.remove(name);
    }
    /**
     * Adds a persons name and number.
     * @param name
     * @param number
     */
    public void add(String name, String number){
        this.names = name;
        this.number = number;
        directory.put(name, number);
        System.out.println("Adding: "+ name +" "+ number);
    }
    /**
     * Changes the person's number.
     * @param name
     * @param number
     */
    public void change(String name, String number){
        this.names = name;
        this.number = number;
        directory.put(name, number);
        System.out.println("Changing: "+ name +" "+ number);
    }
    public HashMap<String, String> displayDirectory(){
        return directory;
    }
}