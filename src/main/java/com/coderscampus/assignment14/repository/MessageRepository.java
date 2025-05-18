package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    public List<Message> findAll();
}
