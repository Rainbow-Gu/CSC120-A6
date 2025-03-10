/**
 * The Engine class represent the locomotive engine, storing information about its fuel type, level, etc.
 * It Implements the interface EngineRequirements
 */
public class Engine implements EngineRequirements {
    
    /**
     * Attributes
     */
    private FuelType fuel;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /** 
     * Constructor 
     */
    public Engine(FuelType fuel, double currentFuelLevel, double maxFuelLevel) {
        this.fuel = fuel;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }
    
    /**
     * Getter for fuel type
     */
    public FuelType getFuelType() {
        return fuel;
    }

    /** 
     * Getter for current fuel level 
     */
    public double getCurrentFuel() {
        return currentFuelLevel;
    }

    /** 
     * Getter for max fuel level 
     */
    public double getMaxFuel() {
        return maxFuelLevel;
    }

    /** 
     * Reset the Engine's current fuel level to the maximum
    */
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }

    /**
     * Decrease the current fuel level as train goes forward
     * Print information of fuel status
     * @return True if the fuel level is above 0 and False otherwise.
     */
    public Boolean go() { 
        if (currentFuelLevel > 0) {
            currentFuelLevel -= 2;
            System.out.println("Remaining Fuel Level: " + currentFuelLevel + ".");
            return true;
        } else {
            System.out.println("Out of fuel, please refuel.");
            return false;
        }

    }

    /**
     * Test Engine class using main
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 10.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}
