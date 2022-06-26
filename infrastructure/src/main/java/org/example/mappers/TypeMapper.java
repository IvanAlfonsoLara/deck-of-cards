package org.example.mappers;

import java.util.List;

import org.example.entity.Type;
import org.exemple.data.TypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeMapper {

	TypeMapper INSTANCE = Mappers.getMapper(TypeMapper.class);

	TypeDto typeToTypeDto(Type type);

	Type typeDtoToType(TypeDto typeDto);

	List<TypeDto> typeListToTypeDtoList(List<Type> typeList);

	List<Type> typeDtoListToTypeList(List<TypeDto> typeDtoList);
}
