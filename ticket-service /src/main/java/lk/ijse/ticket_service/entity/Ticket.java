package lk.ijse.ticket_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lk.ijse.ticket_service.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ticket {
    @Id
    private String ticketId;
    private Date travelDate;
    private double ticketPrice;
    private String departureLocation;
    private String arrivalLocation;
    @Enumerated(EnumType.STRING)
    private Status ticketStatus;
    @NotNull
    private String assignedVehicleId;
    @NotNull
    private String bookingUserId;
}
