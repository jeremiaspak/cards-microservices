package com.cards.card.service;

import com.cards.card.client.CustomerClient;
import com.cards.card.dto.GetCustomerResponse;
import com.cards.card.entity.Card;
import com.cards.card.exception.CardAlreadyExistsException;
import com.cards.card.exception.CardNotFoundException;
import com.cards.card.exception.CustomerNotFoundException;
import com.cards.card.repository.CardRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private CustomerClient customerClient;

  public Iterable<Card> findAll() {
    return cardRepository.findAll();
  }

  public Card getById(Long id) throws CardNotFoundException {
    return cardRepository.findById(id).orElseThrow(CardNotFoundException::new);
  }

  public Card getByNumber(String number) throws CardNotFoundException {
    return cardRepository.findByNumber(number).orElseThrow(CardNotFoundException::new);
  }

  public Card create(Card card) throws CardAlreadyExistsException, CustomerNotFoundException {
    if (cardRepository.findByNumber(card.getNumber()).isPresent()) {
      throw new CardAlreadyExistsException();
    }

    try {
      GetCustomerResponse customerResponse = customerClient.getById(card.getCustomerId());
    } catch (FeignException e) {
      if (e.status() == 404) {
        throw new CustomerNotFoundException();
      }
    }

    card.setActive(false);
    return cardRepository.save(card);
  }

  public Card updateActive(String number, Boolean active) throws CardNotFoundException {
    Card card = getByNumber(number);
    card.setActive(active);
    return cardRepository.save(card);
  }
}
