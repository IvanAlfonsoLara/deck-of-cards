package org.exemple.ports.api;

import org.exemple.data.CardDto;

public interface CardServicePort {
	
	void reload();

	CardDto dealOneCard();

	void shuffle();
}
