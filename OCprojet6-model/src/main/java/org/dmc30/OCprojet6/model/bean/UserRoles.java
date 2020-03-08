package org.dmc30.OCprojet6.model.bean;

public class UserRoles {

    private int id;
    private String username;
    private String userRole;

    public UserRoles(int id, String username, String userRole) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
