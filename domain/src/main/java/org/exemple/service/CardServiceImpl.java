package org.exemple.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.exemple.data.CardDto;
import org.exemple.ports.api.CardServicePort;
import org.exemple.ports.spi.CardPersistencePort;

public class CardServiceImpl implements CardServicePort {

	private CardPersistencePort cardPersistencePort;

	private List<CardDto> cardStorage = new ArrayList<>();

	private final Random randomizer = new Random();

	public CardServiceImpl(CardPersistencePort cardPersistencePort) {
		this.cardPersistencePort = cardPersistencePort;
	}

	@Override
	public void reload() {
		cardStorage = cardPersistencePort.getCards();
	}

	@Override
	public CardDto dealOneCard() {
		if (cardStorage.isEmpty()) {
			return new CardDto();
		}
		return cardStorage.remove(0);
	}

	@Override
	public void shuffle() {

		List<CardDto> randomList = new ArrayList<>();
		if (cardStorage.isEmpty()) {
			reload();
		}
		while (cardStorage.iterator().hasNext()) {
			randomList.add(cardStorage.remove(randomizer.nextInt(cardStorage.size())));
		}
		cardStorage = randomList;
	}

}
