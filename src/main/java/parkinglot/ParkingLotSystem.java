package parkinglot;

/**
 * Purpose - To simulate a Parking Lot System
 * @author - Sakshi Shetty
 * @version - 8.0
 * @since - 2021-09-29
 */
public class ParkingLotSystem {

    private final int actualCapacity;
    private int currentCapacity;
    private Object vehicle;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.currentCapacity == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("Vehicle is already Parked");
        }
        this.currentCapacity++;
        this.vehicle = vehicle;
    }

    public boolean isVehicleParked(Object vehicle) {
        return this.vehicle.equals(vehicle);
    }

    public void unPark(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null)
            throw new ParkingLotException("There is no Vehicle Parked to Unpark");
        else if (this.vehicle.equals(vehicle))
            this.vehicle = null;
    }

    public boolean isUnParked() {
        return this.vehicle == null;
    }

    public boolean isParkingLotFull() {
        return this.vehicle != null;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }
}

