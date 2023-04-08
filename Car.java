/**
 * 
 */
public class Car {
    public String factory;
    public int stop;
    public String material;
    Car next;

/**
 * 
 */
    public Car(){
        //default constructor
        factory = "";
        stop = 0;
        material = "";
    }

    /**
     * 
     * @param fact
     * @param s
     * @param m
     */
    public Car(String fact, int s, String m){
        //regular constructor sets next to null
        this.factory = fact;
        this.stop = s;
        this.material = m;
        next = null;

    }

    /**
     * 
     * @param fact
     * @param s
     * @param m
     * @param next
     */
    public Car(String fact, int s, String m, Car next){
        //regular constructor sets this.next=next;
        this.factory = fact;
        this.stop = s;
        this.material = m;
        this.next = next;
    }
}
