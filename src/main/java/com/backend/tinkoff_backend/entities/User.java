package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "spr_user")
public class User implements UserDetails {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "login", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @JoinColumn(name = "employer_id", referencedColumnName = "id",unique = true)
    private long employer_id;

    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private long employee_id;

    public User(){}

    public User(String username, String password, long employer_id, long employee_id) {
        this.username = username;
        this.password = password;
        this.employer_id = employer_id;
        this.employee_id = employee_id;
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.employer_id = user.getEmployer_id();
        this.employee_id = user.getEmployee_id();
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(long employer_id) {
        this.employer_id = employer_id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employer_id=" + employer_id +
                ", employee_id=" + employee_id +
                '}';
    }
}
