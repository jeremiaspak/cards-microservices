package com.cards.payment.client;

import com.cards.payment.dto.GetCardInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CARD", configuration = CardClientConfiguration.class)
public interface CardClient {

  @GetMapping("/cartao/{id}/info")
  GetCardInfoResponse getInfoById(@PathVariable Long id);
}
