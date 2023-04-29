package com.baseapi.service;

import com.baseapi.domain.model.User;
import com.baseapi.domain.repository.UserRepository;
import com.baseapi.service.BaseService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService extends BaseService<User, UserRepository> {

    // Implemente métodos específicos do UserService aqui, se necessário
}
