package com.nyash.travellizer.service.user.impl;

import com.nyash.travellizer.model.entity.user.User;
import com.nyash.travellizer.service.user.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findById(int userId) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public void delete(int userId) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
