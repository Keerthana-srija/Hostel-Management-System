package com.example.hostel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class adminloginController {
    @FXML
    private Button cancelButton;
    @FXML
    private Button LoginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField UserNameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    public void loginButtonOnAction(ActionEvent e){
        if(!UserNameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        try {
            if (Objects.equals(UserNameTextField.getText(), "admin") && Objects.equals(passwordPasswordField.getText(), "admin")) {
                loginMessageLabel.setText("Welcome!!!");
                Stage stage = (Stage) LoginButton.getScene().getWindow();
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
            else
                loginMessageLabel.setText("Invalid Login");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
