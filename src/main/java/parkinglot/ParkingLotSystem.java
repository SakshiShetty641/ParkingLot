package parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Purpose - To simulate a Parking Lot System
 * @author - Sakshi Shetty
 * @version - 8.0
 * @since - 2021-09-29
 */
public class ParkingLotSystem {

    private int actualCapacity;
    private final List vehicles;
    private List<ParkingLotObserver> observers;
    private Object vehicle;
    private int[] parkingSlots;

    public ParkingLotSystem(int capacity) {
        this.parkingSlots = new int[100];
        Arrays.fill(parkingSlots, 0);
        this.observers = new ArrayList<>();
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public int getAvailableParkingSlots() throws ParkingLotException {
        for (int parkingSlot : parkingSlots) {
            if (parkingSlot == 0) {
                return parkingSlot;
            }
        }
        throw new ParkingLotException("Parking Lot is Full");
    }


    public void registerParkingLotObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle Already Parked");
        if (this.vehicles.size() == this.actualCapacity) {
            for (ParkingLotObserver observer: observers){
                observer.capacityIsFull();
            }
            throw new ParkingLotException("Parking Lot is Full");
        }
        this.vehicles.add(vehicle);
    }

    public boolean isVehicleParked(Object vehicle) {
        return this.vehicles.contains(vehicle);

    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null) return false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            for (ParkingLotObserver observer: observers){
                observer.capacityIsAvailable();
            }
            return true;
        }
        return false;
    }

    public boolean isUnParked() {
        return this.vehicle == null;
    }

    public boolean isParkingLotFull() {
        return this.vehicles.size() == this.actualCapacity;
    }
}

