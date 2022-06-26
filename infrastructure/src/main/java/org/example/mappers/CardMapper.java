package org.example.mappers;

import org.example.entity.Card;
import org.exemple.data.CardDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CardMapper {

	CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

	CardDto cardToCardDto(Card card);

	Card cardDtoToCard(CardDto cardDto);

	List<CardDto> cardListToCardDtoList(List<Card> cardList);

	List<Card> cardDtoListToCardList(List<CardDto> cardDtoList);
}
