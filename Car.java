public class Car {
    public String factory;
    public int stop;
    public String material;
    Car next;

    public Car(){
        //default constructor
    }
    public Car(String fact, int s, String m){
        //regular constructor sets next to null

    }
    public Car(String fact, int s, String m, Car next){
        //regular constructor sets this.next=next;
        
    }
}
