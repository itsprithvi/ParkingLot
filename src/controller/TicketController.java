package controller;

import dto.GenerateTicketRequestDto;
import dto.GenerateTicketResponseDto;
import dto.ResponseStatus;
import exceptions.NoParkingSpotFoundException;
import models.Ticket;
import service.TicketService;


public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {


        try {
            Ticket ticket = ticketService.generateTicket(
                    generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId()
            );

            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setStatus(ResponseStatus.SUCCESS);

            return generateTicketResponseDto;

        } catch (NoParkingSpotFoundException e) {
            System.out.println("Catch block is called...");
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return generateTicketResponseDto;
        } finally {
            System.out.println("No error is found in ticket generation");
        }

    }
}
