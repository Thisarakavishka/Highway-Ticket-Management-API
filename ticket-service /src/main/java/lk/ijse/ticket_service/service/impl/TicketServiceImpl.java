package lk.ijse.ticket_service.service.impl;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.entity.Ticket;
import lk.ijse.ticket_service.exception.NotFoundException;
import lk.ijse.ticket_service.repository.TicketRepository;
import lk.ijse.ticket_service.service.TicketService;
import lk.ijse.ticket_service.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final Convertor convertor;

    @Override
    public boolean addTicket(TicketDTO ticketDTO) {
        ticketRepository.save(convertor.toTicket(ticketDTO));
        return true;
    }

    @Override
    public boolean updateTicket(TicketDTO ticketDTO) {
        if(ticketRepository.existsById(ticketDTO.getTicketId())){
            Ticket ticket = ticketRepository.getReferenceById(ticketDTO.getTicketId());
            ticket.setTicketStatus(ticketDTO.getTicketStatus());
            ticketRepository.save(ticket);
            return true;
        }
        throw new NotFoundException("Ticket not found");
    }

    @Override
    public TicketDTO getTicket(String id) {
        if(ticketRepository.existsById(id)){
            return convertor.toTicketDTO(ticketRepository.getReferenceById(id));
        }
        throw new NotFoundException("Ticket not found");
    }
}
