package br.com.diobootcamp.people.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PhoneTypes {
    COMMERCIAL("Commercial"),
    HOME("Home"),
    MOBILE("Mobile");

    private String description;
}
