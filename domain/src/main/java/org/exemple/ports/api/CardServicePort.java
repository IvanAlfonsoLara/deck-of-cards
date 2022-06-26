package org.exemple.ports.api;

import org.exemple.data.CardDto;

import java.util.List;

public interface CardServicePort {

    List<CardDto> getCards();
}
