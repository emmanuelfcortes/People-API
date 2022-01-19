package br.com.diobootcamp.people.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.diobootcamp.people.dto.MessageResponseDto;
import br.com.diobootcamp.people.dto.request.PersonDto;
import br.com.diobootcamp.people.services.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PeopleController {
    private PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto) {
        if (!personDto.equals(null)) {
            MessageResponseDto msgResponseDto = personService.createPerson(personDto);
            return msgResponseDto;
        } else
            return MessageResponseDto.builder().message("Empty person.").build();
    }

    @GetMapping
    public List<PersonDto> readAll() {
        return personService.readAll();
    }

    @GetMapping("{id}")
    public PersonDto findPerson(@PathVariable Long id) {
        return personService.findById(id);
    }
}
