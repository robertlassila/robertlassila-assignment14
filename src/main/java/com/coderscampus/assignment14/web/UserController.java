package com.coderscampus.assignment14.web;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
        return "chat";
    }

    @GetMapping("")
    public String sendToHome() {
        return "redirect:/welcome";
    }

}
