package lk.ijse.vehicle_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    @Pattern(regexp = "^[a-zA-Z]{3,5}\\d{4}$", message = "Invalid vehicle Id. Should start with 3-5 letters followed by 4 digits.")
    private String vehicleId;
    private String vehicleOwnerName;
    @Pattern(regexp = "^(?:\\d{9}v|\\d{1,12})$", message = "Invalid format. Should contain either exactly 9 digits followed by 'v' or up to 12 digits.")
    private String vehicleOwnerNic;
}
