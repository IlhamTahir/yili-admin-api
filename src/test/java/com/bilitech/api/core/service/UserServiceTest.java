package com.bilitech.api.core.service;

import com.bilitech.api.core.dto.UserCreateRequest;
import com.bilitech.api.core.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void create() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("testUser");
        userCreateRequest.setPassword("password");

        UserDto userDto = userService.create(userCreateRequest);
        System.out.println(userDto.toString());
    }
}