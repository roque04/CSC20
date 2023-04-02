import java.io.FileNotFoundException;
import java.util.*;
public class DirectoryTesting {
    public static void main(String[] args) throws FileNotFoundException{
        Directory phoneDirectory = new Directory("names.txt"); //create the directory
        System.out.println();
        
        phoneDirectory.displayDirectory();
    }
}
