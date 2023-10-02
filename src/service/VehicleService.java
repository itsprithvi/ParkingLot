package service;

import models.Vehicle;
import models.VehicleType;
import repository.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle registerVehicle(String number, VehicleType type) {
        return vehicleRepository.addVehicle(new Vehicle(number, type));
    }

    public Vehicle getVehicle(String number) {
        return vehicleRepository.getVehicle(number);
    }
}
