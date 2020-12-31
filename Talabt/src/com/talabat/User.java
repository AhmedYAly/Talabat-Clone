package com.talabat;

import java.sql.SQLException;

public abstract class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public abstract boolean login(String username, String password) throws SQLException;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
