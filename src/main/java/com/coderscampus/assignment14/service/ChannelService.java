package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.repository.InMemoryChannelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    private final InMemoryChannelRepository inMemoryChannelRepository;

    public ChannelService(InMemoryChannelRepository inMemoryChannelRepository) {
        this.inMemoryChannelRepository = inMemoryChannelRepository;
    }

    public List<Channel> createChannels() {
        List<Channel> channels = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            Channel channel = new Channel();
            channel.setName("Channel " + (i + 1));
            channels.add(channel);
        }
        inMemoryChannelRepository.saveAll(channels);
        return channels;
    }

    public Optional<Channel> findById(Long id) {
        return inMemoryChannelRepository.findById(id);
    }

    public List<Channel> findAll() {
        if (inMemoryChannelRepository.count() == 0) {
            createChannels();
        }
        return inMemoryChannelRepository.findAll();
    }
}
