package parkinglot;

/**
 * Purpose - To simulate a Parking Lot System
 * @author - Sakshi Shetty
 * @version - 8.0
 * @since - 2021-09-29
 */
public class ParkingLotSystem {

    private Object vehicle;

    public boolean park(Object vehicle) {
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public boolean unPark(Object vehicle) {
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
