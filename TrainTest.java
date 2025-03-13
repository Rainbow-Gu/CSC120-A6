import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for the Train classes
 */

public class TrainTest {

    /** 
     * Declare Attributes for JUnit test
     */
    private Engine engine;
    private Car car;
    private Passenger passenger;
    private Train train;

    // Engine Tests

    /**
     * Sets up test objects before each test runs
     */
    @Before
    public void setUp() {
        engine = new Engine(FuelType.STEAM, 10, 100);
        train = new Train(FuelType.STEAM, 10, 100, 3,4);
        car = new Car(4); 
        passenger = new Passenger("Alice");
    }

    /**
     * Test if Engine Constructor correctly initialize values
     */
    @Test
    public void testEngineConstructor() {
        assertEquals(FuelType.STEAM, engine.getFuelType());
        assertEquals(10, engine.getCurrentFuel(), 0.01);
        assertEquals(100, engine.getMaxFuel(), 0.01);
    }

    /*
     * Test if the go() method reduces the fuel level correctly
     */
    @Test
    public void testEngineGo() {
        engine.go();
        assertTrue(engine.getCurrentFuel() < 100);
        assertEquals(8, engine.getCurrentFuel(), 0.01);
    }

    // Car Tests

    /**
     * Test to ensure that adding a Passenger decreases seats remaining
     */
    @Test
    public void testCarAddPassenger() {
        car.addPassenger(passenger);
        assertEquals(3, car.seatsRemaining());
    }

    /**
     * Test to check that removing a Passenger decreases the count and doesn't go negative
     */
    @Test
    public void testCarRemovePassenger() {
        car.addPassenger(passenger);
        car.addPassenger(passenger);
        car.removePassenger(passenger);
        assertEquals(3, car.seatsRemaining());
        car.removePassenger(passenger);
        assertFalse(car.removePassenger(passenger));
    }

    // Passenger Tests

    /**
     * Test that a Passenger can successfully board a Car
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
        passenger.boardCar(car);
        assertEquals(3, car.seatsRemaining());
    }

    /**
     * Test to ensure that a Passenger cannot board a full Car
     */
    @Test(expected = RuntimeException.class)
    public void testPassengerBoardCarFull() {
        car.addPassenger(new Passenger("Bob"));
        car.addPassenger(new Passenger("Charlie"));
        car.addPassenger(new Passenger("Dave"));
        car.addPassenger(new Passenger("Eve"));
        passenger.boardCar(car);
    }

    // Train Tests

    /**
     * Test to verify that a Train initializes correctly with a given number of Cars
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testTrainConstructor() {
        assertNotNull(train.getCar(0));
        assertNotNull(train.getCar(1));
        assertNotNull(train.getCar(2));
        train.getCar(3);
    }

    /**
     * Test to ensure the Train’s total Passenger count updates as Passengers board and leave
     */
    @Test
    public void testTrainPassengerCount() {
        train.getCar(0).addPassenger(passenger);
        assertEquals(11, train.seatsRemaining());
        train.getCar(0).removePassenger(passenger);
        assertEquals(12, train.seatsRemaining());
    }

    /**
     * Test to check that the getCar(int i) method returns the expected Car
     */
    @Test
    public void testTrainGetCar() {
        assertNotNull(train.getCar(0));
        train.getCar(0).addPassenger(passenger);
        assertEquals(3, train.getCar(0).seatsRemaining());
    }

    /**
     * Test the printManifest() method to ensure it iterates through the Trains Cars correctly
     * Used: https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
     */
    @Test
    public void testTrainPrintManifest() {
        train.getCar(0).addPassenger(passenger);
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        train.printManifest();
        String expectedOutput = "\nCar 1\nPassenger(s) onboard:\n- Alice\n\nCar 2\nThis car is EMPTY.\n\nCar 3\nThis car is EMPTY.\n";
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(originalOut);

    }
}
