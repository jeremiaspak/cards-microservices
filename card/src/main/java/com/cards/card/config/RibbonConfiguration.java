package com.cards.card.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

  @Bean
  public IRule getRule() {
    return new WeightedResponseTimeRule();
  }
}
