//package com.bugtracker.test.service;
//
//import com.bugtracker.dto.ProjectDTO;
//import com.bugtracker.dto.ProjectVersionDTO;
//import com.bugtracker.service.ProjectService;
//import com.bugtracker.test.config.TestDataBaseConfig;
//import com.bugtracker.test.util.ProjectDTOUtil;
//import com.bugtracker.test.util.ProjectVersionDTOUtil;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//@DirtiesContext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestDataBaseConfig.class)
//@WebAppConfiguration
//public class ProjectServiceTest {
//
//    @Resource
//    private EntityManagerFactory entityManagerFactory;
//    protected EntityManager entityManager;
//
//    @Resource
//    private ProjectService projectService;
//
//    @Before
//    public void setUp() throws Exception{
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testSaveProjectVersion() throws Exception{
//        ProjectDTO projectDTO = ProjectDTOUtil.createProjectDTO();
//        MultipartFile multipartFile = new CommonsMultipartFile;
//        projectService.addProject(null, projectDTO);
//    }
//
//}
