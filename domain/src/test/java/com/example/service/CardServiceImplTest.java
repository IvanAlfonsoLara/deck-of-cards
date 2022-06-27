package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.exemple.data.CardDto;
import org.exemple.data.SuitDto;
import org.exemple.data.TypeDto;
import org.exemple.ports.spi.CardPersistencePort;
import org.exemple.service.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class CardServiceImplTest {

	@InjectMocks
	private CardServiceImpl cardService;

	@Mock
	private CardPersistencePort cardPersistencePort;

	@Test
	void dealOneCardEmptyTest() {
		CardDto result = cardService.dealOneCard();
		assertNull(result.getId());
	}

	@Test
	void dealOneCardLoadedTest() {
		Mockito.when(cardPersistencePort.getCards()).thenReturn(mockCardList());
		cardService.reload();
		CardDto result = cardService.dealOneCard();
		assertEquals(1L, result.getId());
	}

	private List<CardDto> mockCardList() {
		List<CardDto> mockListCards = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			CardDto mockCard = new CardDto();
			mockCard.setId(Long.valueOf(i));
			mockCard.setSuit(new SuitDto(Long.valueOf(i), "Diamonds"));
			mockCard.setType(new TypeDto(Long.valueOf(i), String.valueOf(i), "Test"));
			mockListCards.add(mockCard);
		}
		return mockListCards;
	}
}
