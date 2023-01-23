package com.manilov.shop.service;

import com.manilov.shop.domain.Role;
import com.manilov.shop.domain.User;
import com.manilov.shop.repos.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Test
    public void saveUser() {
        User user = new User();
        user.setPassword("12345");
        Boolean isUserCreated = userService.saveUser(user);
        Assert.assertTrue(isUserCreated);
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
    @Test
    public void saveUserFailTest() {
        User user = new User();
        user.setUsername("testName");
        user.setPassword("12345");
        Mockito.doReturn(new User()).when(userRepository).findByUsername("testName");
        boolean isUserCreated = userService.saveUser(user);
        Assert.assertFalse(isUserCreated);
    }
}
