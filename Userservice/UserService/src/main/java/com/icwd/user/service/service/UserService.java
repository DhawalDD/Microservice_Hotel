package com.icwd.user.service.service;

import com.icwd.user.service.entity.User;
import com.icwd.user.service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserById(String id);

    User getUser(String id);

    String deleteUser(String id);

    User updateUser(User user , String id);



}
