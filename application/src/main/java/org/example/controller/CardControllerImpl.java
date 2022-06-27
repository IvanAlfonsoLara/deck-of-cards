package org.example.controller;

import org.exemple.data.CardDto;
import org.exemple.ports.api.CardServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardControllerImpl implements CardController {

	@Autowired
	private CardServicePort cardServicePort;

	@Override
	public ResponseEntity<CardDto> dealOneCard() {
		CardDto response = cardServicePort.dealOneCard();
		return response.getId() != null ? new ResponseEntity<>(response, HttpStatus.OK)
				: new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@Override
	public void shuffle() {
		cardServicePort.shuffle();
		ResponseEntity.ok();
	}
}
