package com.bugtracker.logger.impl;

import com.bugtracker.logger.UserActionLogger;
import org.apache.log4j.Logger;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;

@Component
public class UserActionLoggerImpl implements UserActionLogger{
    private static final Logger logger = Logger.getLogger(UserActionLoggerImpl.class);



    @Override
    public void projectAdded(String username, String projectName) {
        MDC.put("username", username);
        logger.info(username + " has created a " + projectName + " project");
    }

    @Override
    public void projectEdited(String username, String projectName) {
        MDC.put("username", username);
        logger.info(username + " has edited a " + projectName + " project");
    }

    @Override
    public void projectDeleted(String username, String projectName) {
        MDC.put("username", username);
        logger.info(username + " has deleted a " + projectName + " project");
    }

    @Override
    public void projectComponentAdded(String username, String projectName, String projectComponentName) {
        MDC.put("username", username);
        logger.info(username + " has added a " + projectComponentName + " component in " + projectName);
    }

    @Override
    public void projectComponentEdited(String username, String projectName, String projectComponentName) {
        MDC.put("username", username);
        logger.info(username + " has edited a " + projectComponentName + " component in " + projectName);
    }

    @Override
    public void projectComponentDeleted(String username, String projectName, String projectComponentName) {
        MDC.put("username", username);
        logger.info(username + " has deleted a " + projectComponentName + " component in " + projectName);

    }

    @Override
    public void projectVersionAdded(String username, String projectName, String projectVersionName) {
        MDC.put("username", username);
        logger.info(username + " has added a " + projectVersionName + " version in " + projectName);

    }

    @Override
    public void projectVersionEdited(String username, String projectName, String projectVersionName) {
        MDC.put("username", username);
        logger.info(username + " has edited a " + projectVersionName + " version in " + projectName);
    }

    @Override
    public void projectVersionDeleted(String username, String projectName, String projectVersionName) {
        MDC.put("username", username);
        logger.info(username + " has deleted a " + projectVersionName + " version in " + projectName);
    }

    @Override
    public void issueAdded(String username, String projectName, String issueName) {
        MDC.put("username", username);
        logger.info(username + " has added a " + issueName + " issue in " + projectName);
    }

    @Override
    public void issueEdited(String username, String projectName, String issueName) {
        MDC.put("username", username);
        logger.info(username + " has edited a " + issueName + " issue in " + projectName);
    }

    @Override
    public void issueDeleted(String username, String projectName, String issueName) {
        MDC.put("username", username);
        logger.info(username + " has deleted a " + issueName + " issue in " + projectName);
    }
}
