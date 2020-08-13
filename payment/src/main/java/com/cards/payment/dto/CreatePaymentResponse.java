package com.cards.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreatePaymentResponse {

  private Long id;

  @JsonProperty("descricao")
  private String description;

  @JsonProperty("valor")
  private BigDecimal value;

  @JsonProperty("cartao_id")
  private Long cardId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public Long getCardId() {
    return cardId;
  }

  public void setCardId(Long cardId) {
    this.cardId = cardId;
  }
}
