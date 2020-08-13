package com.cards.payment.mapper;

import com.cards.payment.dto.CreatePaymentRequest;
import com.cards.payment.dto.CreatePaymentResponse;
import com.cards.payment.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapperCustom {

  public Payment createPaymentRequestToPayment(CreatePaymentRequest createPaymentRequest) {
    Payment payment = new Payment();
    payment.setCardId(createPaymentRequest.getCardId());
    payment.setValue(createPaymentRequest.getValue());
    payment.setDescription(createPaymentRequest.getDescription());
    return payment;
  }

  public CreatePaymentResponse paymentToCreatePaymentResponse(Payment payment) {
    CreatePaymentResponse paymentResponse = new CreatePaymentResponse();
    paymentResponse.setCardId(payment.getCardId());
    paymentResponse.setId(payment.getId());
    paymentResponse.setValue(payment.getValue());
    paymentResponse.setDescription(payment.getDescription());
    return  paymentResponse;
  }
}
