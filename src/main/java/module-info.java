module com.example.lomi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.lomi to javafx.fxml;
    exports com.example.lomi;
}