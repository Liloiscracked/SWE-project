package com.example.sweproject;
import java.time.LocalDate;
public class Match {
    LocalDate myObj;
    Team team1;
    Team team2;

    public Match(LocalDate myObj, Team team1, Team team2) {
        this.myObj = myObj;
        this.team1 = team1;
        this.team2 = team2;
    }
}
