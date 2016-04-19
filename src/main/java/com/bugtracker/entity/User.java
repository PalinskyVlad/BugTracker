package com.bugtracker.entity;

import com.bugtracker.entity.enums.UserRoleEnum;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    public static final ShaPasswordEncoder SHA_PASSWORD_ENCODER = new ShaPasswordEncoder(512);

    private long id;

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private UserRoleEnum role;

    private String secretCode;

    private boolean confirmed;

    private Set<Issue> issues = new HashSet<Issue>();

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @NotEmpty
    @Column(name = "username", length = 64, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Email
    @NotEmpty
    @Column(name = "email", length = 64, nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    @Column(name = "first_name", length = 64, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty
    @Column(name = "last_name", length = 64, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    @Column(name = "secret_code")
    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    @Column(name = "confirmed")
    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
