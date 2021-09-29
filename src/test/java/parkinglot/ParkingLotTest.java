package parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue(){
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertTrue(isParked);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue(){
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertTrue(isUnParked);
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse(){
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertFalse(isParked);
    }
}
