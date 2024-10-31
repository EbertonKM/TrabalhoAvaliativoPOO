package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class HomeController {

    @FXML
    private ImageView imgView;

    @FXML
    protected void img(){
        Image image = new Image("img/pontoDoPovoLogo-GeradaPorIA.jpg");
        imgView.setImage(image);
    }
}
