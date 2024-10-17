package com.example.SAMPLE.controller;


import com.example.SAMPLE.entity.Message;
import com.example.SAMPLE.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/hello")
    public String helloWorld() {
        // Save the message to the database
        Message message = new Message("Hello!");
        messageRepository.save(message);

        return "Message saved: " + message.getContent();
    }

}
