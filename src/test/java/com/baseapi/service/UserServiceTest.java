package com.baseapi.service;

import com.baseapi.domain.model.User;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void testFindAll_Found_UserList() {
        userService.create(new User(null, "Admin"));
        List<User> userList = userService.findAll();

        Assertions.assertNotNull(userList);
        Assertions.assertTrue(userList.size() > 1);
    }

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

        Assertions.assertThrows(NotFoundException.class, () -> userService.findById(savedUser.getId() + 1));
    }

    @Test
    public void testCreate_Success_ObjectWithId() {
        User user = new User(null, "Admin");
        userService.create(user);

        Assertions.assertNotNull(user);
    }

    @Test
    public void testUpdate_Success_UpdatedObject() {
        User user = new User(null, "Admin");
        User savedUser = userService.create(user);
        User userDto = new User(null, "User");
        userDto.setId(savedUser.getId());
        Long updatedUserId = userService.update(userDto).getId();
        User updatedFound = userService.findById(updatedUserId);

        Assertions.assertNotNull(updatedFound);
        Assertions.assertEquals("User", updatedFound.getName());
    }

    @Test
    public void testDelete_Success_Object() {
        User user = new User(null, "Admin");
        Long id = userService.create(user).getId();

        userService.deleteById(id);

        Assertions.assertThrows(NotFoundException.class, () -> userService.findById(id));
    }
}