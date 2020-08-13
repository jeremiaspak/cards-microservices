package com.cards.card.client;

import com.cards.card.dto.GetCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER")
public interface CustomerClient {

  @GetMapping("/cliente/{id}")
  GetCustomerResponse getById(@PathVariable Long id);
}
