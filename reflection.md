Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?

- I think that it will be a method to systematically check whether the methods in my programming are working or not. I see it a better way to test than me trying repeatedly to run the code.

What worked, what didn't, what advice would you give someone taking this course in the future?

- The `testPassengerBoardCarWithSpace()` and `testTrainPrintManifest()` are two of the ones that I struggled a bit on as they don't simple produce a value to check equality on. Forexample, `assertNotNull()` won't work for `testPassengerBoardCarWithSpace()` because boardCar() doesn't return anything but only a printed string. I think for other tests, it's important to understand what your test should serve and choose the matching assertion to make.

Tests

- `testEngineConstructor()`: Test if Engine Constructor correctly initialize values of `FuelType`, `currentFuelLevel`, and `maxFuelLevel`
- `testEngineGo()`: Test if the go() method reduces the fuel level by checking it's below `maxFuelLevel` and result reduces `currentFuelLevel` by the assigned 2
- `testCarAddPassenger()`: Test to see that adding a Passenger decreases available seats by one
- `testCarRemovePassenger()`: Test to check that removing a Passenger decreases the count and doesn't go negative when removing unexist passenger
- `testPassengerBoardCarWithSpace()`: Test that a Passenger can successfully board a Car by decreasing count of remaining seat
- `testPassengerBoardCarFull()`: Test to ensure that a Passenger cannot board a full Car, and if they tried to, would throw exception
- `testTrainConstructor()`: Test to verify that a Train initializes correctly with a given number of Cars by checking that cars at valid indices (0, 1, 2) are not null and that accessing an invalid index 3 correctly throws exception
- `testTrainPassengerCount()`: Test to ensure the Train’s total Passenger count updates as Passengers board and leave (e.g. adding one passenger means there are 3(# cars) * 4(# seats/car) -1 = 11 seats remaining).
- `testTrainGetCar()`: Test to check that the getCar(int i) method returns the expected Car by checking cars and valid and that their properties are the same after adding a Passenger to that car at index 0
- `testTrainPrintManifest()`***||-- FILL THIS BLANK --||***