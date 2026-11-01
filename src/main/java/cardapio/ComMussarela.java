package cardapio;

public class ComMussarela implements ItemCardapio {
    private ItemCardapio item;

    public ComMussarela(ItemCardapio item) {
        this.item = item;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + mussarela";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 5.00;
    }
}