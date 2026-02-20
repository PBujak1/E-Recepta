module com.example.erecepta {
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.graphics;
    requires java.desktop;

    opens com.example.erecepta to javafx.graphics;
        exports com.example.erecepta;
        }
