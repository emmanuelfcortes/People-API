package br.com.diobootcamp.people.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    @GetMapping("/")
    public String defaultController(){
        return "Default Controller!";
    }
}
