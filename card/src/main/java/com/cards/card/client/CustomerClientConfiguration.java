package com.cards.card.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

  @Bean
  public ErrorDecoder getCustomerErrorDecoder() {
    return new CustomerClientDecoder();
  }
}
