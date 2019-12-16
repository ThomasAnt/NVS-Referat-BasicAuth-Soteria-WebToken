package at.htl.model;

import java.util.HashSet;

public class User {
    String username;
    String password;
    HashSet roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, HashSet roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet getRoles() {
        return roles;
    }

    public void setRoles(HashSet roles) {
        this.roles = roles;
    }
}
