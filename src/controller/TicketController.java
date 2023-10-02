package controller;

import dto.GenerateTicketRequestDto;
import dto.GenerateTicketResponseDto;
import models.Ticket;
import service.TicketService;


public class TicketController {

    private TicketService ticketService;

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {


        Ticket ticket = ticketService.generateTicket(
                generateTicketRequestDto.getVehicleNumber(),
                generateTicketRequestDto.getVehicleType(),
                generateTicketRequestDto.getGateId()
        );

    }
}
