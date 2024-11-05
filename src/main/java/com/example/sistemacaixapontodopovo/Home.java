package com.example.sistemacaixapontodopovo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Home extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 580, 265);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/style.css")).toExternalForm());
        stage.setTitle("Supermercado Ponto do Povo");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/home-icon.png"))));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}