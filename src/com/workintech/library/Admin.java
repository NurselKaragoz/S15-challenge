package com.workintech.library;

public class Admin extends Person{
    private String password;


    public Admin(long id, String name) {
        super(id, name);
    }

    public Admin(long id, String name, String password) {
        super(id, name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "password='" + password + '\'' +
                "} " + super.toString();
    }
}


