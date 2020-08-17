package com.cards.card.client;

import com.cards.card.dto.GetCustomerResponse;
import com.cards.card.exception.CustomerServiceDownException;
import com.netflix.client.ClientException;

public class CustomerClienLoadBalancerFallback implements CustomerClient {

  private Exception exception;

  public CustomerClienLoadBalancerFallback(Exception exception) {
    this.exception = exception;
  }

  @Override
  public GetCustomerResponse getById(Long id) {
    if (exception.getCause() instanceof ClientException) {
      throw new CustomerServiceDownException();
    }

    throw (RuntimeException) exception;
  }
}
