package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

public class attendanceController {

    @FXML
    private TextField attendance;

    @FXML
    private Button back;

    public void backOnAction(ActionEvent e) {
        Stage stage = (Stage) back.getScene().getWindow();
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

    @FXML
    private TextField date;

    @FXML
    private TextField rno;

    @FXML
    private TextField ron;


    @FXML
    public void ok(ActionEvent event){
        DatabaseConnection connection=new DatabaseConnection();
        Connection con=connection.getConnection();
        String query="insert into Attendance (Date,RoomNo,RollNo,AttendanceStatus) values(?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            String dt = date.getText();
            String ro = ron.getText();
            String rn = rno.getText();
            String a=attendance.getText();
            st.setString(1, dt);
            st.setString(2, ro);
            st.setString(3, rn);
            st.setString(4,a);
            st.executeUpdate();
            }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}