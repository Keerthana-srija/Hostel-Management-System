module com.example.hostel_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.java;
    requires java.datatransfer;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    //requires java.desktop;

    opens com.example.hostel_management to javafx.fxml;
    exports com.example.hostel_management;
}