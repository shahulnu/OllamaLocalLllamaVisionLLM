package com.springai.ollama_llama_vision_llm;

import java.io.File;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LlamaVisionService {

    private final OllamaChatModel ollamaChatModel;

    public LlamaVisionService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public String generateResponse(String prompt, File imageResource) {
        log.info(prompt);
        var image = new FileSystemResource(imageResource);
        var userMessage = new UserMessage(prompt, new Media(MimeTypeUtils.IMAGE_PNG, image));

        ChatResponse response = ollamaChatModel.call(new Prompt(userMessage));
        return response.getResult().getOutput().getContent();
    }
    
}
