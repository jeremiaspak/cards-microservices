package com.cards.card.mapper;

import com.cards.card.dto.*;
import com.cards.card.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
  CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

  GetCardResponse cardToGetCardReponse(Card card);
  GetCardInfoResponse cardToGetCardInfoResponse(Card card);
  Iterable<GetCardResponse> cardToGetCardReponse(Iterable<Card> cards);

  Card createCardRequestToCard(CreateCardRequest cardRequest);
  CreateCardResponse cardToCreateCardResponse(Card card);

  UpdateCardActiveResponse cardToUpdateCardActiveResponse (Card card);
}
