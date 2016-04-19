//package com.bugtracker.test.service;
//
//import com.bugtracker.dto.ProjectComponentDTO;
//import com.bugtracker.dto.ProjectDTO;
//import com.bugtracker.mapper.ProjectComponentMapper;
//import com.bugtracker.mapper.ProjectMapper;
//import com.bugtracker.repository.ProjectRepository;
//import com.bugtracker.service.ProjectComponentService;
//import com.bugtracker.service.ProjectService;
//import com.bugtracker.test.config.TestDataBaseConfig;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
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
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Resource
//    private ProjectMapper projectMapper;
//
//
//    @Autowired
//    private ProjectComponentMapper mapper;
//
//    @Before
//    public void setUp() throws Exception {
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testSaveProjectComponent() throws Exception {
//
//
//        ProjectComponentDTO projectComponentDTO = new ProjectComponentDTO();
//        projectComponentDTO.setName("coretest2");
//        projectComponentDTO.setDescription("test2");
//
//        ProjectDTO projectDTO = new ProjectDTO();
//        projectDTO.setName("Test Project2");
//        projectDTO.setAvatar(new byte[20]);
//
//
//
//        projectComponentService.addProjectComponent(projectDTO, projectComponentDTO);
//
//    }
//}
