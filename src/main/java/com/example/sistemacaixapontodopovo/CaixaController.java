package com.example.sistemacaixapontodopovo;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import util.Produto;

import java.util.Optional;

public class CaixaController {
    @FXML
    private TextField textFieldCodigo;
    @FXML
    private TextField textFieldQuantidade;
    @FXML
    private Label labelInformacoesItem;
    @FXML
    private Button buttonAdicionarProduto;
    @FXML
    private TableView<Produto> tableViewProdutos;
    @FXML
    private Button buttonExcluir;
    @FXML
    private Label labelValor;
    @FXML
    private TextField textFieldPago;
    @FXML
    private Label labelTroco;
    @FXML
    private Button buttonConfirmar;

    @FXML
    @SuppressWarnings("unchecked")
    public void initialize() {
        //configurações do TextField para aceitar somente números
        textFieldCodigo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textFieldCodigo.setText(newValue.replaceAll("\\D", ""));
            }
        });
        textFieldQuantidade.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textFieldQuantidade.setText(newValue.replaceAll("\\D", ""));
            }
        });
        textFieldPago.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.,]*")) {
                textFieldPago.setText(newValue.replaceAll("[^\\d.,]", ""));
            }
        });

        //cria as colunas da tableview
        TableColumn<Produto, String> descricao = new TableColumn<>("Descrição");
        TableColumn<Produto, String> preco = new TableColumn<>("Preço");
        TableColumn<Produto, String> unit = new TableColumn<>("Unit");

        //configura cada coluna para se ligar a um atributo de Produto
        descricao.setCellValueFactory(new PropertyValueFactory<>("itemDescricao"));
        preco.setCellValueFactory(new PropertyValueFactory<>("itemPreco"));
        unit.setCellValueFactory(new PropertyValueFactory<>("itemUnit"));

        //define a largura das colunas
        descricao.setPrefWidth(295);
        preco.setPrefWidth(50);
        unit.setPrefWidth(50);

        //impede alteração da largura em tempo de execução
        descricao.setResizable(false);
        preco.setResizable(false);
        unit.setResizable(false);

        //desabilita a ordenação das colunas
        descricao.setSortable(false);
        descricao.setReorderable(false);
        preco.setSortable(false);
        preco.setReorderable(false);
        unit.setSortable(false);
        unit.setReorderable(false);

        tableViewProdutos.getColumns().addAll(descricao, preco, unit);
        tableViewProdutos.setPlaceholder(new Label("Nenhum produto"));

        tableViewProdutos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("Linha selecionada: " + tableViewProdutos.getSelectionModel().getSelectedIndex());
            }
        });
        tableViewProdutos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    @FXML
    protected void onTextFieldCodigoKeyTyped() {
        if (textFieldCodigo.getText().isEmpty()) {
            labelInformacoesItem.setText("");
            buttonAdicionarProduto.setDisable(true);
            return;
        }
        int id = Integer.parseInt(textFieldCodigo.getText());
        Produto produto = Home.getProdutoLoader().getProduto(id);
        if (produto != null) {
            labelInformacoesItem.setText(produto.getItemDescricao() + " - R$ " + produto.getItemPreco() + " / " + produto.getItemUnit());
            buttonAdicionarProduto.setDisable(false);
        } else {
            labelInformacoesItem.setText("Produto não encontrado");
            buttonAdicionarProduto.setDisable(true);
        }
    }

    @FXML
    protected void onButtonAdicionarProdutoMouseClicked() {
        int codigo = Integer.parseInt(textFieldCodigo.getText());
        int quantidade;
        if (textFieldQuantidade.getText().isEmpty()) {
            quantidade = 1;
        } else {
            quantidade = Integer.parseInt(textFieldQuantidade.getText());
        }
        for(int i = quantidade; i > 0; i--) {
            tableViewProdutos.getItems().add(Home.getProdutoLoader().getProduto(codigo));
            tableViewProdutos.refresh();
            tableViewProdutos.getSelectionModel().clearSelection();
        }
        textFieldCodigo.setText("");
        textFieldQuantidade.setText("");
    }

    @FXML
    protected void onButtonExcluirMouseClicked() {
        System.out.println("Not yet implemented");
    }

    @FXML
    protected void onTextFieldPrecoKeyTyped() {
        System.out.println("Not yet implemented");
    }

    @FXML
    protected void onButtonConfirmarMouseClicked() {
        System.out.println("Not yet implemented");
    }
}
