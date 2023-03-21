package org.example.testCodePractice;

import org.example.testCodePratice.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "abcdefgh"; // 8글자
    }
}
