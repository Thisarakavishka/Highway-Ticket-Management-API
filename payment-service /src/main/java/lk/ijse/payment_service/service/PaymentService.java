package lk.ijse.payment_service.service;

import lk.ijse.payment_service.dto.PaymentDTO;

public interface PaymentService {

    boolean addPayment(PaymentDTO paymentDTO);
}
