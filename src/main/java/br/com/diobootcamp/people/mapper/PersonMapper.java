package br.com.diobootcamp.people.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import br.com.diobootcamp.people.dto.request.PersonDto;
import br.com.diobootcamp.people.entities.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

   // @Mapping(source = "birthday", target = "birthday", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);

    PersonDto toDTO(Person person);
}
