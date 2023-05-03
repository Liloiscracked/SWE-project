package com.example.sweproject;

import java.util.LinkedList;

public class Team {
    LinkedList<User> members;

    public Team(LinkedList<User> members) {
        this.members = members;
    }

    public void addMember(User member){
        members.add(member);
    }
    public void removeMember(User member){
        members.remove(member);
    }
}
