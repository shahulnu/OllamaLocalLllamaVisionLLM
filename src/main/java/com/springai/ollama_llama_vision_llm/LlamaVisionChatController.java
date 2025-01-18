package com.springai.ollama_llama_vision_llm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Slf4j
@RequestMapping("/api/v1")
public class LlamaVisionChatController {

    private final LlamaVisionService llamaService;

    public LlamaVisionChatController(LlamaVisionService llamaService) {
        this.llamaService = llamaService;
    }

    @GetMapping("/ai/generate")
    public String getResponse(@RequestParam String prompt, @RequestParam("file") MultipartFile file) throws IOException {
        log.info(file.getOriginalFilename());
        
        File tempFile = File.createTempFile(file.getOriginalFilename(), null);   
        file.transferTo(tempFile);
        
        var response = llamaService.generateResponse(prompt, tempFile);
        return response;
    }
    
    
}
