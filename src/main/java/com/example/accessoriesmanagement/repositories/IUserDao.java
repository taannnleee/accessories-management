package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserDao {
    User authenticateUser(String user, String pass);
    void editProfile(Date dateOfBirth, String email, String fName, String lName, String phone, Long userID);
    User checkAccountExist(String user);
    void signup(String user, String pass, String email);
    User getUserById(Long UserId);
    List<User> getAllAccount();
    void deleteAccount(Long id);
}
