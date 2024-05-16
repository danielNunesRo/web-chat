package com.danielnunesro.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danielnunesro.chat.models.ChatMessage;

@Controller
public class ChatController {
	
	@GetMapping("/")
    public String login() {
        return "login";  // Nome do template Thymeleaf (login.html)
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "chat";  // Nome do template Thymeleaf (chat.html)
    }

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }
	
}
