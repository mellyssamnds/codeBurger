package app;

import cardapio.ItemCardapio;
import cardapio.LancheFactory;
import pedido.GerenciadorPedidos;
import pedido.Pedido;
import financeiro.Caixa;
import financeiro.Transacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador;
    private List<ItemCardapio> cardapio;
    private Caixa caixa = Caixa.getInstance();

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

    public void cancelarPedido(int numero) {
        gerenciador.cancelarPedido(numero);
    }

    public java.util.Set<String> getCombinacoesDiferentes() {
        return gerenciador.getCombinacoesDiferentes();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public void registrarGorjeta(double valor) {
        caixa.registrarGorjeta(valor);
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void registrarTransacoesDoDia() {
        for (Pedido p : gerenciador.getPedidos()) {
            Transacao t = new Transacao(p.getNumero(), p.calcularTotal());
            caixa.registrarTransacao(t);
        }
    }

    public Set<String> getLanchesBaseDiferentes() {
        return gerenciador.getLanchesBaseDiferentes();
    }
}