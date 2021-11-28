package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;
import java.util.Objects;


public class admintokenController {

    @FXML
    private Label chicken;

    @FXML
    private Label chickenlabel;

    @FXML
    private Label chilli;

    @FXML
    private Label chillilabel;

    @FXML
    private Button click;

    @FXML
    private TextField date;

    @FXML
    private Label egg;

    @FXML
    private Label egglabel;

    @FXML
    private Button back;

    public void backOnAction(ActionEvent e){
        Stage stage=(Stage) back.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpage.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 600, 449));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void clickOnAction(ActionEvent e) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection con = connection.getConnection();
        int countEggToken = 0;
        String query = "select * from Tokens where Date='"+date.getText()+"' and TokenName='Egg';";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                countEggToken++;
            }
            egglabel.setText(String.valueOf(countEggToken));
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        int countchickToken = 0;
        String query1 = "select * from Tokens where Date='"+date.getText()+"' and TokenName='Chicken' ";
        try {
            PreparedStatement stmt = con.prepareStatement(query1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                countchickToken++;
            }
            chickenlabel.setText(String.valueOf(countchickToken));
        } catch (Exception exc) {
            exc.printStackTrace();

        }
        int countchilliToken = 0;
        String query2 = "select * from Tokens where Date='"+date.getText()+"' and TokenName='Gobi' ";
        try {
            PreparedStatement stmt = con.prepareStatement(query2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                countchilliToken++;
            }
            chillilabel.setText(String.valueOf(countchilliToken));
        } catch (Exception exce) {
            exce.printStackTrace();

        }

    }
}

