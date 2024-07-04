package lk.ijse.ticket_service.util;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Convertor {

    private final ModelMapper modelMapper;
    private final Generator generator;

    public TicketDTO toTicketDTO(Ticket ticket) {
        return modelMapper.map(ticket, TicketDTO.class);
    }

    public Ticket toTicket(TicketDTO ticketDTO) {
        ticketDTO.setTicketId(generator.generate());
        return modelMapper.map(ticketDTO, Ticket.class);
    }
}
