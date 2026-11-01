package cardapio;

public class ComCebolaCaramelizada implements ItemCardapio {
    private ItemCardapio item;

    public ComCebolaCaramelizada(ItemCardapio item) {
        this.item = item;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + cebola caramelizada";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 5.00;
    }
}