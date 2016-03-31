package com.bugtracker.test.service;

import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.service.ProjectVersionService;
import com.bugtracker.test.config.TestDataBaseConfig;
import com.bugtracker.test.util.ProjectComponentUtil;
import com.bugtracker.test.util.ProjectVersionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Vlados on 16.03.2016.

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
 */
public class ProjectVersionServiceTest {

    @Resource
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Resource
    private ProjectVersionService projectVersionService;

    @Before
    public void setUp() throws Exception{
        entityManager = entityManagerFactory.createEntityManager();
    }

  //  @Test
    public void testSaveProjectVersion() throws Exception {
     //   projectVersionService.addProjectComponent(ProjectVersionUtil.createProjectVersion());
    }
}
