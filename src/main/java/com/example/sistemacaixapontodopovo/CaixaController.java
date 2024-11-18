package com.example.sistemacaixapontodopovo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.Produto;

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
    private ListView<String> listViewProdutos;
    @FXML
    private Button buttonExcluir;
    @FXML
    private Label labelValorTotal;
    @FXML
    private TextField textFieldPago;
    @FXML
    private Label labelTroco;
    @FXML
    private Button buttonConfirmar;

    double valorTotal = 0;

    @FXML
    public void initialize() {
        //configurações do TextField para aceitar somente números
        textFieldCodigo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textFieldCodigo.setText(newValue.replaceAll("\\D", ""));
            }
        });
        textFieldQuantidade.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.,]*")) {
                textFieldQuantidade.setText(newValue.replaceAll("[^\\d.,]", ""));
            }
        });
        textFieldPago.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.,]*")) {
                textFieldPago.setText(newValue.replaceAll("[^\\d.,]", ""));
            }
        });
        labelValorTotal.setText("R$ 0,00");
    }

    @FXML
    protected void onTextFieldCodigoKeyTyped() {
        if (textFieldCodigo.getText().isEmpty()) {
            labelInformacoesItem.setText("Informe o código do produto");
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
        double quantidade;
        Produto produto = Home.getProdutoLoader().getProduto(codigo);
        if (textFieldQuantidade.getText().isEmpty()) {
            quantidade = 1;
        } else {
            quantidade = Double.parseDouble(textFieldQuantidade.getText().replaceAll(",", "."));
        }
        valorTotal += produto.getItemPreco() * quantidade;
        listViewProdutos.getItems().add(produto.getItemDescricao() + " - " +
                quantidade + " - " +
                produto.getItemUnit() + " - R$ " +
                produto.getItemPreco() + " - R$ " +
                String.format("%.2f", produto.getItemPreco() * quantidade));
        labelValorTotal.setText("R$ " + String.format("%.2f", valorTotal));
        textFieldCodigo.setText("");
        textFieldQuantidade.setText("");
        labelInformacoesItem.setText("Informe o código do produto");
        buttonAdicionarProduto.setDisable(true);
    }

    @FXML
    protected void onButtonExcluirMouseClicked() {
        String linha = listViewProdutos.getSelectionModel().getSelectedItem().replace(",", ".");
        valorTotal -= Double.parseDouble(linha.substring(linha.lastIndexOf(" ") + 1));
        listViewProdutos.getItems().remove(listViewProdutos.getSelectionModel().getSelectedItem());
        labelValorTotal.setText("R$ " + String.format("%.2f", valorTotal));
        textFieldPago.setText("");
        labelTroco.setText("");
    }

    @FXML
    protected void onTextFieldPagoKeyTyped() {
        double pagamento;
        try {
            pagamento = Double.parseDouble(textFieldPago.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter string do TextField de pagamento em um valor Double");

            return;
        }
        if (pagamento < valorTotal) {
            buttonConfirmar.setDisable(true);
            labelTroco.setText("");
        } else {
            buttonConfirmar.setDisable(false);
            labelTroco.setText("R$ " + String.format("%.2f", pagamento - valorTotal));
        }
    }

    @FXML
    protected void onButtonConfirmarMouseClicked() {
        listViewProdutos.getItems().clear();
        textFieldPago.clear();
        labelValorTotal.setText("");
        labelTroco.setText("");
    }
}
