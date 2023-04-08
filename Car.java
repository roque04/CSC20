/**
 * @author Roque Busto
 * date: 4/8/23
 */
public class Car {
    public String factory; // factory car name
    public int stop; // the stop number for the car
    public String material; // the material for the car
    Car next; // the next car

/**
 * Default constructor
 */
    public Car(){
    
        factory = "";
        stop = 0;
        material = "";
    }

    /**
     * Regular constructor sets next to null
     * @param fact
     * @param s
     * @param m
     */
    public Car(String fact, int s, String m){
        
        this.factory = fact;
        this.stop = s;
        this.material = m;
        next = null;

    }

    /**
     * Regular constructor sets this.next=next;
     * @param fact
     * @param s
     * @param m
     * @param next
     */
    public Car(String fact, int s, String m, Car next){
        
        this.factory = fact;
        this.stop = s;
        this.material = m;
        this.next = next;
    }
}
