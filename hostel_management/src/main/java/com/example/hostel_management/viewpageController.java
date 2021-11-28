package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

import java.sql.Connection;
import java.util.Objects;

public class viewpageController {
    @FXML
    private Label StudentName;
    @FXML
    private Label RollNo;
    @FXML
    private Label roomNo;
    @FXML
    private Label Course;
    @FXML
    private Label Department;
    @FXML
    private Label PersonalMail;
    @FXML
    private Label OfficialMail;
    @FXML
    private Label StudentMobile;
    @FXML
    private Label Allergies;
    @FXML
    private Label Address;
    @FXML
    private Label BloodGroup;
    @FXML
    private Label FatherName;
    @FXML
    private Label MotherName;
    @FXML
    private Label ParentMobile;
    @FXML
    private Label GuardianName;
    @FXML
    private Label GuardianMobile;
    @FXML
    private Button OK;
    @FXML
    private TextField rollNumberTextField;
    @FXML
    private Button ClickHere;
    public void OKOnAction(ActionEvent e){
        Stage stage=(Stage) OK.getScene().getWindow();
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
    public void ClickHereOnAction(ActionEvent e){
        DatabaseConnection connection=new DatabaseConnection();
        Connection connectDB=connection.getConnection();
        String roll = rollNumberTextField.getText();
        String query="SELECT * from studentDetails WHERE RollNo='"+roll+"'";
        try{
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()) {
                StudentName.setText(rs.getString(1));
                roomNo.setText(rs.getString(2));
                RollNo.setText(rs.getString(3));
                Course.setText(rs.getString(4));
                Department.setText(rs.getString(5));
                PersonalMail.setText(rs.getString(6));
                OfficialMail.setText(rs.getString(7));
                StudentMobile.setText(rs.getString(8));
                Allergies.setText(rs.getString(9));
                Address.setText(rs.getString(10));
                BloodGroup.setText(rs.getString(11));
                FatherName.setText(rs.getString(12));
                MotherName.setText(rs.getString(13));
                ParentMobile.setText(rs.getString(14));
                GuardianName.setText(rs.getString(15));
                GuardianMobile.setText(rs.getString(16));
            }
            rs.close();
            st.close();
            connectDB.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}