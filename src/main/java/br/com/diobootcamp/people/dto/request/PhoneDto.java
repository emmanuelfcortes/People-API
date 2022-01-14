package br.com.diobootcamp.people.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;

import br.com.diobootcamp.people.enums.PhoneTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ValidateOnExecution
public class PhoneDto {

    private Long id;

    @Valid
    @Enumerated(EnumType.STRING)
    private PhoneTypes type;

    @Valid
    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
