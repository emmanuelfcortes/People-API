package br.com.diobootcamp.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diobootcamp.people.entities.Person;
/* tO USE JpaRepository class, we need indicate the class type of mainly entity and
indicate the data type of entity id.
The Spring manage the database conection. Then, we don't need open or close acess link with
database manually.*/
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
