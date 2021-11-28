package com.example.hostel_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.io.IOException;

public class firstMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root=FXMLLoader.load(getClass().getResource("student or admin.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login page");
        primaryStage.setScene(new Scene(root,520,400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        firstMain.launch(args);
    }
}