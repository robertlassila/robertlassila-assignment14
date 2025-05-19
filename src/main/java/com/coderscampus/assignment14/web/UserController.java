package com.coderscampus.assignment14.web;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;
import com.coderscampus.assignment14.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;
    private final MessageService messageService;
    private final ChannelService channelService;

    public UserController(UserService userService, MessageService messageService, ChannelService channelService) {
        this.userService = userService;
        this.messageService = messageService;
        this.channelService = channelService;

    }

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        model.put("user", new User());
        return "welcome";
    }

    @PostMapping("/welcome")
    public String welcomePost(User user) {
        userService.save(user);
        return "redirect:/channels";
    }

    @GetMapping("/channels")
    public String channels(ModelMap model) {

        List<Channel> channelList = channelService.findAll();
        model.put("channelList", channelList);

        List<Message> allMessages = messageService.findAll();
        model.put("allMessages", allMessages);

        model.put("message", new Message());

        Channel channel = new Channel();
        channel.setId(null);
        model.put("channel", channel);

        return "channels";
    }

    @PostMapping("/channels")
    public String channelsPost(Model model, @PathVariable Long id) {
        Optional<Channel> channel = channelService.findById(id);
        return "redirect:/channels/{channelId}";
    }

    @PostMapping("/channels/{channelId}")
    public String channelsPost(@PathVariable Long channelId, Message message) {
        Optional<Channel> channelOpt = channelService.findById(channelId);
        if (channelOpt.isPresent()) {
            message.setChannel(channelOpt.get());
            messageService.saveMessage(message);
        }
        return "redirect:/channels/" + channelId;
    }

    @GetMapping("/channels/{channelId}")
    public String channelId(ModelMap model, @PathVariable("channelId") Long id) {
    Optional<Channel> channel = channelService.findById(id);
    model.put("channel", channel.get());
    model.put("channelList", channelService.findAll());
    model.put("allMessages", messageService.findAll());
    model.put("message", new Message());
    return "channels";
}



    @GetMapping("")
    public String sendToHome() {
        return "redirect:/welcome";
    }

}
