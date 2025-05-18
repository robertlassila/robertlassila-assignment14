package com.coderscampus.assignment14.web;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.MessageService;
import com.coderscampus.assignment14.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final MessageService messageService;

    public UserController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        model.put("user", new User());
        return "welcome";
    }

    @PostMapping("/welcome")
    public String welcomePost(User user) {
        userService.save(user);
        return "redirect:/chat";
    }

    @GetMapping("/chat")
    public String chat(ModelMap model) {
        return "channeldirectory";
    }

    @GetMapping("/channels")
    public String channels(ModelMap model) {
        List<Message> allMessages = messageService.findAll();

        model.put("message", new Message());

        model.put("allMessages", allMessages);
        return "channels";
    }

    @PostMapping("/channels")
    public String channelsPost(Message message) {
        messageService.saveMessage(message);
        return "redirect:/channels";
    }



    @GetMapping("")
    public String sendToHome() {
        return "redirect:/welcome";
    }

}
