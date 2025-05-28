package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryChannelRepository implements ChannelRepository {
    
    private final Map<Long, Channel> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<Channel> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Channel> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Channel save(Channel channel) {
        if (channel.getId() == null) {
            channel.setId(idGenerator.incrementAndGet());
        }
        storage.put(channel.getId(), channel);
        return channel;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
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