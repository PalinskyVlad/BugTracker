package com.bugtracker.dto;

import com.bugtracker.entity.Issue;
import com.bugtracker.entity.enums.UserRoleEnum;

import java.util.Set;

/**
 * Created by Vlados on 4/4/2016.
 */
public class UserDTO {
    private long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRoleEnum role;
    private String secretCode;
    private boolean confirmed;
    private Set<Issue> issues;

    public UserDTO(long id, String username, String email, String password, String firstName, String lastName
                                , UserRoleEnum role, String secretCode, boolean confirmed, Set<Issue> issues) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.secretCode = secretCode;
        this.confirmed = confirmed;
        this.issues = issues;
    }

    public UserDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
