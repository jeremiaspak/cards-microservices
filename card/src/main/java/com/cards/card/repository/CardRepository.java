package com.cards.card.repository;

import com.cards.card.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Long> {
  Optional<Card> findByNumber(String number);
}
