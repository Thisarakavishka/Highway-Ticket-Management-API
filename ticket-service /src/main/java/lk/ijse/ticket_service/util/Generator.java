package lk.ijse.ticket_service.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Generator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
