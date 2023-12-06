package com.workintech.library;


import java.util.Set;

public class User extends Person {

    private Set<Book> book;


    public User(long id, String name) {
        super(id, name);
    }

}
