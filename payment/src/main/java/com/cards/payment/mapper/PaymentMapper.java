package com.cards.payment.mapper;

import com.cards.payment.dto.CreatePaymentRequest;
import com.cards.payment.dto.CreatePaymentResponse;
import com.cards.payment.dto.GetPaymentResponse;
import com.cards.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

  PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

  GetPaymentResponse paymentToGetPaymentResponse(Payment payment);
  Iterable<GetPaymentResponse> paymentToGetPaymentResponse(Iterable<Payment> payments);

  Payment createPaymentRequestToPayment(CreatePaymentRequest createPaymentRequest);
  CreatePaymentResponse paymentToCreatePaymentResponse(Payment payment);
}
