package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;

public class HomeController {

    @FXML
    private MenuItem menuItemCaixa;
    @FXML
    private MenuItem menuItemVerificarProduto;
    @FXML
    private Menu menuSobre;
    @FXML
    private Menu menuSair;

    @FXML
    public void initialize() {
        menuItemCaixa.setAccelerator(new KeyCodeCombination(KeyCode.F1));
        menuItemVerificarProduto.setAccelerator(new KeyCodeCombination(KeyCode.F2));

        menuItemCaixa.setOnAction(event -> {onCaixaButtonClick();});
        menuItemVerificarProduto.setOnAction(event -> {onVerificarProdutoButtonClick();});
        menuSobre.setOnShown(event -> {onSobreButtonClick(); menuSobre.hide();});
        menuSair.setOnShown(event -> {onSairButtonClick();});
    }

    @FXML
    protected void onCaixaButtonClick() {
        //new janelaCaixa();
    }

    @FXML
    protected void onVerificarProdutoButtonClick() {
        //new janelaVerificarProduto();
    }

    @FXML
    protected void onSobreButtonClick() {
        //new janelaSobre();
    }

    @FXML
    protected void onSairButtonClick() {
        System.exit(0);
    }
}
