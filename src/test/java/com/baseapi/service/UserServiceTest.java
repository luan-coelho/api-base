package com.baseapi.service;

import com.baseapi.domain.model.User;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@TestTransaction
@QuarkusTest
class UserServiceTest {

    @Inject
    UserService userService;

    /**
     * Nomeclatura dos métodos:
     * Método_Cenário_Retorno
     */

    @Test
    public void testFindById_Found_User() {
        User savedUser = userService.create(new User(null, "Admin"));
        User databaseUser = userService.findById(savedUser.getId());

        Assertions.assertNotNull(databaseUser);
        Assertions.assertEquals(databaseUser.getId(), savedUser.getId());
    }

    @Test
    public void testFindById_NotFound_Exception() {
        User savedUser = userService.create(new User(null, "Admin"));

        Assertions.assertThrows(NotFoundException.class, () -> {
            userService.findById(savedUser.getId() + 1);
        });
    }

    @Test
    public void testCreate_Create_ObjectWithId() {
        User user = new User(null, "Admin");
        userService.create(user);

        Assertions.assertNotNull(user);
    }
}