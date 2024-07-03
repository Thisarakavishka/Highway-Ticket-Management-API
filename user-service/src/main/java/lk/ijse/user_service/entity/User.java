package lk.ijse.user_service.entity;

import jakarta.persistence.*;
import lk.ijse.user_service.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    @Id
    private String userId;
    @Enumerated(EnumType.STRING)
    private Role role;
}
