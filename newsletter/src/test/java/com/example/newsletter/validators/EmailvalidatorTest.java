package com.example.newsletter.validators;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@SpringBootTest
public class EmailvalidatorTest {

    EmailValidator validator = new EmailValidator();

    @Test
    public void testEmailConArroba() {
        String email = "correo@example.com";
        assertTrue(validator.esValido(email));
    }

    @Test
    public void testEmailSinArroba() {
        String email = "correoejemplo.com";
        assertFalse(validator.esValido(email));
    }

    @Test
    public void testEmailVacio() {
        String email = "";
        assertFalse(validator.esValido(email));
    }

    @Test
    public void testEmailNull() {
        String email = null;
        assertFalse(validator.esValido(email));
    }
}
