package com.cards.payment.client;

import com.cards.payment.dto.GetCardInfoResponse;
import com.cards.payment.exception.CardServiceDownException;

public class CardClientFallback implements CardClient {

  @Override
  public GetCardInfoResponse getInfoById(Long id) {
    throw new CardServiceDownException();
  }
}
