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

public class viewpageStudentController {
    @FXML
    private Label StudentName;
    @FXML
    private Label RollNo;
    @FXML
    private Label Course;
    @FXML
    private Label Department;
    @FXML
    private Label StudentMobile;
    @FXML
    private Label BloodGroup;
    @FXML
    private Label Address;
    @FXML
    private Label ParentMobile;
    @FXML
    private Button OK;
    @FXML
    private TextField rno;
    @FXML
    private Button ClickHere;
    public void OKOnAction(ActionEvent e){
        Stage stage=(Stage) OK.getScene().getWindow();
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
    public void ClickHereOnAction(ActionEvent e){
        DatabaseConnection connection=new DatabaseConnection();
        Connection connectDB=connection.getConnection();
        String query="SELECT * from studentDetails WHERE RollNo='"+rno.getText()+"'";
        try{
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()) {
                StudentName.setText(rs.getString(1));
                RollNo.setText(rs.getString(3));
                Course.setText(rs.getString(4));
                Department.setText(rs.getString(5));
                StudentMobile.setText(rs.getString(8));
                Address.setText(rs.getString(10));
                BloodGroup.setText(rs.getString(11));
                ParentMobile.setText(rs.getString(14));
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