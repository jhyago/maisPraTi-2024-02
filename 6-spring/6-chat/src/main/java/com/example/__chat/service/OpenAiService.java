package com.example.__chat.service;

import com.example.__chat.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {
    @Value("${openai.api.key}")
    private String openaiApiKey;

    private final WebClient webClient;

    public OpenAiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
    }

    public String askChatGPT(String prompt) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", prompt);
        messages.add(userMessage);
        requestBody.put("messages", messages);

        return webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer" + openaiApiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(OpenAiResponse.class)
                .map(response -> {
                    if(response.getChoices() != null && !response.getChoices().isEmpty()){
                        return response.getChoices().get(0).getMessage().getContent();
                    }
                    return "Nenhuma resposta recebida.";
                })
                .block();
    }
}
