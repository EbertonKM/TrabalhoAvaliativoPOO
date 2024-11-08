package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VerificarProduto extends Stage {
    public VerificarProduto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("verificarproduto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 225);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/style.css")).toExternalForm());
        this.setTitle("Verificação de produtos");
        this.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/verificarproduto-icon.png"))));
        this.resizableProperty().setValue(Boolean.FALSE);
        this.setScene(scene);
        this.show();
    }
}
