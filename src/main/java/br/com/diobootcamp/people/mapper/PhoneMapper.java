package br.com.diobootcamp.people.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.diobootcamp.people.dto.request.PhoneDto;
import br.com.diobootcamp.people.entities.Phone;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toModel(PhoneDto phoneDto);

    PhoneDto toDTO(Phone phone);
}
