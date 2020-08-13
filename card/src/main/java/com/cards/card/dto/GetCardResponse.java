package com.cards.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCardResponse {

  private Long id;

  @JsonProperty("numero")
  private String number;

  @JsonProperty("clienteId")
  private Long customerId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
