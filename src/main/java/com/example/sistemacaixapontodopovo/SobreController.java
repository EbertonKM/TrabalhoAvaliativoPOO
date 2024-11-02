package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;

import javafx. scene. paint. Color;

public class SobreController {

    @FXML
    private Label titulo1;
    @FXML
    private Label titulo2;
    @FXML
    private Label texto1;
    @FXML
    private Label texto2;

    @FXML
    public void initialize() {
        titulo1.setEffect(new DropShadow(50, Color.WHITE));
        titulo2.setEffect(new DropShadow(50, Color.WHITE));
        texto1.setEffect(new DropShadow(50, Color.WHITE));
        texto2.setEffect(new DropShadow(50, Color.WHITE));
    }
}
