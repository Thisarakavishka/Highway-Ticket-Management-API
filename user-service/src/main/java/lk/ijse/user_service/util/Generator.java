package lk.ijse.user_service.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Generator {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
