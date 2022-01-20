package br.com.diobootcamp.people.services;

import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diobootcamp.people.dto.MessageResponseDto;
import br.com.diobootcamp.people.dto.request.PersonDto;
import br.com.diobootcamp.people.entities.Person;
import br.com.diobootcamp.people.exceptions.PersonNotFoundException;
import br.com.diobootcamp.people.mapper.PersonMapper;
import br.com.diobootcamp.people.repository.PersonRepository;
import lombok.Builder;

@Service
@Builder
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(
            PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(PersonDto personDto) {

        /* Transforming PersonDto in a Person object, to save it in database. */
        /*
         * If we do that manually, the code would be constructed like below:
         * Person newPerson = Person
         * .builder()
         * .firstName(personDto.getFirstName())
         * .lastName(personDto.getLastName())
         * .cpf(personDto.getCpf())
         * .birthday(personDto.getBirthday().toLocalDate())
         * .build();
         */

        /*
         * But we gonna use a Map struct lib to do the conversion automatically.
         * 
         * To use Map Struct, we need:
         * 
         * 1- Add the dependency in pom.xml, in <dependency> and in <build>;
         * 2- Create an interface (PersonMapper) to configurate the Mapper structure.
         * 3- Indicate if has type convertion (in our case, the birthday field has
         * differents
         * types in Person and PersonDTO).
         */
        Person newPerson = personMapper.toModel(personDto);

        Person savedPerson = personRepository.save(newPerson);
        return MessageResponseDto.builder()
                .message("Created person with id = " + savedPerson.getId())
                .build();

        /*
         * try {
         * savedPerson = personRepository.save(personDto
         * );
         * msgResponseDto.setMessage("Created person with id = "+ savedPerson.getId());
         * return msgResponseDto;
         * } catch (Exception e) {
         * System.out.println(" Can't create the new person." + e);
         * }
         */

    }

    public List<PersonDto> readAll() {
        List<Person> allPeople = personRepository.findAll();
        List<PersonDto> allPeopleDto = allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
        return allPeopleDto;
    }

    public PersonDto findById(Long id) throws PersonNotFoundException {
        /*First Implementation: with Optional*/
        /*
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isEmpty()){
            throw new  PersonNotFoundException(id);
        }
        return personMapper.toDTO(personOptional.get());
        */
        /*****************/
        /*Second Implementation: More condensed */
        Person person = personRepository.findById(id)
            .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);

    }
}
