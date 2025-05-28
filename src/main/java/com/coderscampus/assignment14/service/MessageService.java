package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.InMemoryMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final InMemoryMessageRepository inMemoryMessageRepository;

    public MessageService(InMemoryMessageRepository inMemoryMessageRepository) {
        this.inMemoryMessageRepository = inMemoryMessageRepository;
    }

    public Message saveMessage(Message message) {
        return inMemoryMessageRepository.save(message);
    }

    public List<Message> findAll() {
        return inMemoryMessageRepository.findAll();
    }

    public List<Message> findByChannel(Channel channel) {
        return inMemoryMessageRepository.findByChannel(channel);
    }
}
