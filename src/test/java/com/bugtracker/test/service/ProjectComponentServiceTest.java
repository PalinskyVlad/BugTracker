//package com.bugtracker.test.service;
//
//import com.bugtracker.dto.ProjectComponentDTO;
//import com.bugtracker.dto.ProjectDTO;
//import com.bugtracker.service.ProjectComponentService;
//import com.bugtracker.service.ProjectService;
//import com.bugtracker.test.config.TestDataBaseConfig;
//import com.bugtracker.test.util.ProjectComponentDTOUtil;
//import com.bugtracker.test.util.ProjectDTOUtil;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//@DirtiesContext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestDataBaseConfig.class)
//@WebAppConfiguration
//public class ProjectComponentServiceTest {
//
//    @Resource
//    private EntityManagerFactory entityManagerFactory;
//    protected EntityManager entityManager;
//
//    @Resource
//    private ProjectComponentService projectComponentService;
//
//    @Resource
//    private ProjectService projectService;
//
//    @Before
//    public void setUp() throws Exception {
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testSaveProjectComponent() throws Exception {
//        ProjectDTO projectDTO = ProjectDTOUtil.createProjectDTO();
//        projectService.addProject(null,projectDTO);
//        ProjectComponentDTO projectComponentDTO = ProjectComponentDTOUtil.createProjectComponentDTO();
//        projectComponentService.addProjectComponent(projectDTO, projectComponentDTO);
//
//    }
//}
