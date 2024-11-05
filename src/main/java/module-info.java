module com.example.sistemacaixapontodopovo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens com.example.sistemacaixapontodopovo to javafx.fxml;
    opens util to com.google.gson;
    exports com.example.sistemacaixapontodopovo;
}