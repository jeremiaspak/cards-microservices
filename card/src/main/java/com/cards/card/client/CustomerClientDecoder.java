package com.cards.card.client;

import com.cards.card.exception.CustomerNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerClientDecoder implements ErrorDecoder {

  private ErrorDecoder errorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {
    if (response.status() == 404) {
      return new CustomerNotFoundException();
    }

    return errorDecoder.decode(s, response);
  }
}
