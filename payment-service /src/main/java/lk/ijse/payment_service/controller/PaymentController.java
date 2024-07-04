package lk.ijse.payment_service.controller;

import jakarta.validation.Valid;
import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Payment is OK";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
        try{
            paymentService.addPayment(paymentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
