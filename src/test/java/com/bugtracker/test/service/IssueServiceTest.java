package com.bugtracker.test.service;

import com.bugtracker.service.IssueService;
import com.bugtracker.test.config.TestDataBaseConfig;
import com.bugtracker.test.util.IssueUtil;
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
public class IssueServiceTest {

    @Resource
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Resource
    private IssueService issueService;

    @Before
    public void setUp() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
    }

  //  @Test
    public void testSaveIssue() throws Exception{
      //  issueService.addIssue(IssueUtil.createIssue());
    }

}
