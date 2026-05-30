package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.learn.service.ChatService;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class chatController {

    @Autowired
    ChatService chatService;

    @PostMapping("/chat")
    public String generateResponse(@RequestParam String category, @RequestParam String year) { // Fix 1: added @RequestParam on year
        return chatService.gentChatResponse(category, year).getResult().getOutput().getText(); // Fix 2: getText()
    }

    @PostMapping("/image/chat")
    public String generateRespImage(@RequestParam String query) throws IOException {
        return chatService.getImageChatReader(query);
    }
}