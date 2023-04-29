package com.baseapi.service;

import com.baseapi.domain.model.User;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@TestTransaction
@QuarkusTest
class UserServiceTest {

    @Inject
    UserService userService;

    @Test
    public void testGet(){
        User savedUser = userService.create(new User(null, "Admin"));
        User databaseUser = userService.findById(savedUser.getId());

        assert databaseUser != null;
        assert databaseUser.getId().equals(savedUser.getId());
    }

    @Test
    public void testCreate() {
        User user = new User(null, "Admin");
        userService.create(user);

        assert user.getId() != null;
    }
}