package com.cards.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateCardRequest {

  @NotNull
  @Min(value = 1)
  @JsonProperty("clienteId")
  private Long customerId;

  @NotBlank
  @JsonProperty("numero")
  private String number;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
