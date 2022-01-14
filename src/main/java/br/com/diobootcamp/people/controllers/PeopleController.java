package br.com.diobootcamp.people.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diobootcamp.people.dto.MessageResponseDto;
import br.com.diobootcamp.people.entities.Person;
import br.com.diobootcamp.people.services.PersonService;

@RestController
@RequestMapping
public class PeopleController {
    private PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/v1/person")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody Person person) {
        if (!person.equals(null)) {
            MessageResponseDto msgResponseDto = personService.createPerson(person);
            return msgResponseDto;
        } else
            return MessageResponseDto.builder().message("Empty person.").build();
    }

    @GetMapping("/")
    public List<Person> readAll() {
        return personService.readAll();
    }

}
