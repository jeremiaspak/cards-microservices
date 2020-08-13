package com.cards.payment.service;

import com.cards.payment.client.CardClient;
import com.cards.payment.dto.GetCardInfoResponse;
import com.cards.payment.entity.Payment;
import com.cards.payment.exception.CardIsNotActiveException;
import com.cards.payment.exception.CardNotFoundException;
import com.cards.payment.exception.PaymentNotFoundException;
import com.cards.payment.repository.PaymentRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  PaymentRepository paymentRepository;

  @Autowired
  CardClient cardClient;

  public Iterable<Payment> findAll() {
    return paymentRepository.findAll();
  }

  public Payment getById(Long id) throws PaymentNotFoundException {
    return paymentRepository.findById(id).orElseThrow(PaymentNotFoundException::new);
  }

  public Iterable<Payment> findByCardId(Long cardId) {
    return paymentRepository.findByCardId(cardId);
  }

  public Payment create(Payment payment) throws CardNotFoundException, CardIsNotActiveException {
    GetCardInfoResponse card = cardClient.getInfoById(payment.getCardId());
    if (!card.getActive()) {
      throw new CardIsNotActiveException();
    }
    return  paymentRepository.save(payment);
  }
}
