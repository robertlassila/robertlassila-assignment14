package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    //void saveChannels(List<Channel> channels);



}
