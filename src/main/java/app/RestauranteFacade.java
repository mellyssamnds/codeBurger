package app;

import cardapio.Lanche;
import pedido.GerenciadorPedidos;
import pedido.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador;
    private List<Lanche> cardapio;

    public RestauranteFacade() {
        this.gerenciador = new GerenciadorPedidos();
        this.cardapio = new ArrayList<>();

        cardapio.add(new Lanche("X-Burger", 18.0));
        cardapio.add(new Lanche("X-Salada", 23.0));
        cardapio.add(new Lanche("X-Tudo Triplo", 32.0));
    }

    public List<Lanche> getCardapio() {
        return cardapio;
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
