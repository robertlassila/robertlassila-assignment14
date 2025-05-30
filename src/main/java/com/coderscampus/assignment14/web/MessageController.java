package com.coderscampus.assignment14.web;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MessageController {

    private final MessageService messageService;
    private final ChannelService channelService;

    public MessageController(MessageService messageService, ChannelService channelService) {
        this.messageService = messageService;
        this.channelService = channelService;

    }

    @GetMapping("/api/messages/{channelId}")
    @ResponseBody
    public List<Message> getMessagesForChannel(@PathVariable Long channelId) {
        Optional<Channel> channelOpt = channelService.findById(channelId);
        if (channelOpt.isPresent()) {
            return messageService.findByChannel(channelOpt.get());
        } else {
            return List.of();
        }
    }

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        return "welcome";
    }

    @PostMapping("/welcome")
    public String welcomePost() {
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

    @PostMapping("/chatpage/{channelId}")
    public String channelsPost(@PathVariable Long channelId, Message message, String username) {
        Optional<Channel> channelOpt = channelService.findById(channelId);

        if (channelOpt.isPresent()) {
            message.setChannel(channelOpt.get());
            message.setUsername(username);
            messageService.saveMessage(message);
        }
        return "redirect:/chatpage/" + channelId;
    }

    @GetMapping("/chatpage/{channelId}")
    public String channelId(ModelMap model, @PathVariable("channelId") Long id) {
    Optional<Channel> channel = channelService.findById(id);
    if (channel.isEmpty()) {
        return "channelError";
    }
    model.put("channel", channel.get());
    model.put("channelList", channelService.findAll());
    model.put("allMessages", messageService.findAll());
    model.put("message", new Message());
    return "chatpage";
}

    @GetMapping("")
    public String sendToHome() {
        return "redirect:/welcome";
    }

}
