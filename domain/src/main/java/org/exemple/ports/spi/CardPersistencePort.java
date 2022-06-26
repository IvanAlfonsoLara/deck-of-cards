package org.exemple.ports.spi;

import org.exemple.data.CardDto;

import java.util.List;

public interface CardPersistencePort {

    List<CardDto> getCards();

}
