package lk.ijse.payment_service.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Generator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
