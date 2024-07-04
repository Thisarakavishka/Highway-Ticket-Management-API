package lk.ijse.ticket_service.controller;

import jakarta.validation.Valid;
import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Ticket is OK";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> createTicket(@Valid @RequestBody TicketDTO ticketDTO) {
        try {
            ticketService.addTicket(ticketDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ticketDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> updateTicket(@Valid @PathVariable("id") String id, @Valid @RequestBody TicketDTO ticketDTO) {
        try {
            ticketDTO.setTicketId(id);
            ticketService.updateTicket(ticketDTO);
            return ResponseEntity.status(HttpStatus.OK).body(ticketDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicket(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
