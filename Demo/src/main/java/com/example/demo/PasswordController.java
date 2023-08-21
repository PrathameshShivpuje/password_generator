package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
public class PasswordController {
    private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 12;

    @PostMapping("/generate-password")
    public String generatePassword() {
        String generatedPassword = generateRandomPassword(PASSWORD_LENGTH);
        return generatedPassword;
    }

    private String generateRandomPassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARSET.length());
            password.append(CHARSET.charAt(randomIndex));
        }

        return password.toString();
    }
}
