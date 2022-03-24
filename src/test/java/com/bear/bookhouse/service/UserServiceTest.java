package com.bear.bookhouse.service;

import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 11:07
 */
public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    public void getUserScore() {
        int userScore = userService.getUserScore(2);
        System.out.println(userScore);
    }
}