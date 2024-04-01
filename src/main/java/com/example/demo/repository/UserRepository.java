package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<Users, Long> {

    Optional<Users> findByLogin(String login);

}
