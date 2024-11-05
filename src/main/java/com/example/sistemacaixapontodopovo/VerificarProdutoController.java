package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.util.StringConverter;
import util.Produto;

import java.util.List;


public class VerificarProdutoController {
    @FXML
    private TextField textFieldVerificador;
    @FXML
    private ComboBox<Produto> comboBoxVerificador;
    @FXML
    private Label labelValorVerificador;
    @FXML
    private Label labelUnitVerificador;

    @FXML
    public void initialize() {
        textFieldVerificador.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textFieldVerificador.setText(newValue.replaceAll("\\D", ""));
            }
        });

        comboBoxVerificador.getItems().addAll(Home.getProdutoLoader().getProdutos());
        comboBoxVerificador.setConverter(new StringConverter<>() {
            @Override
            public String toString(Produto produto) {
                return produto != null ? produto.getItemDescricao() : "";
            }

            @Override
            public Produto fromString(String string) {
                return comboBoxVerificador.getItems().stream()
                        .filter(produto -> produto.getItemDescricao().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }

    @FXML
    protected void onTextFieldVerificadorKeyTyped() {
        if (textFieldVerificador.getText().isEmpty()) {
            return;
        }
        for (Produto produto : Home.getProdutoLoader().getProdutos()) {
            if (produto.getItemId() == Integer.parseInt(textFieldVerificador.getText())) {
                labelValorVerificador.setText("R$" + produto.getItemPreco());
                labelUnitVerificador.setText(produto.getItemUnit());
                comboBoxVerificador.getSelectionModel().select(produto);
                return;
            }
        }
        comboBoxVerificador.setValue(null);
        labelValorVerificador.setText("");
        labelUnitVerificador.setText("");
    }

    @FXML
    protected void onComboBoxVerificadorAction() {
        Produto produto = comboBoxVerificador.getValue();
        if (produto == null) {
            return;
        }
        labelValorVerificador.setText("R$" + produto.getItemPreco());
        labelUnitVerificador.setText(produto.getItemUnit());
        if (comboBoxVerificador.isShowing()) {
            textFieldVerificador.setText(String.valueOf(produto.getItemId()));
        }
    }
}
