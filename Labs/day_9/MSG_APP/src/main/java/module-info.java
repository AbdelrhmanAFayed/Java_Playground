module com.mycompany.msg_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.msg_app to javafx.fxml;
    exports com.mycompany.msg_app;
}
