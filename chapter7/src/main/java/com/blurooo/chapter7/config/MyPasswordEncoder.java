package com.blurooo.chapter7.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class MyPasswordEncoder extends BCryptPasswordEncoder {
    // BCrypt 密文的正则表达式
    private static Pattern BCRYPT_PATTERN =
            Pattern. compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}") ;

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()){
            return rawPassword.equals(encodedPassword);
        }
        return super.matches(rawPassword, encodedPassword);
    }
}
