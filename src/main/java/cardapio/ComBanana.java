package cardapio;

public class ComBanana implements ItemCardapio {
    private ItemCardapio item;

    public ComBanana(ItemCardapio item) {
        this.item = item;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + banana frita";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 4.00;
    }

    @Override
    public String getNomeBase() {
        return item.getNomeBase();
    }

}