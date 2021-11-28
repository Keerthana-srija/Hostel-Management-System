package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class adminPageController {

    @FXML
    private Button att;

    @FXML
    private Button exitButton;

    @FXML
    private Button insertbutton;

    @FXML
    private Button token;

    @FXML
    private Button updatebutton;

    @FXML
    private Button viewDetailsButton;

    @FXML
    void viewDetailsButtonOnAction(ActionEvent e){
        Stage stage=(Stage) viewDetailsButton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 672, 750));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void attOnAction(ActionEvent e){
        Stage stage=(Stage) att.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendance.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 600, 449));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent e){
        Stage stage=(Stage) updatebutton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("updates.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 717, 485));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void insertButtonOnAction(ActionEvent e){
        Stage stage=(Stage) token.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("insert.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 672, 750));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminlogin.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 520, 400));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @FXML
    void tokenbuttonOnAction(ActionEvent event){
        Stage stage=(Stage) token.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admintoken.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 600, 449));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

}