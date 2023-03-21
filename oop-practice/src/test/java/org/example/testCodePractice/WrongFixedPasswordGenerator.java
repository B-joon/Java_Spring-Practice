package org.example.testCodePractice;

import org.example.testCodePratice.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "ab"; // 2글자
    }
}
