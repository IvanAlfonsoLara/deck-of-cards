package org.example.controller;

import org.exemple.data.CardDto;
import org.exemple.ports.api.CardServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@CrossOrigin
public class CardController {

	@Autowired
	private CardServicePort cardServicePort;

	@GetMapping("/dealOneCard")
	public CardDto dealOneCard() {
		return cardServicePort.dealOneCard();
	}

	@GetMapping("/shuffle")
	public void shuffle() {
		cardServicePort.shuffle();
	}
}
