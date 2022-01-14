package br.com.diobootcamp.people.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diobootcamp.people.dto.MessageResponseDto;
import br.com.diobootcamp.people.entities.Person;
import br.com.diobootcamp.people.repository.PersonRepository;
import lombok.Builder;

@Service
@Builder
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(
            PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(Person newPerson) {

        Person savedPerson = personRepository.save(newPerson);
        // msgResponseDto.setMessage("Created person with id = "+ savedPerson.getId());
        return MessageResponseDto.builder()
                .message("Created person with id = " + savedPerson.getId())
                .build();

        /*
         * try {
         * savedPerson = personRepository.save(newPerson);
         * msgResponseDto.setMessage("Created person with id = "+ savedPerson.getId());
         * return msgResponseDto;
         * } catch (Exception e) {
         * System.out.println(" Can't create the new person." + e);
         * }
         */

    }

    public List<Person> readAll() {
        return personRepository.findAll();
    }
}
