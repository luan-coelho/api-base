package com.baseapi.service;

import com.baseapi.model.User;
import com.baseapi.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService extends BaseService<User, UserRepository> {

}
