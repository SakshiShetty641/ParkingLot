package parkinglot;

import java.util.ArrayList;
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

    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void registerParkingLotObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            for (ParkingLotObserver observer: observers){
                observer.capacityIsFull();
            }
            throw new ParkingLotException("Parking Lot is Full");
        }
        if (isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle Already Parked");
        this.vehicles.add(vehicle);
    }

    public boolean isVehicleParked(Object vehicle) {
        return this.vehicles.contains(vehicle);

    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null) return false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
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

