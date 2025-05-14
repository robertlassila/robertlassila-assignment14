package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
