package com.cards.payment.repository;

import com.cards.payment.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
  Iterable<Payment> findByCardId(Long cardId);
}
