package com.example.newsletter.controllers;

import com.example.newsletter.entities.Lead;
import com.example.newsletter.repository.EmailRepository;
import com.example.newsletter.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class NewsletterController {
    @Autowired
    private EmailRepository emailRepository;

    @PostMapping("/api/newsletter")
    public String registerEmail(@RequestBody Lead lead) {

        String email = lead.getEmail();

        EmailValidator emailValidator = new EmailValidator();
        if (emailValidator.esValido(email) == false) {
            return "El email no es valido";
        }

        emailRepository.emailSave(email);
        return "Email guardado";
    }

    @DeleteMapping("/api/newsletter/unsuscribe")
    public String deleteEmails(@RequestBody Lead lead) {

        String email = lead.getEmail();

        emailRepository.emailDelete(email);
        return "Email borrado";
    }

    @GetMapping("/api/newsletter")
    public List<String> getEmails() {


        return emailRepository.getEmails();
    }
}