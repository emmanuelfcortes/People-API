package br.com.diobootcamp.people.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA annotation to create a entity database
@Data // Lombok annotation to generate getters and setters to all class attributes
@Builder // Lombok annotation that enable the use of builder to class instantiation
@AllArgsConstructor // Lombok annotation to create constructor with all class attributes like
                    // arguments
@NoArgsConstructor // Lombok annotation to create empty class constructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private LocalDate birthday;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<Phone> phones;
}
