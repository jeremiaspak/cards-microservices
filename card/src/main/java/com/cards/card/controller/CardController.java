package com.cards.card.controller;

import com.cards.card.dto.*;
import com.cards.card.entity.Card;
import com.cards.card.mapper.CardMapper;
import com.cards.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CardController {

  @Autowired
  private CardService cardService;

  @GetMapping
  public Iterable<GetCardResponse> findAll() {
    return CardMapper.INSTANCE.cardToGetCardReponse(cardService.findAll());
  }

  @GetMapping("/{number}")
  public GetCardResponse getByNumber(@PathVariable String number) {
    return CardMapper.INSTANCE.cardToGetCardReponse(cardService.getByNumber(number));
  }

  @GetMapping("/{id}/info")
  public GetCardInfoResponse getInfoById(@PathVariable Long id) {
    return CardMapper.INSTANCE.cardToGetCardInfoResponse(cardService.getById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateCardResponse create(@Valid @RequestBody CreateCardRequest cardRequest) {
    Card card = cardService.create(
      CardMapper.INSTANCE.createCardRequestToCard(cardRequest)
    );
    return CardMapper.INSTANCE.cardToCreateCardResponse(card);
  }

  @PatchMapping("/{number}")
  public UpdateCardActiveResponse patchActive(
    @PathVariable String number,
    @Valid @RequestBody UpdateCardActiveRequest cardActiveRequest
  ) {
    return CardMapper.INSTANCE.cardToUpdateCardActiveResponse(
      cardService.updateActive(number, cardActiveRequest.getActive())
    );
  }
}
