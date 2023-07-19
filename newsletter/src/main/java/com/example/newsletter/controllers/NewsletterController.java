package com.example.newsletter.controllers;

import com.example.newsletter.entities.Lead;
import com.example.newsletter.validators.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsletterController {
    @PostMapping("/api/newsletter")
    public String registrar(@RequestBody Lead lead){

        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.esValido(lead.getEmail())){
            return "El email no es valido";
        }
        return "Email: "+lead.getEmail() ;
    }

}
