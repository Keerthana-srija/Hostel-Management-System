package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;


public class studentTokenController {
    int chicken=0,chilliGobi=0,egg=0;
    @FXML
    private Button exitButton;
    @FXML
    private Button submitButton;
    @FXML
    private Label submitMessageLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField rollNoTextField;
    @FXML
    private CheckBox chickenToken;
    @FXML
    private CheckBox chilliGobiToken;
    @FXML
    private CheckBox eggToken;

    public void exitButtonOnAction(ActionEvent e){
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentpage.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 520, 400));
            primarystage.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void submitButtonOnAction(ActionEvent e){
        Stage stage = (Stage)submitButton.getScene().getWindow();
        String name = nameTextField.getText();
        String rollNo = rollNoTextField.getText();
        String date = dateTextField.getText();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        String query1 = "";
        String query2 = "";
        String query3 = "";
        if(chickenToken.isSelected() && chicken==0 && chilliGobiToken.isSelected() && chilliGobi==0 && eggToken.isSelected() && egg==0) {
            submitMessageLabel.setText("Your chicken, chilli gobi and egg token have been booked");
            query1 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Egg')";
            query2 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Chicken')";
            query3 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Gobi')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query1);
                st.executeUpdate();
                PreparedStatement st1 = connectDB.prepareStatement(query2);
                st1.executeUpdate();
                PreparedStatement st2 = connectDB.prepareStatement(query3);
                st2.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            chicken=1;
            chilliGobi=1;
            egg=1;
        }
        else if(chickenToken.isSelected() && chicken==0 && chilliGobiToken.isSelected() && chilliGobi==0) {
            submitMessageLabel.setText("Your chicken and chilli gobi token have been booked");
            query2 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Chicken')";
            query3 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Gobi')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query2);
                st.executeUpdate();
                PreparedStatement st1 = connectDB.prepareStatement(query3);
                st1.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            chicken=1;
            chilliGobi=1;
        }
        else if(chickenToken.isSelected() && chicken==0 && eggToken.isSelected() && egg==0) {
            submitMessageLabel.setText("Your chicken and egg token have been booked");
            query1 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Egg')";
            query2 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Chicken')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query1);
                st.executeUpdate();
                PreparedStatement st1 = connectDB.prepareStatement(query2);
                st1.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            chicken=1;
            egg=1;
        }
        else if(eggToken.isSelected() && egg==0 && chilliGobiToken.isSelected() && chilliGobi==0) {
            submitMessageLabel.setText("Your chilli gobi and egg token have been booked");
            query1 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Egg')";
            query3 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Gobi')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query1);
                st.executeUpdate();
                PreparedStatement st1 = connectDB.prepareStatement(query3);
                st1.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            egg=1;
            chilliGobi=1;
        }
        else if(chickenToken.isSelected() && chicken==0) {
            submitMessageLabel.setText("Your chicken token has been booked");
            query2 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Chicken')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query2);
                st.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            chicken=1;
        }
        else if(chilliGobiToken.isSelected() && chilliGobi==0){
            submitMessageLabel.setText("Your chilli gobi token has been booked");
            query3 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Gobi')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query3);
                st.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            chilliGobi=1;
        }
        else if(eggToken.isSelected() && egg==0){
            submitMessageLabel.setText("Your egg token has been booked");
            query1 = "insert into Tokens(Date,RollNo,StudName,TokenName)values ('"+date+"','"+rollNo+"','"+name+"','Egg')";
            try {
                PreparedStatement st = connectDB.prepareStatement(query1);
                st.executeUpdate();
            }
            catch(Exception me){
                me.printStackTrace();
            }
            egg=1;
        }
    }
}
