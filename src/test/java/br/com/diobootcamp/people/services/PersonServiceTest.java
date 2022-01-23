package br.com.diobootcamp.people.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.diobootcamp.people.dto.MessageResponseDto;
import br.com.diobootcamp.people.dto.request.PersonDto;
import br.com.diobootcamp.people.entities.Person;
import br.com.diobootcamp.people.mapper.PersonMapper;
import br.com.diobootcamp.people.repository.PersonRepository;
import br.com.diobootcamp.people.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    
    @Autowired
    private PersonMapper personMapper = PersonMapper.INSTANCE;
    
    @Mock
    private PersonRepository personRepository;
    
    @InjectMocks // inject the Mocks object, instanciated with @Mock  annotation at class below.
    private PersonService personService;

    @Test
    void testGivenPersonDTOThanReturnSaveMessage() {
        
        PersonDto personDtoFake = PersonUtils.createPersonFake();
        Person expectedSavedPersonFake = PersonUtils.createEntityFake();
        Mockito.when(personRepository.save(personMapper.toModel(personDtoFake)))
            .thenReturn(expectedSavedPersonFake);
        MessageResponseDto messageResponseReturned = personService.createPerson(personDtoFake);
        MessageResponseDto messageResponseExpected = createResponseMessageExpected(expectedSavedPersonFake.getId());
        assertEquals(messageResponseExpected, messageResponseReturned);
    }

    private MessageResponseDto createResponseMessageExpected(Long id) {
        return MessageResponseDto
        .builder()
        .message("Created person with id = " + id)
        .build();
    }
    
    
}
