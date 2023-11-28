package com.example.accessoriesmanagement.service.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IUserRepository;
import com.example.accessoriesmanagement.repositories.Impl.UserRepositoryImpl;
import com.example.accessoriesmanagement.service.IUserService;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserServiceImpl implements IUserService {
    IUserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User getUserById(Long userId) {
        return  userRepository.getUserById(userId);
    }
}
