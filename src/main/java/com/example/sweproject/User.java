package com.example.sweproject;

import java.util.LinkedList;
import java.util.Random;

public class User {
    private String name;
    private int ID;

    LinkedList<Tournament> tournament;

    public User(String name) {
        this.name = name;
        this.ID = new Random().nextInt(200000000,999999999);
    }

    public User(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }
    public boolean equal(User user){
        return name.equals(user.name);
    }

    public boolean isValid(Tournament t) {
        return !tournament.contains(t);
    }

    public void addtournment(Tournament t) {
        this.tournament.add(t);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getID() {
        return ID;
    }

    public LinkedList<Tournament> getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament.add(tournament);
    }

    public void showuser(User user) {
        System.out.println("the ID " + user.getID());
        System.out.println("the name " + user.getName());
        System.out.println("the tournments " + user.getTournament().toString());
    }
}
