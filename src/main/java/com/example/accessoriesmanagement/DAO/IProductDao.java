package com.example.accessoriesmanagement.DAO;

import com.example.accessoriesmanagement.entity.User;

public interface IProductDao {
    User selectUser(String email);

}
