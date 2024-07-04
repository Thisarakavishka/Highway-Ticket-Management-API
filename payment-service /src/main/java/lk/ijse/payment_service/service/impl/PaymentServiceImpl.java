package lk.ijse.payment_service.service.impl;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.dto.TicketDTO;
import lk.ijse.payment_service.dto.VehicleDTO;
import lk.ijse.payment_service.entity.Payment;
import lk.ijse.payment_service.entity.enums.Status;
import lk.ijse.payment_service.exception.InvalidateException;
import lk.ijse.payment_service.repository.PaymentRepository;
import lk.ijse.payment_service.service.PaymentService;
import lk.ijse.payment_service.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final Convertor convertor;
    private final PaymentRepository paymentRepository;
    private final RestTemplate restTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addPayment(PaymentDTO paymentDTO) {
        try {
            VehicleDTO vehicleDTO = restTemplate.getForObject("http://vehicle-service/system/api/v1/vehicle/" + paymentDTO.getVehicleId(), VehicleDTO.class);
            TicketDTO ticketDTO = restTemplate.getForObject("http://ticket-service/system/api/v1/ticket/" + paymentDTO.getTicketId(), TicketDTO.class);

            if (ticketDTO.getTicketStatus().equals(Status.PENDING) && vehicleDTO != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "application/json");
                HttpEntity<TicketDTO> entity = new HttpEntity<>(ticketDTO, headers);
                ResponseEntity<TicketDTO> responseEntity = restTemplate.exchange("http://ticket-service/system/api/v1/ticket/" + ticketDTO.getTicketId(), HttpMethod.PUT, entity, TicketDTO.class);

                if (responseEntity.getBody() != null) {
                    Payment payment = convertor.toPayment(paymentDTO);
                    paymentRepository.save(payment);
                    return true;
                }
            }
            throw new InvalidateException("Invalid ticket data inner class");
        } catch (Exception e) {
            throw new InvalidateException("Invalid ticket data");
        }
    }
}
