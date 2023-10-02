package service;

import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import repository.ParkingLotRepository;
import strategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLotService {

    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(SpotAssignmentStrategy spotAssignmentStrategy) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public ParkingSpot getParkingLot(Vehicle vehicle, Gate gate) {
        List<ParkingSpot> parkingSpotList = parkingLotRepository.getAllParkingSpots();

        return spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(), gate, parkingSpotList);
    }
}
