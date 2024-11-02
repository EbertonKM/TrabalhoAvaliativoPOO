package com.example.sistemacaixapontodopovo;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HomeController {

    @FXML
    private MenuItem menuItemCaixa;
    @FXML
    private MenuItem menuItemVerificarProduto;
    @FXML
    private MenuItem menuItemSobre;
    @FXML
    private MenuItem menuItemSair;

    @FXML
    public void initialize() {
        menuItemCaixa.setAccelerator(new KeyCodeCombination(KeyCode.F1));
        menuItemVerificarProduto.setAccelerator(new KeyCodeCombination(KeyCode.F2));
        menuItemSobre.setAccelerator(new KeyCodeCombination(KeyCode.F3));
        menuItemSair.setAccelerator(new KeyCodeCombination(KeyCode.F4));

        menuItemCaixa.setOnAction(event -> {onCaixaButtonClick();});
        menuItemVerificarProduto.setOnAction(event -> {onVerificarProdutoButtonClick();});
        menuItemSobre.setOnAction(event -> {onSobreButtonClick();});
        menuItemSair.setOnAction(event -> {onSairButtonClick();});
    }

    @FXML
    protected void onCaixaButtonClick() {
        //try {
            new Caixa();
        //} catch (IOException e) {
            //throw new RuntimeException("Erro ao iniciar a tela Caixa");
        //}
    }

    @FXML
    protected void onVerificarProdutoButtonClick() {
        //try {
            new VerificarProduto();
        //} catch (IOException e) {
        //    throw new RuntimeException("Erro ao iniciar a tela VerificarProduto");
        //}
    }

    @FXML
    protected void onSobreButtonClick() {
        try {
            new Sobre();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao iniciar a tela Sobre");
        }
    }

    @FXML
    protected void onSairButtonClick() {
        System.exit(0);
    }
}
