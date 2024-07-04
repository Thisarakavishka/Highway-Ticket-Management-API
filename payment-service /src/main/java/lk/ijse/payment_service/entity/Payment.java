package lk.ijse.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String paymentId;
    private Date date;
    @NotNull
    private String ticketId;
    @NotNull
    private String userId;
    @NotNull
    private String vehicleId;
}
