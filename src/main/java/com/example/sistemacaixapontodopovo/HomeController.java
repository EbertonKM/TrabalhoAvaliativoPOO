package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;

import java.util.Objects;

public class HomeController {

    @FXML
    private MenuItem menuItem1;
    @FXML
    private MenuItem menuItem2;

    @FXML
    public void initialize() {
        menuItem1.setAccelerator(new KeyCodeCombination(KeyCode.F1));
        menuItem2.setAccelerator(new KeyCodeCombination(KeyCode.F2));
    }
}
