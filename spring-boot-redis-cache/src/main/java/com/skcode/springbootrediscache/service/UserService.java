package com.skcode.springbootrediscache.service;

import com.skcode.springbootrediscache.entity.User;
import com.skcode.springbootrediscache.repo.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final String CACHE_NAME = "cache_users";

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(value = CACHE_NAME, key = "#id")
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @CachePut(value = CACHE_NAME, key = "#user.id")
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = CACHE_NAME, key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
