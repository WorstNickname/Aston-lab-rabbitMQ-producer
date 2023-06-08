package ru.aston.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.aston.model.CustomMessage;
import ru.aston.model.CustomMessageFactory;

@Service
public class MessageService {

    private final CustomMessageFactory messageFactory;
    private final Logger logger;

    public MessageService(CustomMessageFactory messageFactory) {
        this.messageFactory = messageFactory;
        this.logger = LogManager.getLogger(MessageService.class);
    }

    public CustomMessage produce(String text) {
        var message = messageFactory.create(text);
        logger.info("Message produced: " + message);
        return message;
    }

}
