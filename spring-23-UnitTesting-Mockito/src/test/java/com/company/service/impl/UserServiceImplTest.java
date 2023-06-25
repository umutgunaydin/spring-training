package com.company.service.impl;

import com.company.mapper.UserMapper;
import com.company.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findByUserName_Test(){

        //calling real method
        userService.findByUserName("harold@manager.com");

        // checking if this method run or not
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);

        //won't run because of 2 times
        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);

        //following are same
        verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com",false);

        //following are same
        verify(userRepository,atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,atMost(1)).findByUserNameAndIsDeleted("harold@manager.com",false);

        //checking order
        InOrder inOrder=inOrder(userRepository,userMapper);

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);
    }

}