package com.webnote.Model.Database;

public class Customer {
    private String username;
    private String password;
    private String name;
    private String password2;

    public Customer() {
    }

    public Customer(String username, String password, String name, String password2) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.password2 = password2;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
