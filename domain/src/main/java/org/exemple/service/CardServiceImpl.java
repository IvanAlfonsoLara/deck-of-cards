package org.exemple.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.exemple.data.CardDto;
import org.exemple.ports.api.CardServicePort;
import org.exemple.ports.spi.CardPersistencePort;

public class CardServiceImpl implements CardServicePort {

	private CardPersistencePort cardPersistencePort;

	private List<CardDto> cardStorage = new ArrayList<>();

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
			return null;
		}
		return cardStorage.remove(0);
	}

	@Override
	public void shuffle() {
		Random randomizer;
		List<CardDto> randomList = new ArrayList<>();
		if (cardStorage.isEmpty()) {
			reload();
		}
		try {
			randomizer = SecureRandom.getInstanceStrong();
			while (cardStorage.iterator().hasNext()) {
				randomList.add(cardStorage.remove(randomizer.nextInt(cardStorage.size())));
			}
		} catch (NoSuchAlgorithmException e) {
			
		}
		
		cardStorage = randomList;
	}

}
