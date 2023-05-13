package com.example.sweproject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Admin {
    private String name;
    private int ID;
    private ArrayList<User> users;
    private ArrayList<Tournament> tournments;

    public Admin(String name) {
        this.name = name;
        this.ID = (int) Math.random() * 100000;
        this.users= new ArrayList<>();
        this.tournments= new ArrayList<>();
    }
    public ArrayList<Tournament> returnTournaments(){
        return tournments;
    }
    public void registerStudent(String Name, int id, Tournament tournament) {
        User user = new User(name, id);
        user.addtournment(tournament);
        users.add(user);

    }

    public boolean tournamentsExist(){
        return tournments.isEmpty();
    }

    public void createtournment(LinkedList<Team> teams, Games game, String type, String name) {
        tournments.add(new Tournament(teams, game, type, name));
    }

    public void removetournment(Tournament t) {
        tournments.remove(t);
    }
}
