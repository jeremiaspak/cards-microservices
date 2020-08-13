package com.cards.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreatePaymentRequest {

  @NotBlank
  @JsonProperty("descricao")
  private String description;

  @NotNull
  @JsonProperty("valor")
  private BigDecimal value;

  @NotNull
  @Min(value = 1)
  @JsonProperty("cartao_id")
  private Long cardId;

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
