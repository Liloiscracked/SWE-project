package com.example.sweproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    TableView<Tournament> table = new TableView<>();
    ObservableList<Tournament> list = FXCollections.observableArrayList();
    boolean student = false;
    Admin admin = new Admin("MasterAdmin");
    User user = new User("temp");
    LinkedList<Team> teams = new LinkedList<>();
    BorderPane rootLayout;
    static Stage stage;

    public void start(Stage stage) throws Exception {
        TableColumn<Tournament, String> nameColumn = new TableColumn<>("Tournament Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Tournament, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));

        TableColumn<Tournament, String> gameColumn = new TableColumn<>("Game");
        gameColumn.setMinWidth(100);
        gameColumn.setCellValueFactory(new PropertyValueFactory<>("GameName"));

        TableColumn<Tournament, Button> registerColumn = new TableColumn<>("Register");
        registerColumn.setMinWidth(100);
        registerColumn.setCellValueFactory(new PropertyValueFactory<>("Team"));

        TableColumn<Tournament, Button> withdrawColumn = new TableColumn<>("Withdraw");
        withdrawColumn.setMinWidth(100);
        withdrawColumn.setCellValueFactory(new PropertyValueFactory<>("Withdraw"));

        TableColumn<Tournament, Button> showmatch = new TableColumn<>("Showmatch");
        showmatch.setMinWidth(100);
        showmatch.setCellValueFactory(new PropertyValueFactory<>("Showmatch"));

        TableColumn<Tournament, Button> showtable = new TableColumn<>("showtable");
        showtable.setMinWidth(100);
        showtable.setCellValueFactory(new PropertyValueFactory<>("showtable"));

        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(nameColumn, typeColumn, gameColumn, registerColumn, withdrawColumn, showmatch,
                showtable);
        table.setItems(list);

        Label titleLabel;
        Label errorLabel;
        Button loginButton = new Button("Login");
        Button logoutButton = new Button("Logout");
        Button logoutButton2 = new Button("Logout");
        Button logoutButton3 = new Button("Logout");
        Button viewButton = new Button("View Tournments");
        Button viewButton2 = new Button("View Tournments");
        Popup popup = new Popup();
        popup.setAutoHide(true);
        TextField usernameField = new TextField();
        TextField passwordField = new PasswordField();
        GridPane gridpane = new GridPane();

        Label titleLabel2 = new Label("Admin Page");
        titleLabel2.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        TextField gameField = new TextField();
        gameField.setPromptText("Specify type of game");
        TextField typeField = new TextField();
        typeField.setPromptText("Specify type of tournament (elimination or round-robin)");
        TextField nameField = new TextField();
        nameField.setPromptText("Specify name of the tournament");

        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(25, 25, 25, 25));

        Button create = new Button("Create Tournment");
        create.setOnMouseClicked(event -> {
            handleTourButtonAction(gameField, typeField, nameField, popup);
        });

        gridpane.add(titleLabel2, 0, 0, 2, 1);
        gridpane.add(gameField, 0, 1);
        gridpane.add(typeField, 0, 2);
        gridpane.add(nameField, 0, 3);
        gridpane.add(create, 0, 5);
        gridpane.add(viewButton2, 5, 5);
        gridpane.add(logoutButton, 5, 0);
        Scene adminView = new Scene(gridpane, 600, 450);

        Label titleLabel3 = new Label("Student Page");
        titleLabel3.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        TextField teamNameField = new TextField();
        teamNameField.setPromptText("Specify the name of your team");
        TextField memberField = new TextField();
        memberField.setPromptText("Specify member to add to your team");
        Button teamButton = new Button("Add members to your team");

        GridPane gridpane2 = new GridPane();
        gridpane2.setAlignment(Pos.CENTER);
        gridpane2.setHgap(10);
        gridpane2.setVgap(10);
        gridpane2.setPadding(new Insets(25, 25, 25, 25));

        gridpane2.add(titleLabel3, 0, 0, 2, 1);
        gridpane2.add(teamButton, 0, 5);
        gridpane2.add(viewButton, 3, 5);
        gridpane2.add(teamNameField, 0, 1);
        gridpane2.add(memberField, 0, 2);
        gridpane2.add(logoutButton2, 10, 0);
        Scene studentView = new Scene(gridpane2, 600, 450);
        teamButton.setOnMouseClicked(event -> {
            Team team = new Team(new LinkedList<>(), "temp");
            handleteamButtonAction(team, teamNameField, memberField, user, popup);
        });

        // tour.setOnAction(event -> );
        // Set up the login form
        titleLabel = new Label("Login Page");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        usernameField.setPromptText("Username");
        passwordField.setPromptText("Password");

        // Set up the GridPane layout for the login form
        GridPane gridPane3 = new GridPane();
        gridPane3.setAlignment(Pos.CENTER);
        gridPane3.setHgap(10);
        gridPane3.setVgap(10);
        gridPane3.setPadding(new Insets(25, 25, 25, 25));
        gridPane3.add(titleLabel, 0, 0, 2, 1);
        gridPane3.add(usernameField, 0, 1);
        gridPane3.add(passwordField, 0, 2);
        gridPane3.add(loginButton, 0, 3);
        gridPane3.add(errorLabel, 0, 4);

        // Create the Scene and set it to the Stage
        Scene scene = new Scene(gridPane3, 600, 450);
        HelloApplication.stage = stage;
        loginButton.setOnMouseClicked(event -> {
            try {
                handleLoginButtonAction(usernameField, passwordField, adminView, studentView);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.getMessage();
            }
        });
        logoutButton.setOnMouseClicked(event -> {
            handleLogoutButtonAction(scene);
        });
        logoutButton2.setOnMouseClicked(event -> {
            handleLogoutButtonAction(scene);
        });

        Button returnButton = new Button("Return to previous screen");
        GridPane gridpane4 = new GridPane();
        gridpane4.setAlignment(Pos.CENTER);
        gridpane4.setHgap(10);
        gridpane4.setVgap(10);
        gridpane4.setPadding(new Insets(25, 25, 25, 25));
        gridpane4.add(returnButton, 0, 4);
        gridpane4.add(table, 0, 0);
        Scene tournamentView = new Scene(gridpane4, 600, 450);

        viewButton.setOnMouseClicked(event -> {
            handleViewButtonAction(tournamentView, popup);
        });
        viewButton2.setOnMouseClicked(event -> {
            handleViewButtonAction(tournamentView, popup);
        });
        returnButton.setOnMouseClicked(event -> {
            handleReturnButtonAction(student, studentView, adminView);
        });
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    public void handleteamButtonAction(Team team, TextField name, TextField member, User user, Popup popup) {
        if (name.getText().isEmpty() || member.getText().isEmpty()) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("One or more of the feilds is empty");
            errorAlert.showAndWait();
            return;
        }

        boolean condition = false;
        for (Team ele : teams) {
            if (ele.toString().equals(name.getText())) {
                if (!ele.getUser().equal(user)) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText(
                            "There is already a team with the same name (Only the person who created the team may add to the team)");
                    errorAlert.showAndWait();
                    return;
                } else if (ele.hasMember(new User(member.getText()))) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("The person your trying to add is already part of your team");
                    errorAlert.showAndWait();
                    return;
                }
                team = ele;
                condition = true;
            } else if (ele.hasMember(user)) {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("You are already part of a diffrent team");
                errorAlert.showAndWait();
                return;
            } else if (ele.hasMember(new User(member.getText()))) {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("The person your trying to add is already part of a diffrent team");
                errorAlert.showAndWait();
                return;
            }
        }
        if (!condition) {
            team = new Team(new LinkedList<User>(), name.getText());
            team.addMember(user);
            team.addMember(new User(member.getText()));
            teams.add(team);
            popup.getContent().clear();
            popup.getContent().add(new Label("Team successfully created"));
        } else {
            System.out.println(teams.indexOf(team));
            teams.get(teams.indexOf(team)).addMember(new User(member.getText()));
            popup.getContent().clear();
            popup.getContent().add(new Label("New team member succefully added"));
        }
        if (!popup.isShowing()) {
            popup.show(stage);
        }
    }

    public void handleWithdraw(Tournament tourny, boolean student, Popup popup) {
        if (!student) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("Can not register/withdraw for a tournament as an admin");
            errorAlert.showAndWait();
        } else {
            LinkedList<Team> temp = tourny.getTeams();
            for (Team team_ : temp) {
                if (team_.hasMember(user)) {
                    tourny.removeTeam(team_);
                    popup.getContent().clear();
                    popup.getContent().add(new Label("Team successfully withdrawn from the tournament"));
                    if (!popup.isShowing()) {
                        popup.show(stage);
                    }
                    return;
                }
            }
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("You are not registered in this tournament");
            errorAlert.showAndWait();
        }
    }

    public void handle(Tournament tourny, Scene scene) {
        ArrayList<Label> lables = new ArrayList<>();
        LinkedList<Match> temp = tourny.getMatches();
        for (int i = 0; i < temp.size() - 1; i++) {
            Label l1 = new Label(temp.get(i).toString());
            lables.add(l1);
        }
        // TableView table = new TableView();
        // TableColumn gameColumn = new TableColumn();
        // gameColumn.setCellValueFactory(new PropertyValueFactory<>("team1s"));
        // gameColumn.setMinWidth(1000);
        // gameColumn.setText("Match");
        // table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        // table.getColumns().add(gameColumn);
        // ObservableList<String> list = FXCollections.observableArrayList();
        // list.addAll(temp.toString());
        // table.getItems().add(list.toString());
        // table.getItems().add(temp.get(0));
        GridPane gridpane5 = new GridPane();
        Button returnButton = new Button("Return to previous screen");
        gridpane5.setAlignment(Pos.CENTER);
        gridpane5.setHgap(10);
        gridpane5.setVgap(10);
        gridpane5.setPadding(new Insets(25, 25, 25, 25));
        gridpane5.add(returnButton, 0, 4);
        VBox v = new VBox();
        v.getChildren().addAll(lables);
        // for(int i = 0 ; i<lables.size();i++){

        // }
        gridpane5.add(v, 0, 0);
        Scene showView1 = new Scene(gridpane5, 600, 450);

        returnButton.setOnMouseClicked(event -> {
            handleReturnButtonAction(scene);
        });

        stage.setScene(showView1);
        stage.setTitle("Matches");
    }

    public void handle2(Tournament tourny, Scene scene) {
        ArrayList<Label> lables = new ArrayList<>();
        LinkedList<Match> temp = tourny.getMatches();
        for (int i = 0; i < temp.size() - 1; i++) {
            Label l1 = new Label(temp.get(i).toString());
            lables.add(l1);
        }
        TableView<Team> table = new TableView();
        TableColumn gameColumn = new TableColumn();
        TableColumn gameColumn2 = new TableColumn();
        gameColumn.setCellValueFactory(new PropertyValueFactory<Team, Integer>("Point"));
        gameColumn2.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
        gameColumn.setMinWidth(100);
        gameColumn.setText("Table point");
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.getColumns().add(gameColumn);
        table.getColumns().add(gameColumn2);
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(temp.toString());
        for (int i = 0; i < tourny.getTeams().size(); i++) {
            table.getItems().add(tourny.getTeams().get(i));
        }
        GridPane gridpane6 = new GridPane();
        Button returnButton = new Button("Return to previous screen");
        gridpane6.setAlignment(Pos.CENTER);
        gridpane6.setHgap(10);
        gridpane6.setVgap(10);
        gridpane6.setPadding(new Insets(25, 25, 25, 25));
        gridpane6.add(returnButton, 0, 4);
        gridpane6.add(table, 0, 0);
        // VBox v = new VBox();
        // v.getChildren().addAll(lables);
        // // for(int i = 0 ; i<lables.size();i++){

        // // }
        // gridpane6.add(v, 0, 0);
        Scene showView2 = new Scene(gridpane6, 600, 450);

        returnButton.setOnMouseClicked(event -> {
            handleReturnButtonAction(scene);
        });

        stage.setScene(showView2);
        stage.setTitle("table");
    }

    public void handleRegister(Tournament tourny, boolean student, Popup popup) {
        if (!student) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("Can not register/withdraw for a tournament as an admin");
            errorAlert.showAndWait();
        } else {
            LinkedList<Team> temp = tourny.getTeams();
            for (Team team_ : temp) {
                if (team_.hasMember(user)) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Error!");
                    errorAlert.setContentText("Your team is already registered for this tournament");
                    errorAlert.showAndWait();
                    return;
                }
            }
            for (Team team : teams) {
                if (team.hasMember(user)) {
                    tourny.addTeam(team);
                    popup.getContent().clear();
                    popup.getContent().add(new Label("Team successfully registered"));
                    if (!popup.isShowing()) {
                        popup.show(stage);
                    }
                    return;
                }
            }
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("You must make a team in order to join this tournament");
            errorAlert.showAndWait();
        }
    }

    public void handleViewButtonAction(Scene tournamentView, Popup popup) {
        if (admin.tournamentsExist()) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("There are no Tournaments availaible to view");
            errorAlert.showAndWait();
            return;
        }
        list.clear();
        ArrayList<Tournament> temp = admin.returnTournaments();
        for (Tournament tourny : temp) {
            tourny.getTeam().setOnMouseClicked(event -> {
                handleRegister(tourny, student, popup);
            });
            tourny.getWithdraw().setOnMouseClicked(event -> {
                handleWithdraw(tourny, student, popup);
            });

            tourny.getShowmatch().setOnMouseClicked(event -> {
                handle(tourny, tournamentView);
            });
            tourny.getShowtable().setOnMouseClicked(event -> {
                handle2(tourny, tournamentView);
            });
            list.add(tourny);
        }
        ;
        stage.setScene(tournamentView);
        stage.setTitle("Tournaments");
    }

    public void handleReturnButtonAction(boolean student, Scene studentView, Scene adminView) {
        if (student) {
            stage.setTitle("Student view");
            stage.setScene(studentView);
        } else {
            stage.setTitle("Admin view");
            stage.setScene(adminView);
        }
    }

    public void handleReturnButtonAction(Scene studentView) {
        stage.setTitle("Tournaments");
        stage.setScene(studentView);

    }

    public void handleLogoutButtonAction(Scene loginScene) {
        stage.setScene(loginScene);
        stage.setTitle("Login");
    }

    public void handleTourButtonAction(TextField game, TextField type, TextField name, Popup popup) {
        if (game.getText().isEmpty() || type.getText().isEmpty() || name.getText().isEmpty()) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("One or more of the feilds is empty");
            errorAlert.showAndWait();
        } else if (!type.getText().equals("round-robin") && !type.getText().equals("elimination")) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("'Type' must be either (elimination) or (round-robin)");
            errorAlert.showAndWait();
        } else {
            ArrayList<Tournament> temp = admin.returnTournaments();
            for (Tournament tourny : temp) {
                if (name.getText().equals(tourny.getName())) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("A tournament with the same name already exists");
                    errorAlert.showAndWait();
                    return;
                }
            }
            admin.createtournment(new LinkedList<Team>(), new Games(game.getText()), type.getText(), name.getText());
            popup.getContent().clear();
            popup.getContent().add(new Label("Tournament Created successfully"));
            if (!popup.isShowing()) {
                popup.show(stage);
            }

        }
    }

    public void handleLoginButtonAction(TextField username, TextField password, Scene adminScene, Scene studentScene)
            throws Exception {
        String String = "https://us-central1-swe206-221.cloudfunctions.net/app/UserSignIn?username="
                + username.getText() + "&password=" + password.getText();
        URL url = (new URI(String)).toURL();
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
        req.setRequestMethod("GET"); // specify the request type
        req.setConnectTimeout(5000);
        req.setReadTimeout(5000);
        int status = req.getResponseCode();

        if (status != 200) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("The userName or password is incorrect");
            errorAlert.showAndWait();
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            if (content.toString().contains("student")) {
                student = true;
                String[] temp = content.toString().split(",");
                user = new User(
                        temp[1].substring(1, temp[1].length() - 1) + " " + temp[0].substring(9, temp[0].length()));
                stage.setTitle("Student view");
                stage.setScene(studentScene);
            } else {
                student = false;
                stage.setTitle("Admin view");
                stage.setScene(adminScene);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}
