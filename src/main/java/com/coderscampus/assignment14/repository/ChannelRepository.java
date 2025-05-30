package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository {

    List<Channel> findAll();
    Optional<Channel> findById(Long id);
    Channel save(Channel channel);
    void deleteById(Long id);

}
