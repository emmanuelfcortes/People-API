package br.com.diobootcamp.people.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.diobootcamp.people.dto.request.PersonDto;
import br.com.diobootcamp.people.dto.request.PhoneDto;
import br.com.diobootcamp.people.entities.Person;
import br.com.diobootcamp.people.entities.Phone;
import br.com.diobootcamp.people.mapper.PhoneMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class PersonUtils {
    @Autowired
    private static PhoneMapper phoneMapper = PhoneMapper.INSTANCE;
    private final static Long ID =1L;
    private final static String FIRSTNAME ="Allan";
    private final static String LASTNAME ="Brado";
    private final static String BIRTHDAY_DTO = "20-12-2010" ;
    private final static LocalDate BIRTHDAY = LocalDate.of(2010, 12, 20);
    private final static String CPF ="01027362192";
    //private List<Phone> PHONES = Collections.singletonList(PhoneUtils.createPhoneFake());
    private static List<PhoneDto> phones_dto = new ArrayList<PhoneDto>(){{
        add(PhoneUtils.createPhoneFake());
        add(PhoneUtils.createPhoneFake(2l));
        add(PhoneUtils.createPhoneFake(3l));
    }};
    private static List<Phone> phones = phones_dto.stream().map(phoneMapper::toModel).collect(Collectors.toList());
    
    
    public static PersonDto  createPersonFake(){
        return PersonDto.builder()
            .firstName(FIRSTNAME)
            .lastName(LASTNAME)
            .cpf(CPF)
            .birthday(BIRTHDAY_DTO)
            .phones(phones_dto)
            .build();
    }
    public static Person createEntityFake(){
        return Person.builder()
            .id(ID)
            .firstName(FIRSTNAME)
            .lastName(LASTNAME)
            .cpf(CPF)
            .birthday(BIRTHDAY)
            .phones(phones)
            .build();
    }
}
