/** Store information about an individual passenger 
 * It implements the PassengerRequirements interface
 */ 
public class Passenger implements PassengerRequirements {
    
    /**
     * Attribute
     */
    private String name;

    /**
     * Constructor
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Display Passenger class as string for passenger name readability
     */
    public String toString() {
        return name;
    }

    /**
     * Getter for passenger's name
     */
    public String getName() {
        return name;
    }

    /** 
     * Board passenger to a specific car if they can be boarded
     * Call c.addPassenger(this) to board a given Car
     * Prints message of whether aboarded
     * @param c User specified car
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this) == true) {
            System.out.println("Successfully boarded car " + c + ".");
        } else {
            throw new RuntimeException("Car is full, this passenger can not board the car " + c + ".");
        }
    }

    /** 
     * Remove passenger from a specific car if they can be removed
     * Call c.removePassenger(this) to board a given Car
     * Prints message of whether removed
     * @param c User specified car
     */
    public void getOffCar(Car c) {
        if (c.removePassenger(this) == true) {
            System.out.println("Successfully removed passenger from car " + c + ".");
        } else {
            throw new RuntimeException("Passenger cannot leave because they are not in the car " + c + ".");
        }
        
    }

    /**
     * Test Passenger class using main
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Passenger john = new Passenger("John");
        // Passenger mia = new Passenger("Mia");
        Car car = new Car(1);
        System.out.println("\nTest Passenger class");
        john.boardCar(car);
        john.getOffCar(car);
        // John.getOffCar(car); // should run exception
        john.boardCar(car);
        // Mia.boardCar(car); // should run exception
    }
}

