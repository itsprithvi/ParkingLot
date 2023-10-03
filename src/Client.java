import controller.TicketController;
import dto.GenerateTicketRequestDto;
import dto.GenerateTicketResponseDto;
import models.Vehicle;
import models.VehicleType;
import repository.TicketRepository;
import repository.VehicleRepository;
import service.TicketService;

import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Client {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to the parking system");
        Scanner sc = new Scanner(System.in);

//        GenerateTicketRequestDto generateTicketRequestDto =
//                new GenerateTicketRequestDto();
//
//        TicketController ticketController = new TicketController();
//        ticketController.generateTicket(generateTicketRequestDto);

        final VehicleRepository vehicleRepository = new VehicleRepository();

        ObjectContainer objectContainer = new ObjectContainer();

        TicketService ticketService = new TicketService();
        objectContainer.register("ticketRepository", ticketService);

        TicketController ticketController = new TicketController((TicketService) objectContainer.get("ticketRepository"));

        System.out.println("Enter the Gate ID");
        Long gateId = sc.nextLong();

        System.out.println("Enter the Vehicle number ");
        String vehicleNumber = sc.next();

        System.out.println("Enter the vehicle type \n 1.Large 2.Medium 3.Small 4.Electric");
        int vehicleType = sc.nextInt();

        // TODO: check if vehicle is already present in our database or not
        Vehicle vehicle = new Vehicle(vehicleNumber, VehicleType.SMALL);
        if(vehicleRepository.getVehicle(vehicleNumber) == null) {
            vehicleRepository.addVehicle(vehicle);
        }

        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto(gateId, vehicleNumber, VehicleType.SMALL);

        GenerateTicketResponseDto generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto);

        System.out.println(generateTicketResponseDto.getStatus().toString());


    }
}