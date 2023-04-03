import java.io.FileNotFoundException;
import java.util.*;

public class Train {
    public Train(String carFile) throws FileNotFoundException {
        /* constructor: reads each train car details
        from the file into the LinkedList */

    }
    public void detach(String factoryName){
        /* remove a car given FactoryName, this
        should delete the node in the LinkedList
         */

    }
    public void attach(String factoryName, int stopNumber, String materialName){
        // add a new car(node) to the LinkedList

    }
    public void search(String factoryName){
        /* search for cars that correspond the given
         * factory name. Not there may be more than
         * one car so you may use helper method that
         * follows
         */
    }
    public List<String> getCars(String factoryName){
        //material name lookup given factory name
    }
    public void displayTrainCars(){
        //display all the train cars in sorted order
    }
    public void merge(String update){
        /* reads from update.txt and merges it with 
         * the new train car. Merge two LinkedLists
         * and should maintain the sorted order
         */
    }
}
