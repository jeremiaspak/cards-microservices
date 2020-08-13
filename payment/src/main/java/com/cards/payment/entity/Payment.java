package com.cards.payment.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String description;

  @Column
  private BigDecimal value;

  @Column
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
