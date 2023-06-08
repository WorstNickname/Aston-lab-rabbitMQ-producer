package ru.aston.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.service.MessageService;

import static ru.aston.config.RabbitConfiguration.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final RabbitTemplate template;
    private final MessageService messageService;
    private final Logger logger;

    public MessageController(RabbitTemplate template,
                             MessageService messageService) {
        this.template = template;
        this.messageService = messageService;
        this.logger = LogManager.getLogger(MessageController.class);
    }

    @PostMapping("/produce")
    public ResponseEntity<String> publishMessage(@RequestBody String text) {
        var message = messageService.produce(text);
        template.convertAndSend(EXCHANGE, ROUTING_KEY, message);
        logger.info("Message sent to queue: " + message);
        return ResponseEntity.ok("Message published!");
    }

}
