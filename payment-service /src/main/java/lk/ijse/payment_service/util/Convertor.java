package lk.ijse.payment_service.util;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Convertor {

    private final ModelMapper modelMapper;
    private final Generator generator;

    public PaymentDTO toPaymentDTO(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public Payment toPayment(PaymentDTO paymentDTO) {
        paymentDTO.setPaymentId(generator.generate());
        return modelMapper.map(paymentDTO, Payment.class);
    }
}
