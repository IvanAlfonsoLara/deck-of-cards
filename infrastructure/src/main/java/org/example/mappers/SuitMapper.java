package org.example.mappers;

import java.util.List;

import org.example.entity.Suit;
import org.exemple.data.SuitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SuitMapper {

	SuitMapper INSTANCE = Mappers.getMapper(SuitMapper.class);

	SuitDto suitToSuitDto(Suit suit);

	Suit suitDtoToSuit(SuitDto suitDto);

	List<SuitDto> suitListToSuitDtoList(List<Suit> suitList);

	List<Suit> suitDtoListToSuitList(List<SuitDto> suitDtoList);
}
