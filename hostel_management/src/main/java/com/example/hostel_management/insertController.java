package com.example.hostel_management;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;
import java.net.URL;
import java.util.Objects;

public class insertController {
    @FXML
    private TextField StudentName;
    @FXML
    private TextField RollNo;
    @FXML
    private TextField Course;
    @FXML
    private TextField RoomNo;
    @FXML
    private TextField Department;
    @FXML
    private TextField PersonalMail;
    @FXML
    private TextField OfficialMail;
    @FXML
    private TextField StudentMobile;
    @FXML
    private TextField Allergies;
    @FXML
    private TextField Address;
    @FXML
    private TextField BloodGroup;
    @FXML
    private TextField FatherName;
    @FXML
    private TextField MotherName;
    @FXML
    private TextField ParentMobile;
    @FXML
    private TextField GuardianName;
    @FXML
    private TextField GuardianMobile;
    @FXML
    private Button Ok;
    @FXML
    private Button cancelButton;
    @FXML
    private Label insertMessage;
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
        Stage primarystage = new Stage();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpage.fxml")));
            primarystage.initStyle(StageStyle.UNDECORATED);
            primarystage.setScene(new Scene(root, 600, 449));
            primarystage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void OkOnAction(ActionEvent e){
        if(!StudentName.getText().isBlank()  && !RoomNo.getText().isBlank() &&!RollNo.getText().isBlank() &&!Course.getText().isBlank() &&!Department.getText().isBlank() &&!PersonalMail.getText().isBlank() &&!OfficialMail.getText().isBlank() &&
                !StudentMobile.getText().isBlank() &&!Allergies.getText().isBlank() &&!Address.getText().isBlank() &&!BloodGroup.getText().isBlank() &&!FatherName.getText().isBlank() &&
                !MotherName.getText().isBlank() &&!ParentMobile.getText().isBlank() &&!GuardianName.getText().isBlank() &&!GuardianMobile.getText().isBlank()){
             validateInsert();
        }
        else{
            insertMessage.setText("Enter the student details");
        }
    }
    public void validateInsert(){
        DatabaseConnection connection=new DatabaseConnection();
        Connection connectDB=connection.getConnection();
       String query="insert into studentDetails (StudentName,RoomNo,RollNo,Course,Department,PersonalMail,OfficialMail,StudentMobile,Allergies,Address,BloodGroup,FatherName,MotherName,ParentMobile,GaurdianName,GaurdianMobile) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connectDB.prepareStatement(query);
            String sn=StudentName.getText();
            String ro=RoomNo.getText();
            String rn=RollNo.getText();
            String co=Course.getText();
            String dp=Department.getText();
            String pm=PersonalMail.getText();
            String om=OfficialMail.getText();
            String sm=StudentMobile.getText();
            String al=Allergies.getText();
            String ad=Address.getText();
            String bg=BloodGroup.getText();
            String fn=FatherName.getText();
            String mn=MotherName.getText();
            String pam=ParentMobile.getText();
            String gn=GuardianName.getText();
            String gm=GuardianMobile.getText();
            st.setString(1,sn);
            st.setString(2,ro);
            st.setString(3,rn);
            st.setString(4,co);
            st.setString(5,dp);
            st.setString(6,pm);
            st.setString(7,om);
            st.setString(8,sm);
            st.setString(9,al);
            st.setString(10,ad);
            st.setString(11,bg);
            st.setString(12,fn);
            st.setString(13,mn);
            st.setString(14,pam);
            st.setString(15,gn);
            st.setString(16,gm);
            st.executeUpdate();
            insertMessage.setText("Student Details added successfully");
            st.close();
            connectDB.close();
        }
        catch(SQLIntegrityConstraintViolationException sql){
            insertMessage.setText("Student Details already exists");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
