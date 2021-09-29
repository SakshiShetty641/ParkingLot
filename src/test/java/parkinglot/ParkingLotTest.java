package parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue(){
        ParkingLotSystem parkinglotsystem = new ParkingLotSystem();
        boolean isParked = parkinglotsystem.park(new Object());
        Assertions.assertTrue(isParked);
    }
}
