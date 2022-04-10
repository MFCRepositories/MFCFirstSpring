package com.mfcspring.demo.service.impl;

import com.mfcspring.demo.entity.User;
import com.mfcspring.demo.repository.UserRepository;
import com.mfcspring.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail()==null){
            throw  new IllegalArgumentException("Username cannot be null ");
        }
        user=userRepository.save(user);
    return user ;
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        this.userRepository.delete(user);
        return Boolean.TRUE;
    }

    @Override
    public User getByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

}
