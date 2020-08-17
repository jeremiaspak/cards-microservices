package com.cards.payment.client;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

  @Bean
  public ErrorDecoder getCustomerErrorDecoder() {
    return new CardClientDecoder();
  }

  @Bean
  public Feign.Builder builder() {
    FeignDecorators decorators = FeignDecorators.builder()
      .withFallback(new CardClientFallback(), RetryableException.class)
      .withFallbackFactory(CardClientLoadBalancerFallback::new, RuntimeException.class)
      .build();

    return Resilience4jFeign.builder(decorators);
  }
}
