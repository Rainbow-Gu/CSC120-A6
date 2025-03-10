import java.util.ArrayList;

/**
 * Assemble Train by tieing Car, Engine, Passenger together 
 * Implements TrainRequirements interface
*/
public class Train implements TrainRequirements {

    /**
     * Attributes
     */ 
    private Engine engine;
    private ArrayList<Car> carsList;
    
    /** 
     * Constructor 
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity); 
        this.carsList = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++) {
            this.carsList.add(new Car(passengerCapacity));
        }

    }
    
    /** 
     * Getter for Engine 
     */
    public Engine getEngine() {
        return engine;
    }
    
    /** 
     * Getter for Car Index 
     */
    public Car getCar(int i) {
        if (i <= carsList.size()) {
            return carsList.get(i);
        } else {
            throw new IndexOutOfBoundsException("Warning, car index " + i + " doesn't exist in this train.");
        }
    }
    
    /**
     * Getter for maximum total capacity across all Cars
     */
    public int getMaxCapacity() {
        int totalCapacity = 0;
        for (Car car : carsList) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }
    
    /** 
     * Return the number of remaining open seats across all Cars
     * @return totalRemaining integer of remaining seats in the car
     */
    public int seatsRemaining() {
        int totalRemaining = 0;
        for (Car car : carsList) {
            totalRemaining += car.seatsRemaining();
        }
        return totalRemaining;
    }
    
    /** 
     * Prints a roster of all Passengers onboard 
     */
    public void printManifest() {
        for (int i = 0; i < carsList.size(); i++) {
            System.out.println("\nCar " + (i+1));
            getCar(i).printManifest();
        }
    }

    /**
     * Test Train class using main
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 12, 24, 4, 3);
        Passenger kaia = new Passenger("Kaia");
        Passenger john = new Passenger("John");
        Passenger mia = new Passenger("Mia"); 
        System.out.println("\nTest Train Class");
        System.out.println("The maximum capacity of the train is " + myTrain.getMaxCapacity() + ".");
        john.boardCar(myTrain.getCar(0));
        // myTrain.getCar(5); // should run exception
        kaia.boardCar(myTrain.getCar(2));
        mia.boardCar(myTrain.getCar(3));
        myTrain.printManifest();
        System.out.println("\n" + myTrain.seatsRemaining() + " seats remains.");
    }
}

