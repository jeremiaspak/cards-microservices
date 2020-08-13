package com.cards.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCustomerResponse {

  private Long id;

  @JsonProperty("nome")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
