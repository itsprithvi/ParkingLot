package repository;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    /*
    We can have Map as DB and use to push/retrieve data
    */

    Map<String, Vehicle> vehicleStore;

    public VehicleRepository() {
        this.vehicleStore = new HashMap<>();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleStore.put(vehicle.getNumber(), vehicle);

        return vehicle;
    }

    public Vehicle getVehicle(String number) {
        return vehicleStore.get(number);
    }
}
