//package com.bugtracker.test.service;
//
//import com.bugtracker.entity.User;
//import com.bugtracker.entity.enums.UserRoleEnum;
//import com.bugtracker.repository.UserRepository;
//import com.bugtracker.test.config.TestDataBaseConfig;
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
//    @Resource
//    private UserRepository userRepository;
//
//    @Before
//    public void setUp() throws Exception {
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testSaveUser() throws Exception {
//
//        User user = new User();
//        user.setEmail("lolik@gmail.com");
//        user.setFirstName("Grisha");
//        user.setLastName("Petrov");
//        user.setUsername("demon");
//        user.setPassword("dfsdfsf");
//        user.setRole(UserRoleEnum.ADMIN);
//        userRepository.saveAndFlush(user);
//    }
//}
