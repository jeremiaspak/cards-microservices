package com.cards.payment.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

  @Bean
  public ErrorDecoder getCustomerErrorDecoder() {
    return new CardClientDecoder();
  }
}
