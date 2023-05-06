package com.example.sweproject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Admin {
    String name;
    int ID;
    ArrayList<User> users;

    public Admin(String name) {
        this.name = name;
        this.ID = (int) Math.random() * 100000;
    }

    public void registerStudent(String Name, int id, LinkedList<Tournament> tournament) {
        User user = new User(name, id, tournament);
        users.add(user);

    }
}
