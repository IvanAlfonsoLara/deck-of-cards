package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ErrorEntry {

	private final ErrorCode code;
	private final String message;
}
