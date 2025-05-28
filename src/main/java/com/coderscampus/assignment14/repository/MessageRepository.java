package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    List<Message> findAll();
    Optional<Message> findById(Long id);
    Message save(Message message);
    void deleteById(Long id);



}
