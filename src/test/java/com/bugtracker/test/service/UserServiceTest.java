//package com.bugtracker.test.service;
//
//import com.bugtracker.dto.UserDTO;
//import com.bugtracker.entity.User;
//import com.bugtracker.entity.enums.UserRoleEnum;
//import com.bugtracker.test.config.TestDataBaseConfig;
//import com.bugtracker.test.util.UserDTOUtil;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import com.bugtracker.service.UserService;
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//@DirtiesContext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestDataBaseConfig.class)
//@WebAppConfiguration
//
//public class UserServiceTest {
//
//    @Resource
//    private EntityManagerFactory entityManagerFactory;
//    protected EntityManager entityManager;
//
//    @Resource
//    private UserService userService;
//
//    @Before
//    public void setUp() throws Exception {
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testSaveUser() throws Exception {
//        UserDTO userDTO = UserDTOUtil.createUserDTO();
//        userService.addUser(user)
//    }
//}
