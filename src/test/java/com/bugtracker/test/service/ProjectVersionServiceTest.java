//package com.bugtracker.test.service;
//
//import com.bugtracker.dto.ProjectDTO;
//import com.bugtracker.dto.ProjectVersionDTO;
//import com.bugtracker.entity.Project;
//import com.bugtracker.entity.ProjectVersion;
//import com.bugtracker.repository.ProjectRepository;
//import com.bugtracker.repository.ProjectVersionRepository;
//import com.bugtracker.service.ProjectService;
//import com.bugtracker.service.ProjectVersionService;
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
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//@DirtiesContext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestDataBaseConfig.class)
//@WebAppConfiguration
//public class ProjectVersionServiceTest {
//
//    @Resource
//    private EntityManagerFactory entityManagerFactory;
//    protected EntityManager entityManager;
//
//    @Resource
//    private ProjectVersionService projectVersionService;
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
//    public void testSaveProjectVersion() throws Exception {
//        ProjectDTO projectDTO = ProjectDTOUtil.createProjectDTO();
//        projectService.addProject(null,projectDTO);
//        ProjectVersionDTO projectVersionDTO = ProjectVersionDTOUtil.createProjectVersionDTO();
//        projectVersionService.addProjectVersion(projectDTO, projectVersionDTO);
//    }
//}
