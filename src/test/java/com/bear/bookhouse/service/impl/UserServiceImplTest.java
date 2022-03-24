package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.service.UserService;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 11:07
 */
public class UserServiceImplTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    public void getUserScore() {
        int userScore = userService.getUserScore(2);
        System.out.println(userScore);
    }
}