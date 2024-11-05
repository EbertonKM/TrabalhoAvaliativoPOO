package util;

public class Produto {
    private int itemId;
    private String itemDescricao;
    private double itemPreco;
    private String itemUnit;

    public Produto(int itemId, String itemDescricao, double itemPreco, String itemUnit) {
        this.itemId = itemId;
        this.itemDescricao = itemDescricao;
        this.itemPreco = itemPreco;
        this.itemUnit = itemUnit;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getItemDescricao(String itemDescricao) {
        return this.itemDescricao;
    }

    public double getItemPreco() {
        return this.itemPreco;
    }

    public String getItemUnit() {
        return this.itemUnit;
    }
}
