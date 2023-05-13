package com.example.sweproject;

import java.time.LocalDate;

public class Match {
    LocalDate myObj;
    Team team1;
    String team1s;
    Team team2;

    public Match(LocalDate myObj, Team team1, Team team2) {
        this.myObj = myObj;
        this.team1 = team1;
        this.team1s = team1.getName();
        this.team2 = team2;
    }

    public String toString() {
        return "the match date " + myObj.toString() + " the team " + team1.toString() + " vs the team "
                + team2.toString();
    }
}
