package com.example.sweproject;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

public class Tournament {
    String type;
    LinkedList<Team> teams;
    LinkedList<Match> matches;
    Games game;

    public Tournament(LinkedList<Team> teams, Games game,String type) {
        this.teams = teams;
        this.game = game;
        this.type = type;
        for(int i =0;i<teams.size();i++){
            for(int k =0 ; k<teams.get(i).members.size();k++){
                teams.get(i).members.get(k).setTournament(this.);
            }
        }
        if(this.type.equals("elimination")){
            if(teams.size()%2 == 0){
                for(int i = 0;i< teams.size()-1;i = i+2){
                    matches.add(new Match(LocalDate.now(),teams.get(i),teams.get(i+1)));
                }
            }
            else{
                for(int i = 0;i< teams.size()-2;i = i+2){ // add all teams except the last team
                    matches.add(new Match(LocalDate.now(),teams.get(i),teams.get(i+1)));
                    Collections.shuffle(matches);
                }
            }
        }
        else{
            for(int j =0 ; j<teams.size()-1;j++){
                for(int q = j+1;q<teams.size();q++)
                    matches.add(new Match(LocalDate.now(),teams.get(j),teams.get(q)));
                Collections.shuffle(matches);
            }
        }


    }

    public void updateTablepoint(Team team, int point) {
        boolean flag = false;
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).equals(team)) {
                if (point >= 0) {
                    teams.get(i).setpoint(point);
                    flag = true;
                } else {
                    System.out.println("Point is invalid");
                }
            }
        }
        if (flag == false) {
            System.out.println("Team is not found");
        }

    }
}
