package com.cards.payment.client;

import com.cards.payment.dto.GetCardInfoResponse;
import com.cards.payment.exception.CardServiceDownException;
import com.netflix.client.ClientException;

public class CardClientLoadBalancerFallback implements CardClient {

  private Exception exception;

  public CardClientLoadBalancerFallback(Exception exception) {
    this.exception = exception;
  }

  @Override
  public GetCardInfoResponse getInfoById(Long id) {
    if (exception.getCause() instanceof ClientException) {
      throw new CardServiceDownException();
    }

    throw (RuntimeException) exception;
  }
}
