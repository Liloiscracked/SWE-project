package com.example.sweproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    BorderPane rootLayout;
    Stage stage;

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
        Button tour = new Button("creat tournment");

        gridpane.add(tour, 0, 5);
        Scene scene1 = new Scene(gridpane, 400, 250);
        GridPane gridpane2 = new GridPane();
        gridpane2.setAlignment(Pos.CENTER);
        gridpane2.setHgap(10);
        gridpane2.setVgap(10);
        gridpane2.setPadding(new Insets(25, 25, 25, 25));
        Scene scene2 = new Scene(gridpane2, 400, 250);

        // tour.setOnAction(event -> );
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

    }

    void handleLoginButtonAction(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}