package com.example.sweproject;

import java.util.LinkedList;

public class Team {
    String name;
    LinkedList<User> members;
    int Point;
    Tournament tournament;

    public Team(LinkedList<User> members, String name) {
        this.members = members;
        this.name = name;
        this.Point = 0;
    }

    public void addMember(User member) {
        members.add(member);
    }

    public void removeMember(User member) {
        members.remove(member);
    }

    public void setpoint(int point) {
        this.Point = point;

    }

    public void addtournment(Tournament tournament) {
        this.tournament = tournament;
        for (int k = 0; k < members.size(); k++) {
            members.get(k).setTournament(tournament);
        }

    }

    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}
