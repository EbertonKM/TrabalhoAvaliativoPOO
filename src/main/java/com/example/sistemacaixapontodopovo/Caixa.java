package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Caixa extends Stage {
    public Caixa() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("caixa-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 520);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/style.css")).toExternalForm());
        this.setTitle("Caixa");
        this.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/caixa-icon.png"))));
        this.resizableProperty().setValue(Boolean.FALSE);
        this.setScene(scene);
        this.show();
    }
}
