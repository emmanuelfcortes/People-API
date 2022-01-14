package br.com.diobootcamp.people.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PhoneTypes {
    COMMERCIAL("Commercial"),
    HOME("Home"),
    MOBILE("Mobile");
    private final String description;
}

