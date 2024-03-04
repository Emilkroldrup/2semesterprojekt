module com.example.semesterprojekt2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.semesterprojekt2 to javafx.fxml;
    opens com.example.semesterprojekt2.ui.OpretBruger to javafx.fxml; // Add this line
    exports com.example.semesterprojekt2;
    exports com.example.semesterprojekt2.ui.login;
    opens com.example.semesterprojekt2.ui.login to javafx.fxml;
    exports com.example.semesterprojekt2.ui.StartScreen;
    opens com.example.semesterprojekt2.ui.StartScreen to javafx.fxml;
    exports com.example.semesterprojekt2.ui.appointment;
    opens com.example.semesterprojekt2.ui.appointment to javafx.fxml;
}