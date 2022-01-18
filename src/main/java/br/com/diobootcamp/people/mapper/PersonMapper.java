package br.com.diobootcamp.people.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import br.com.diobootcamp.people.dto.request.PersonDto;
import br.com.diobootcamp.people.entities.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthday", source = "birthday", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);

    @Mapping(target = "birthday", source = "birthday", dateFormat = "dd-MM-yyyy")
    PersonDto toDTO(Person person);
}
