package br.com.diobootcamp.people.dto.request;

import java.util.List;
import br.com.diobootcamp.people.entities.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    private String birthday;

    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    @NotEmpty
    private List<PhoneDto> phones;
}
