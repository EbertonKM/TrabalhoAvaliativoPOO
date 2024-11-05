package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import util.Produto;


public class VerificarProdutoController {
    @FXML
    private TextField textFieldVerificador;
    @FXML
    private ComboBox<String> comboBoxVerificador;
    @FXML
    private Label labelDescricaoVerificador;
    @FXML
    private Label labelValorVerificador;
    @FXML
    private Label labelUnitVerificador;

    @FXML
    protected void onTextFieldVerificadorKeyTyped() {

    }
}
