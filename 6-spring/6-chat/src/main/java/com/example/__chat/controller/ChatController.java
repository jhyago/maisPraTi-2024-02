package com.example.__chat.controller;

import com.example.__chat.model.ChatMessage;
import com.example.__chat.model.OpenAiResponse;
import com.example.__chat.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller

public class ChatController {

    private final OpenAiService openAiService;
    @Autowired
    public ChatController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.ask")
    @SendToUser("/queue/reply")
    public ChatMessage askChat(ChatMessage chatMessage) {
        String prompt = chatMessage.getContent();
        String answer = openAiService.askChatGPT(prompt);
        ChatMessage reply = new ChatMessage();
        reply.setSender("ChatGPT");
        reply.setContent(answer);
        return reply;
    }
}
