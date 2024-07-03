package lk.ijse.user_service.dto;

import jakarta.validation.constraints.NotNull;
import lk.ijse.user_service.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String name;
    private String userId;
    private Role role;
}
