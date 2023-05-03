package com.example.sweproject;
import java.util.LinkedList;
public class Admin {
    String name;
    int ID;

    public Admin(String name) {
        this.name = name;
        this.ID = (int) Math.random() * 100000;
    }
}
