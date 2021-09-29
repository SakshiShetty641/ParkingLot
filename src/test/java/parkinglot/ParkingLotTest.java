package parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    public void setUp() throws Exception{
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem();
    }

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue(){
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertTrue(isParked);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue(){
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertTrue(isUnParked);
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse(){
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertFalse(isParked);
    }

    @Test
    void givenAVehicle_WhenParkedAnotherVehicle_ShouldReturnFalse() {
        Object anotherVehicle = new Object();
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(anotherVehicle);
        Assertions.assertFalse(isParked);
    }
}
