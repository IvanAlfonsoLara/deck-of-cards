package org.example.configuration;

import org.example.adapters.CardJpaAdapter;
import org.exemple.ports.api.CardServicePort;
import org.exemple.ports.spi.CardPersistencePort;
import org.exemple.service.CardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardConfig {

	@Bean
	CardPersistencePort cardPersistence() {
		return new CardJpaAdapter();
	}

	@Bean
	CardServicePort cardService() {
		return new CardServiceImpl(cardPersistence());
	}
}
