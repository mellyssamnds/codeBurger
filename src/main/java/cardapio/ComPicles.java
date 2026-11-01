package cardapio;

public class ComPicles implements ItemCardapio {
    private ItemCardapio item;

    public ComPicles(ItemCardapio item) {
        this.item = item;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + picles de pepino";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 3.00;
    }
}