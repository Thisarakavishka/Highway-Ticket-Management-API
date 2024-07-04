package lk.ijse.payment_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lk.ijse.payment_service.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {
    private String ticketId;
    @NotNull(message = "Date cannot be null")
    private Date travelDate;
    @Positive(message = "Price must be positive")
    private double ticketPrice;
    @NotNull(message = "Departure location cannot be null")
    private String departureLocation;
    @NotNull(message = "Arrival location cannot be null")
    private String arrivalLocation;
    private Status ticketStatus;
    @NotNull(message = "Vehicle ID cannot be null")
    private String assignedVehicleId;
    @NotNull(message = "User ID cannot be null")
    private String bookingUserId;
}
