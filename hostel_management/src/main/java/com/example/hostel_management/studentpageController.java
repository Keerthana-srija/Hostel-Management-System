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

public class studentpageController {
    @FXML
    private Button exitButton;
    public void exitButtonOnAction(ActionEvent e){
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentlogin.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 520, 400));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private Button viewDetailsButton;
    @FXML
    void viewDetailsButtonOnAction(ActionEvent e){
        Stage stage=(Stage) viewDetailsButton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewpage-student.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 600, 449));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private Button getTokenButton;
    public void getTokenOnAction(ActionEvent e){
        Stage stage=(Stage) getTokenButton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("getToken.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 520, 400));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
