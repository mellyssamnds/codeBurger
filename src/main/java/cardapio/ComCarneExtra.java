package cardapio;

public class ComCarneExtra implements ItemCardapio {
    private ItemCardapio item;

    public ComCarneExtra(ItemCardapio item) {
        this.item = item;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + carne suculenta extra";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 13.00;
    }

    @Override
    public String getNomeBase() {
        return item.getNomeBase();
    }
}