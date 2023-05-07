package com.example.sweproject;

import java.util.LinkedList;

public class Team {
    LinkedList<User> members;
    int Point;
    Tournament tournament;

    public Team(LinkedList<User> members) {
        this.members = members;
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
    public void addtournment(Tournament tournament){
        this.tournament=tournament;
    }
}
