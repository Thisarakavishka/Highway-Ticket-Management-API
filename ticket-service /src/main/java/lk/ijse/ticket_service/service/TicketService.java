package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.dto.TicketDTO;

public interface TicketService {

    boolean addTicket(TicketDTO ticketDTO);

    boolean updateTicket(TicketDTO ticketDTO);

    TicketDTO getTicket(String id);
}
