package lk.ijse.payment_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String paymentId;
    private Date date;
    @NotNull(message = "Ticket ID cannot be null")
    private String ticketId;
    @NotNull(message = "User ID cannot be null")
    private String userId;
    @NotNull(message = "Vehicle ID cannot be null")
    private String vehicleId;
}
