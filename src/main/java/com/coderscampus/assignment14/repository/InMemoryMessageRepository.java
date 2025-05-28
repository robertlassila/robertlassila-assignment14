package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMessageRepository implements MessageRepository {

    private final Map<Long, Message> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Message save(Message message) {
        if (message.getId() == null) {
            message.setId(idGenerator.incrementAndGet());
        }
        storage.put(message.getId(), message);
        return message;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }


    public List<Message> findByChannel(Channel channel) {
        List<Message> allMessages = findAll();
        List<Message> messagesByChannel = new ArrayList<>();

        for (Message message : allMessages) {
            if (message.getChannel().equals(channel)) {
                messagesByChannel.add(message);
            }
        }
        return messagesByChannel;
    }
}
