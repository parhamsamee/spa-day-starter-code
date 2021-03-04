package org.launchcode.spaday.models;

import java.util.Date;

public class User {
    //Variables username, email, password
    private int id;
    private static int nextId = 1;

    private String username;
    private String email;
    private String password;
    private final Date joinedDate;


    //Constructors
    public User() {
        id = nextId;
        nextId++;
        this.joinedDate = new Date();
    }

    //Getters && Setters

    public int getId() { return id; }

    public Date getJoinedDate() { return this.joinedDate; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
