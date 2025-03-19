module com.mycompany.db {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires derbyclient;

    opens com.mycompany.db to javafx.fxml;
    exports com.mycompany.db;
}
