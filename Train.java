import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Roque Busto
 * date: 4/8/23
 */
public class Train { 
    private Car front; // start of the train

    public Train() { 
        this.front = null;
    }
    /**
     * Initiallizes a constructor for the Train class. It places all the items (train car details) from the file into a LinkedList.
     * @param carFile
     * @throws FileNotFoundException
     */
    public Train(String carFile) throws FileNotFoundException {

        Scanner fileReader = null;
        fileReader = new Scanner(new File(carFile));
        String[] info;
        String line;

        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
            info = line.split(",");
            attach(info[0], Integer.valueOf(info[1]), info[2]);
        }
        fileReader.close();

    }
    /**
     * Removes a car from the LinkedList when it is given a FactoryName.
     * @param factoryName
     */
    public void detach(String factoryName){

        if(this.front == null){
            return;
        }

        Car current = this.front, prev = null; // A current car is intiatted , and a prev one aswell

        if(current != null && current.factory.equalsIgnoreCase(factoryName)){ /* if the current car is not null, and the first one happens to be the one the user is searching for */ 
            // the front of the train is set to a new address, which detaches the current front.
            this.front = current.next; // changes the front of the train
            return;
        }

        while(current != null && current.factory != factoryName){ 
            prev = current; // prev car will equal the current car
            current = current.next; // current is changed to the next car in the list
        }

        if(current == null){ // if the train reaches the end of the list, then the car has been detached
            return;
        }

        prev.next = current.next; // the next prev car is set to equal the current.next car
        detach(factoryName); // runs again until all of the cars with the factory name have been deleted

    }
    /**
     * Adds a new car node to the LinkedList. It needs a factoryName, stopNumber, and materialName to be added.
     * @param factoryName
     * @param stopNumber
     * @param materialName
     */
    public void attach(String factoryName, int stopNumber, String materialName){ /* add a new car(node) to the LinkedList */

        if(this.front == null) { // if the train is empty, the item is added automatically
            this.front = new Car(factoryName, stopNumber, materialName); // a car object is created

        } else {  // if the front is not empty

            Car current = this.front; // a current Car object is declared

            while( current.next != null){ // this while loop iterates through each item in the Train List
                current = current.next; // current is changed to the next car in the list
            }

            current.next = new Car(factoryName, stopNumber, materialName); // a car is added to the end of the list

        }
        sort(); // sorts the train

    }
    /**
     * Searches the LinkedList for the cars that correspond to the given factory name. This also give the cars' details.
     * @param factoryName
     */
    public void search(String factoryName){
        /* search for cars that correspond the given factory name. Not there may be more than one car so you may use helper method that follows */

         Car current = this.front;

        if (this.front == null){ // if the front of the list is empty, nothing happens
            return;

        } else {

            while(current != null){ //this while loop iterates through the list
                    if(current.factory.equalsIgnoreCase(factoryName)){ // if the factory name equals the parameter given factory name, it will be outputted
                        System.out.println(factoryName);
                        System.out.println("The material in the car is "+ current.material.toString()+"\n");
                        break;

                    } else {

                        current = current.next; // current is changed to the next car in the list
                    }
            }
        }
    }
    /**
     * Returns the material's name when it is given a factory name.
     * @param factoryName
     * @return
     */
    public List<String> getCars(String factoryName){
        
        List<String> materials = new LinkedList<>(); // a list is created to hold all of the materials

        Car current = this.front; // a currrent car object is delcared

        while(current.next != null){ // this while loop iterates through the list

            if(current.next.factory.equalsIgnoreCase(factoryName)){ 

                System.out.println(factoryName); // if the factory name equals the parameter given factoryname, it will be outputted
                materials.add(current.material); // if it is equal the cars materials are added to the list
            }
            current = current.next; // current is changed to the next car in the list
        }
        return materials; //the list is then returned

    }
    /**
     * Displays all the train cars in a sorted order of factory name, stop number, and material name.
     */
    public void displayTrainCars(){

        sort();

        Car current = this.front;

        if(this.front == null){
            System.out.println("\nThe train is empty!!!\n");
            return;
        }

        System.out.println();

        while(current != null){
            System.out.printf("%14s %10s %18s %n",  current.factory.toString(), current.stop, current.material.toString());
            current = current.next;
        }
    }
    /**
     * Merges the first LinkedList with a second one. The information is read from another file (in this case it's "update.txt.") and merged
     * to create a single LinkedList. The LinkedList should still be sorted.
     * @param update
     */
    public void merge(String update){
        Scanner fileReader = null;
        String[] info = null;
        String displayNew = null;

        try { 
            fileReader = new Scanner(new File(update));
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }

        while(fileReader.hasNextLine()){ //this while loops iterates through the file
            displayNew = fileReader.nextLine();
            info = displayNew.split(","); //the files line is split into the info array
            attach(info[0], Integer.valueOf(info[1]), info[2]); // the car is then attached to the train
        }
        System.out.println();

        sort();

    }
    /**
 * This method sorts a linked list of Car objects in ascending order of their stop numbers. 
 * If the list is empty, it returns without doing anything.
 */
    public void sort(){
        // Set the current node to the first node in the linked list,
        // and initialize the index node to null.
        Car current = this.front, index = null;
        // Declare variables to hold temporary values during swaps.
        int temp;
        String tempFactory, tempMaterial;

        // Check if the linked list is empty.
        if (this.front == null){
            // If it is, return without doing anything.
            return;
        } else {
            // Otherwise, start sorting the list.
            while(current != null){
                // Set the index node to the node after the current node.
                index = current.next;
                while(index != null){
                    // Compare the stops of the current node and the index node.
                    if(current.stop>index.stop){
                        // If the current node's stop is greater than the index node's stop,
                        // swap their stop numbers, factory names, and material names.
                        temp=current.stop;
                        tempFactory=current.factory;
                        tempMaterial=current.material;

                        current.stop=index.stop;
                        current.factory=index.factory;
                        current.material=index.material;

                        index.stop=temp;
                        index.factory=tempFactory;
                        index.material=tempMaterial;

                    }
                    // Move to the next node in the linked list.
                    index=index.next;
                }
                // Move to the next node in the linked list.
                current = current.next;
            }
        }
    }
}