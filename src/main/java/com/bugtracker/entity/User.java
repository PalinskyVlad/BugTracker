package com.bugtracker.entity;

import com.bugtracker.entity.enums.UserRoleEnum;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    public static final ShaPasswordEncoder SHA_PASSWORD_ENCODER = new ShaPasswordEncoder(512);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Column(name = "username", length = 32, nullable = false, unique = true)
    private String username;

    @Email
    @NotEmpty
    @Column(name = "email", length = 32, nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "first_name", length = 32, nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", length = 32, nullable = false)
    private String lastName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @Column(name = "secret_code")
    private String secretCode;

    @Column(name = "confirmed")
    private boolean confirmed;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Issue> issues;

    public User() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
