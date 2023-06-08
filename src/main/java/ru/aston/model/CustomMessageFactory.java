package ru.aston.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomMessageFactory {

    private static int idCounter = 1;

    public CustomMessage create(String message) {
        return new CustomMessage(idCounter++, message, new Date());
    }

}
