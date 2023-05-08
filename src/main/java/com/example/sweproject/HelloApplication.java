package com.example.sweproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label titleLabel;
        Label errorLabel;
        TextField usernameField;
        PasswordField passwordField;
        Button loginButton;
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(25, 25, 25, 25));
        Scene scene1 = new Scene(gridpane, 400, 250);

        // Set up the login form
        titleLabel = new Label("Login Page");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        usernameField = new TextField();
        usernameField.setPromptText("Username");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        loginButton = new Button("Login");
        loginButton.setOnAction(event -> handleLoginButtonAction(stage, scene1));

        // Set up the GridPane layout for the login form
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(usernameField, 0, 1);
        gridPane.add(passwordField, 0, 2);
        gridPane.add(loginButton, 0, 3);
        gridPane.add(errorLabel, 0, 4);

        // Create the Scene and set it to the Stage
        Scene scene = new Scene(gridPane, 400, 250);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        User u1 = new User("momo", 000);
        User u2 = new User("momom", 0000);
        LinkedList<User> members = new LinkedList<>();
        LinkedList<User> members2 = new LinkedList<>();
        members.add(0, u2);
        members2.add(0, u1);
        Team team1 = new Team(members, "team1");
        Team team2 = new Team(members2, "team2");
        LinkedList<Team> teams = new LinkedList<>();
        teams.add(team2);
        teams.add(team1);
        Games foot = new Games("football");
        Tournament t = new Tournament(teams, foot, "elimination");
        LinkedList<Match> matches = t.getMatches();

        // Create a new VBox to hold the matches
        VBox matchContainer = new VBox();

        // Loop through the matches and create a label for each one
        for (Match match : matches) {
            Label matchLabel = new Label(match.team1 + " vs " + match.team2 + ": " + match.myObj);
            matchContainer.getChildren().add(matchLabel);
        }
        Button showmatch = new Button("showmatch");
        gridPane.add(showmatch, 0, 5);

        // Add the VBox to a ScrollPane to enable scrolling
        ScrollPane scrollPane = new ScrollPane(matchContainer);

        // Create a new Scene with the ScrollPane as the root node
        Scene scene2 = new Scene(scrollPane, 400, 400);

        // Create a new Stage and set the Scene
        Stage stage1 = new Stage();
        stage1.setTitle("matchs");
        stage1.setScene(scene2);
        showmatch.setOnAction(event -> handleLoginButtonAction(stage1, scene2));
    }

    public void displayMatches() {

    }

    void handleLoginButtonAction(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}