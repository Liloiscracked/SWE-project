package com.example.sweproject;

import java.util.LinkedList;

public class User {
    String name;
    int ID;
    LinkedList<Tournament> tournament;

    public User(String name, int ID, LinkedList<Tournament> tournament) {
        this.name = name;
        this.ID = ID;
        this.tournament = tournament;
    }
    public boolean isValid(Tournament t){
        return !tournament.contains(t);
    }
}
