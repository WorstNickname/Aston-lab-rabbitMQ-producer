package ru.aston.model;

import java.util.Date;

public record CustomMessage(Integer id,
                            String message,
                            Date timeAt) {

    @Override
    public String toString() {
        return "CustomMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", timeAt=" + timeAt +
                '}';
    }

}
