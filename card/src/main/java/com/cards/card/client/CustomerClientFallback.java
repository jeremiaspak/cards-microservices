package com.cards.card.client;

import com.cards.card.dto.GetCustomerResponse;
import com.cards.card.exception.CustomerServiceDownException;

public class CustomerClientFallback implements CustomerClient {

  @Override
  public GetCustomerResponse getById(Long id) {
    throw new CustomerServiceDownException();
  }
}
