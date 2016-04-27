package com.bugtracker.logger;

public interface UserActionLogger {
    void projectAdded(String username, String projectName);
    void projectEdited(String username, String projectName);
    void projectDeleted(String username, String projectName);
    void projectComponentAdded(String username, String projectName, String projectComponentName);
    void projectComponentEdited(String username, String projectName, String projectComponentName);
    void projectComponentDeleted(String username, String projectName, String projectComponentName);
    void projectVersionAdded(String username, String projectName, String projectVersionName);
    void projectVersionEdited(String username, String projectName, String projectVersionName);
    void projectVersionDeleted(String username, String projectName, String projectVersionName);
    void issueAdded(String username, String projectName, String issueName);
    void issueEdited(String username, String projectName, String issueName);
    void issueDeleted(String username, String projectName, String issueName);

}
