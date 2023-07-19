package com.example.newsletter.validators;

public class EmailValidator {

    public boolean esValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        if (!email.contains("@") || !email.contains(".") || email.contains(" ")) {
            return false;
        }

        int arrobaIndex = email.indexOf('@');
        int puntoIndex = email.indexOf('.', arrobaIndex);

        if (arrobaIndex == 0 || puntoIndex <= arrobaIndex + 1 || email.endsWith("@") || email.endsWith(".")) {
            return false;
        }

        return true;
    }
}

