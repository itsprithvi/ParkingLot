package service;

import repository.TicketRepository;
import models.*;
import strategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSpotService parkingSpotService;
    private TicketRepository ticketRepository;

    private ParkingLotService parkingLotService;

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) {
        /*
        * 1. Get the Vehicle from DB using vehicleNumber
        * 2. If Vehicle is not found, register vehicle
        * 3. Assign Parking spot
        * 4. Update parking spot as occupied
        * 5. Generate Ticket
        * */

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null) {
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateId);

        ParkingSpot parkingSpot = parkingLotService.getParkingLot(vehicle, gate);

        // Update the parking spot
        parkingSpot = parkingSpotService.assignParkingSpot(parkingSpot);

        Ticket ticket = new Ticket();

        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setOperator(ticket.getOperator());
        ticket.setEntryTime(new Date());

        ticketRepository.save(ticket);

        return ticket;
    }
}
