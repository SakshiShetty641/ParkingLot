package parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem(1);
    }

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
        try {
            parkingLotSystem.park(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenAVehicle_whenParkedAtEmptyParkingSlot_shouldReturnTrue() {
        try {
            parkingLotSystem.park(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        parkingLotSystem.unPark(vehicle);
        boolean isUnParked = parkingLotSystem.isUnParked();
        Assertions.assertTrue(isUnParked);
    }


    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        try {
            parkingLotSystem.park(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Vehicle is already Parked", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenParkedAnotherVehicle_ShouldReturnFalse() {
        Object anotherVehicle = new Object();
        try {
            parkingLotSystem.park(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(anotherVehicle);
            Assertions.assertFalse(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parkingLotWhenChecked_IfFull_thenReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isFull = parkingLotSystem.isParkingLotFull();
        Assertions.assertTrue(isFull);
    }

    @Test
    public void parkingLotWhenChecked_IfNotFull_thenReturnFalse() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        parkingLotSystem.unPark(vehicle);
        boolean isEmpty = parkingLotSystem.isParkingLotFull();
        Assertions.assertFalse(isEmpty);
    }

    @Test
    public void parkingLotWhenFull_ShouldRedirectToAirportStaff() throws ParkingLotException {
        try {
            parkingLotSystem.park(vehicle);
            if (parkingLotSystem.isParkingLotFull()) {
                throw new ParkingLotSignal("The Parking Lot is Full");
            }
        } catch (ParkingLotSignal e) {
            Assertions.assertEquals("The Parking Lot is Full", e.getMessage());
        }
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerParkingLotObserver(owner);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            e.printStackTrace();
            boolean capacityFull = owner.isCapacityFull();
            Assertions.assertTrue(capacityFull);
        }
    }

    @Test
    public void givenCapacityIs2_ShouldBeAbleToPark2Vehicles() {
        Object vehicle2 = new Object();
        parkingLotSystem.setCapacity(2);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(vehicle2);
            boolean isParked1 = parkingLotSystem.isVehicleParked(vehicle2);
            boolean isParked2 = parkingLotSystem.isVehicleParked(vehicle2);
            Assertions.assertTrue(isParked1 && isParked2);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenWhenParkingLotIsFull_ShouldInformTheSecurity() {
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotSystem.registerParkingLotObserver(airportSecurity);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            boolean capacityFull = airportSecurity.isCapacityFull();
            Assertions.assertTrue(capacityFull);
        }
    }

    @Test
    public void givenWhenParkingLotSpaceIsAvailableAfterFull_ShouldReturnTrue() throws ParkingLotException {
        Object vehicle2 = new Object();
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerParkingLotObserver(owner);
        try {
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(vehicle2);
        } catch (ParkingLotException e) {
            parkingLotSystem.unPark(vehicle);
            boolean capacityFull = owner.isCapacityFull();
            Assertions.assertFalse(capacityFull);
        }
    }
}