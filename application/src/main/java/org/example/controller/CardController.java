package org.example.controller;

import org.example.vo.ErrorEntry;
import org.exemple.data.CardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/card")
@CrossOrigin
public interface CardController {

	@Operation(summary = "Gives one card of the deck until its empty.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful response."),
			@ApiResponse(responseCode = "404", description = "Card not found, please shuffle.", content = {
					@Content(array = @ArraySchema(schema = @Schema(implementation = ErrorEntry.class))) }),
			@ApiResponse(responseCode = "503", description = "Internal server error", content = {
					@Content(array = @ArraySchema(schema = @Schema(implementation = ErrorEntry.class))) }) })
	@GetMapping("/dealOneCard")
	public ResponseEntity<CardDto> dealOneCard();

	@Operation(summary = "Shuffle the deck and reload it if its empty.")
	@GetMapping("/shuffle")
	public void shuffle();
}
