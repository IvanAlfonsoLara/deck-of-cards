package org.exemple.service;

import org.exemple.data.CardDto;
import org.exemple.ports.api.CardServicePort;
import org.exemple.ports.spi.CardPersistencePort;

import java.util.List;

public class CardServiceImpl implements CardServicePort {

	private CardPersistencePort cardPersistencePort;

	public CardServiceImpl(CardPersistencePort cardPersistencePort) {
		this.cardPersistencePort = cardPersistencePort;
	}

	@Override
	public List<CardDto> getCards() {
		return cardPersistencePort.getCards();
	}

}
