package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public List<Channel> createChannels() {
        List<Channel> channels = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            Channel channel = new Channel();
            channel.setName("Channel " + i);
            channels.add(channel);
        }
        channelRepository.saveAll(channels);
        return channels;
    }

    public Optional<Channel> findById(Long id) {
        return channelRepository.findById(id);
    }

    public List<Channel> findAll() {
        if (channelRepository.count() == 0) {
            createChannels();
        }
        return channelRepository.findAll();
    }
}
