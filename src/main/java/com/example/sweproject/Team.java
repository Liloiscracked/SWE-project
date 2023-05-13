package com.example.sweproject;

import java.util.LinkedList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Team {
    private String name;

    private final SimpleStringProperty name1;
    private SimpleIntegerProperty Point1;

    LinkedList<User> members;
    private int Point;

    Tournament tournament;

    public Team(LinkedList<User> members, String name) {
        this.members = members;
        this.name = name;
        this.name1 = new SimpleStringProperty(name);
        this.Point1 = new SimpleIntegerProperty(Point);
        this.Point = 0;
    }

    public User getUser() {
        return members.getFirst();
    }

    public boolean hasMember(User member) {
        boolean equal = false;
        for (User user : members) {
            if (user.equal(member)) {
                equal = true;
                break;
            }
        }
        return equal;
    }

    public void addMember(User member) {
        members.addLast(member);
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

    public SimpleStringProperty getName1() {
        return name1;
    }

    public SimpleIntegerProperty getPoint1() {
        return Point1;
    }

    public void setPoint1(SimpleIntegerProperty point1) {
        Point1 = point1;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}
