package com.cards.payment.client;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class CardClientConfiguration {

  @Autowired
  private OAuth2ClientContext clientContext;

  @Autowired
  private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

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

  @Bean
  public RequestInterceptor oAuth2FeignRequestInterceptor() {
    return new OAuth2FeignRequestInterceptor(clientContext, clientCredentialsResourceDetails);
  }
}
