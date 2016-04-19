//package com.bugtracker.test.service;
//
//import com.bugtracker.entity.Project;
//import com.bugtracker.entity.ProjectVersion;
//import com.bugtracker.repository.ProjectRepository;
//import com.bugtracker.repository.ProjectVersionRepository;
//import com.bugtracker.service.ProjectVersionService;
//import com.bugtracker.test.config.TestDataBaseConfig;
//import com.bugtracker.test.util.ProjectComponentUtil;
//import com.bugtracker.test.util.ProjectVersionUtil;
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
//    private ProjectRepository projectRepository;
//
//    @Resource
//    private ProjectVersionRepository versionRepository;
//
//    @Before
//    public void setUp() throws Exception{
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testSaveProjectVersion() throws Exception {
//     //   projectVersionService.addProjectComponent(ProjectVersionUtil.createProjectVersion());
//
//        ProjectVersion projectVersion = new ProjectVersion();
//        projectVersion.setName("core");
//        projectVersion.setDescription("test");
//
//        Project project = new Project();
//        project.setName("Test Project4");
//        project.setAvatar(new byte[20]);
//
//        projectRepository.saveAndFlush(project);
//
//       projectVersion.setProject(project);
//       project.getVersions().add(projectVersion);
//
//
//        versionRepository.saveAndFlush(projectVersion);
//    }
//}
