package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.*;
import java.util.Objects;

public class updateDetailsController {

        @FXML
        private TextField contactnumber;

        @FXML
        private TextField emailid;

        @FXML
        private TextField guardiannumber;

        @FXML
        private TextField rollnumber;

        @FXML
        private TextField roomnumber;

        @FXML
        private Button updatebutton;
        
        @FXML
        private Button backButton;

        public void backbuttonOnAction(ActionEvent e){
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            Stage primarystage=new Stage();
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpage.fxml")));
                primarystage.initStyle(StageStyle.UNDECORATED);
                primarystage.setScene(new Scene(root, 520, 400));
                primarystage.show();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

        public void updatebuttonOnAction(ActionEvent e) {
            try {
                DatabaseConnection con = new DatabaseConnection();
                Connection connectdb = con.getConnection();
                String rollno = rollnumber.getText();
                String roomno = roomnumber.getText();
                String guarno = guardiannumber.getText();
                String contactno = contactnumber.getText();
                String email = emailid.getText();
                String query = "update studentDetails SET RoomNo=?, GaurdianMobile=?, StudentMobile=?, PersonalMail =? where RollNo=?";
                PreparedStatement pst = connectdb.prepareStatement(query);
                pst.setString(1, roomno);
                pst.setString(2, guarno);
                pst.setString(3, contactno);
                pst.setString(4, email);
                pst.setString(5, rollno);
                int i = pst.executeUpdate();

                pst.close();
                connectdb.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }



