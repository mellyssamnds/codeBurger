package app;

import cardapio.ItemCardapio;
import cardapio.LancheFactory;
import pedido.GerenciadorPedidos;
import pedido.Pedido;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador;
    private List<ItemCardapio> cardapio;

    public RestauranteFacade() {
        this.gerenciador = new GerenciadorPedidos();
        this.cardapio = new ArrayList<>();

        cardapio.add(LancheFactory.XBurger());
        cardapio.add(LancheFactory.XSalada());
        cardapio.add(LancheFactory.XTudoTriplo());
    }

    public List<ItemCardapio> getCardapio() {
        return cardapio;
    }

    public ItemCardapio criarItemDoCardapio(int index) {
        switch (index) {
            case 0: return LancheFactory.XBurger();
            case 1: return LancheFactory.XSalada();
            case 2: return LancheFactory.XTudoTriplo();
            default: return null;
        }
    }

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public Pedido buscarPedido(int numero) {
        return gerenciador.buscarPedido(numero);
    }

    public Collection<Pedido> getPedidos() {
        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }
}
