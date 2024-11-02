package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Sobre extends Stage {
    public Sobre() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("sobre-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 430);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/style.css")).toExternalForm());
        this.setTitle("Sobre o sistema");
        this.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/sobre-icon.png"))));
        this.setScene(scene);
        this.show();
    }
}
