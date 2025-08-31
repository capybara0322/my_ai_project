package com.example.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/try")
public class TryController {

    private final ChatClient chatClient;

    @Autowired
    public TryController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestBody String question) {
        Prompt prompt = new Prompt(new UserMessage(question));
        ChatResponse response = chatClient.call(prompt);
        return response.getResult().getOutput().getContent();
    }

    @GetMapping("/ask")
    public String askQuestion2(@RequestParam String question) {
        Prompt prompt = new Prompt(new UserMessage(question));
        ChatResponse response = chatClient.call(prompt);
        return response.getResult().getOutput().getContent();
    }

}
