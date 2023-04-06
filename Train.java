import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Train { 
    private Car front; // start of the train

    public Train() { 
        this.front = null;
    }
    public Train(String carFile) throws FileNotFoundException { /* constructor: reads each train car details from the file into the LinkedList */

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
    public void detach(String factoryName){
        /* remove a car given FactoryName, this should delete the node in the LinkedList */

        if(this.front == null){
            return;
        }

        Car current = this.front, prev = null; // A current car is int, and a prev one aswell

        if(current != null && current.factory.equalsIgnoreCase(factoryName)){ /* if the current car is not null, and the first one happens to be the one the user is searching for */ 

            // the front of the train is set to a new address, which detaches the current front.

            this.front = current.next; // changes the front of the train

            return;
        }
        while(current != null && current.factory != factoryName){
            
            prev = current; // prev car will equal the current car
            
            current = current.next; // current is changed to the next car in the list

        }
        if(current == null && prev == null){ // if the train reaches the end of the list, then the car has been detached

            return;

        }

        prev.next = current.next; // the next prev car is set to equal the current.next car

        detach(factoryName); // runs again until all of the cars with the factory name have been deleted

    }
    public void attach(String factoryName, int stopNumber, String materialName){ /* add a new car(node) to the LinkedList */

        if(this.front == null) { // if the train is empty, the item is added automatically

            this.front = new Car(factoryName, stopNumber, materialName); // a car object is created

        } else {  // if the front is not empty

            Car current = this.front; // a current Car object is declared

            Car i = current.next;

            while( i != null){ // this while loop iterates through each item in the Train List

                current = current.next; // current is changed to the next car in the list

            }

            current.next = new Car(factoryName, stopNumber, materialName); // a car is added to the end of the list
        }
        sort(); // sorts the train

    }
    public void search(String factoryName){
        /* search for cars that correspond the given factory name. Not there may be more than one car so you may use helper method that follows */

         Car current = this.front, index = null;

         //Insert code here//

        if (this.front == null){ // if the front of the list is empty, nothing happens
            
            return;

        } else {

            while(current != null){ //this while loop iterates through the list
                
                index = current.next;
                
                while(index != null){
                    
                    if(current.factory == factoryName){ // if the factory name equals the parameter given factory name, it will be outputted
                        
                        System.out.println(factoryName);
                    }

                }

                current = current.next; // current is changed to the next car in the list
            
            }

        }

    }
    public List<String> getCars(String factoryName){ /* material name lookup given factory name */
        
        List<String> materials = new LinkedList<>(); // a list is created to hold all of the materials

        Car current = this.front; // a currrent car object is delcared

        while(current.next != null){ //this while loop iterates tjrought the list
            if(current.next.factory.equalsIgnoreCase(factoryName)){ 
                //if the factory name equals the parameter given factoryname, it will be outputted

                //Insert code here// //if it is equal the cars materials are added to tje list
            }
            //Insert code here// //current is changed to the next car in the list
        }
        return materials; //the list is then returned
    }

    public void displayTrainCars(){
        //display all the train cars in sorted order
        sort();
        Car current = this.front;

        if(this.front == null){
            System.out.println("\ntrain is empty\n");
            return;
        }
        //insert code here// //while loop//
    }
    public void merge(String update){
        /* reads from update.txt and merges it with 
         * the new train car. Merge two LinkedLists
         * and should maintain the sorted order
         */
        Scanner fileReader = null;
        String[] info = null;
        String displayNew = null;

        try { 
            fileReader = new Scanner(new File(update));
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }

        while(fileReader.hasNextLine()){ //this while loops iterates through the file
            //insert code here//  //the files line is split into the info array
            
            //insert code here//  //the car is then attached to the train
        }
        System.out.println();
        sort();
    }
    public void sort(){
        Car current = this.front, index = null;
        int temp;
        String tempFactory, tempMaterial;

        if (this.front == null){
            return;
        } else {
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.stop>index.stop){
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
                    index=index.next;
                }
                current = current.next;
            }
        }
    }
}
