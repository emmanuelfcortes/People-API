package br.com.diobootcamp.people.utils;

import br.com.diobootcamp.people.dto.request.PhoneDto;
import br.com.diobootcamp.people.enums.PhoneTypes;

public class PhoneUtils {
    
    private final static PhoneTypes TYPE = PhoneTypes.MOBILE;
    private final static String NUMBER = "11223344554332";
    private final static Long ID = 1L;

    public static PhoneDto createPhoneFake(){
        return PhoneDto.builder()
            .id(ID)
            .type(TYPE)
            .number(NUMBER)
            .build();
    }
    public static PhoneDto createPhoneFake(final Long PASSED_ID){
        return PhoneDto.builder()
            .id(PASSED_ID)
            .type(TYPE)
            .number(NUMBER)
            .build();
    }
}
