package org.example.controller;

import org.exemple.data.CardDto;
import org.exemple.ports.api.CardServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardServicePort cardServicePort;

    @GetMapping("/get")
    public List<CardDto> getAllCards() {
        return cardServicePort.getCards();
    }
}
