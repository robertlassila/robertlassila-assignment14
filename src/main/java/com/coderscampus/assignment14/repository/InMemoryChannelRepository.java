package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryChannelRepository {

    private final Map<Long, Channel> storage = new HashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(0);

    public List<Channel> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Channel> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Channel save(Channel channel) {
        if (channel.getId() == null) {
            channel.setId(idGenerator.incrementAndGet());
        }
        storage.put(channel.getId(), channel);
        return channel;
    }

    public void saveAll(List<Channel> channels) {
        for (Channel channel : channels) {
            save(channel);
        }
    }

    public int count() {
        return storage.size();
    }
}