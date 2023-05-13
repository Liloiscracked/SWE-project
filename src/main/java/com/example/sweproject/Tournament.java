package com.example.sweproject;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.scene.control.Button;


public class Tournament {
    private String name;
    private String type;
    private LinkedList<Team> teams;
    private LinkedList<Match> matches;
    private Games game;
    private transient Button registerButton;
    private transient Button withdrawButton;

    public Tournament(LinkedList<Team> teams, Games game, String type,String name) {
        this.teams = teams;
        this.game = game;
        this.type = type;
        this.name = name;
        this.matches = new LinkedList<>();
        this.registerButton= new Button("Register");
        this.withdrawButton= new Button("Withdraw");
        if (this.type.equals("elimination")) {
            if (teams.size() % 2 == 0) {
                for (int i = 0; i < teams.size() - 1; i = i + 2) {
                    matches.add(new Match(LocalDate.now(), teams.get(i), teams.get(i + 1)));
                }
            } else {
                for (int i = 0; i < teams.size() - 2; i = i + 2) { // add all teams except the last team
                    matches.add(new Match(LocalDate.now(), teams.get(i), teams.get(i + 1)));
                    Collections.shuffle(matches);
                }
            }
        } else {
            for (int j = 0; j < teams.size() - 1; j++) {
                for (int q = j + 1; q < teams.size(); q++)
                    matches.add(new Match(LocalDate.now(), teams.get(j), teams.get(q)));
                Collections.shuffle(matches);
            }
        }

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LinkedList<Team> getTeams() {
        return teams;
    }

    public void setTeams(LinkedList<Team> teams) {
        this.teams = teams;
    }

    public LinkedList<Match> getMatches() {
        return matches;
    }

    public void setMatches(LinkedList<Match> matches) {
        this.matches = matches;
    }

    public Games getGame() {
        return game;
    }

    public String getGameName() {
        return game.toString();
    }
    public void setGame(Games game) {
        this.game = game;
    }

    public void showMatch() {
        for (int i = 0; i < this.getMatches().size(); i++) {
            System.out.println(this.getMatches().get(i).toString());
        }
    }

    public void updateTablepoint(Team team, int point) {
        boolean flag = false;
        if (!this.type.equals("elimination")) {
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
        } else {
            System.out.println("This method is not for elimination tournament");
        }

    }

    public void Modifydataoftournament(String type, Team team, Games game, int choice) {
        if (choice == 1) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the new points");
            int point = input.nextInt();
            this.updateTablepoint(team, point);
        } else if (choice == 2) {
            this.setType(type);
        } else if (choice == 3) {
            for (int i = 0; i < matches.size(); i++) {
                if (matches.get(i).team1.equals(team) || (matches.get(i).team2.equals(team))) {
                    matches.remove(i);
                }
            }
            this.teams.remove(team);
        } else if (choice == 4) {
            this.setGame(game);
        }
    }
    public void addTeam(Team team){
        this.teams.add(team);
    }
    public void removeTeam(Team team){
        this.teams.remove(team);
    }
    public Button getTeam(){
        return registerButton;
    }
    public Button getWithdraw(){
        return withdrawButton;
    }
}
