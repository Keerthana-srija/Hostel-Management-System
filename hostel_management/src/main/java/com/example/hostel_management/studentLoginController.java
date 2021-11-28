package com.example.hostel_management;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;
import java.util.Objects;

public class studentLoginController {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField UserNameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button LoginButton;

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        String verifyLogin = "SELECT count(1) FROM studentDetails WHERE RollNo='"+UserNameTextField.getText()+"'and RollNo='"+passwordPasswordField.getText()+"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(verifyLogin);
            while(rs.next()){
                if(rs.getInt(1)==1) {
                    loginMessageLabel.setText("Welcome!!!");
                    Stage stage = (Stage) LoginButton.getScene().getWindow();
                    stage.close();
                    Stage primarystage = new Stage();
                    try {
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentpage.fxml")));
                        primarystage.initStyle(StageStyle.UNDECORATED);
                        primarystage.setScene(new Scene(root, 520, 400));
                        primarystage.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                else
                    loginMessageLabel.setText("Invalid Login");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loginButtonOnAction(ActionEvent e) {
        if (!UserNameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }
}
