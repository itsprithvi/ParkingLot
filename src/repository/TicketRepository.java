package repository;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Long, Ticket> ticketStore;

    public TicketRepository() {
        this.ticketStore = new HashMap<>();
    }

    public void save(Ticket ticket) {
        // TODO: implement save functionality
        ticketStore.put(ticket.getId(), ticket);
    }
}
