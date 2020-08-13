package com.cards.payment.controller;

import com.cards.payment.dto.CreatePaymentRequest;
import com.cards.payment.dto.CreatePaymentResponse;
import com.cards.payment.dto.GetPaymentResponse;
import com.cards.payment.entity.Payment;
import com.cards.payment.mapper.PaymentMapper;
import com.cards.payment.mapper.PaymentMapperCustom;
import com.cards.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pagamento")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private PaymentMapperCustom paymentMapper;

  @GetMapping
  public Iterable<GetPaymentResponse> findAll() {
    return PaymentMapper.INSTANCE.paymentToGetPaymentResponse(paymentService.findAll());
  }

  @GetMapping("/{cardId}")
  public Iterable<GetPaymentResponse> findByCardId(@PathVariable Long cardId) {
    return PaymentMapper.INSTANCE.paymentToGetPaymentResponse(paymentService.findByCardId(cardId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreatePaymentResponse create(@Valid @RequestBody CreatePaymentRequest paymentRequest) {
//    Payment payment = paymentService.create(
//      PaymentMapper.INSTANCE.createPaymentRequestToPayment(paymentRequest)
//    );

//    return PaymentMapper.INSTANCE.paymentToCreatePaymentResponse(payment);

    Payment payment = paymentService.create(
      paymentMapper.createPaymentRequestToPayment(paymentRequest)
    );

    return paymentMapper.paymentToCreatePaymentResponse(payment);
  }
}
