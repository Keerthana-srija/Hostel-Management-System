package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class firstController {

    @FXML
    private RadioButton ahome;

    @FXML
    private RadioButton shome;

    public void ahomeOnAction(ActionEvent e){
        Stage stage=(Stage) ahome.getScene().getWindow();
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
    public void shomeOnAction(ActionEvent e){
        Stage stage=(Stage) ahome.getScene().getWindow();
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

}

