module com.example.sistemacaixapontodopovo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sistemacaixapontodopovo to javafx.fxml;
    exports com.example.sistemacaixapontodopovo;
}