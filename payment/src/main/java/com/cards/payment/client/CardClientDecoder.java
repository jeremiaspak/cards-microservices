package com.cards.payment.client;

import com.cards.payment.exception.CardNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CardClientDecoder implements ErrorDecoder {

  private ErrorDecoder errorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {
    if (response.status() == 404) {
      return new CardNotFoundException();
    }

    return errorDecoder.decode(s, response);
  }
}
