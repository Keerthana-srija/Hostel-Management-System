package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

import java.sql.Connection;

public class studentviewController {
    @FXML
    private Label StudentName;
    @FXML
    private Label RollNo;
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
    private TextField rno;
    @FXML
    private Button ClickHere;
    public void OKOnAction(ActionEvent e){
        Stage stage=(Stage) OK.getScene().getWindow();
        stage.close();
    }
    public void ClickHereOnAction(ActionEvent e){
        DatabaseConnection connection=new DatabaseConnection();
        Connection connectDB=connection.getConnection();
        String query="SELECT * from studentDetails WHERE RollNo='"+rno.getText()+"'";
        try{
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()) {
                StudentName.setText(rs.getString(1));
                RollNo.setText(rs.getString(2));
                Course.setText(rs.getString(3));
                Department.setText(rs.getString(4));
                PersonalMail.setText(rs.getString(5));
                OfficialMail.setText(rs.getString(6));
                StudentMobile.setText(rs.getString(7));
                Allergies.setText(rs.getString(8));
                Address.setText(rs.getString(9));
                BloodGroup.setText(rs.getString(10));
                FatherName.setText(rs.getString(11));
                MotherName.setText(rs.getString(12));
                ParentMobile.setText(rs.getString(13));
                GuardianName.setText(rs.getString(14));
                GuardianMobile.setText(rs.getString(15));
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