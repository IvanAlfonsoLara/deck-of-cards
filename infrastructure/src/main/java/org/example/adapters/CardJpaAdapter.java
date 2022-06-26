package org.example.adapters;

import java.util.List;

import org.example.entity.Card;
import org.example.mappers.CardMapper;
import org.example.repository.CardRepository;
import org.exemple.data.CardDto;
import org.exemple.ports.spi.CardPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardJpaAdapter implements CardPersistencePort {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<CardDto> getCards() {

        List<Card> cardList = cardRepository.findAll();

        return CardMapper.INSTANCE.cardListToCardDtoList(cardList);
    }
}
