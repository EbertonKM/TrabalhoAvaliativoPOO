package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProdutoLoader {
    private List<Produto> produtos;

    public ProdutoLoader(String filePath) {
        this.produtos = loadProdutos(filePath);
    }

    private List<Produto> loadProdutos(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Produto>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produto> getProdutos(){
        return this.produtos;
    }

    public Produto getProduto(int id) {
        for (Produto produto : this.produtos) {
            if (produto.getItemId() == id) return produto;
        }
        return null;
    }
}
