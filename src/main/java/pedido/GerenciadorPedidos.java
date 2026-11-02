package pedido;

import cardapio.ItemCardapio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GerenciadorPedidos {
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {
        Pedido novoPedido = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novoPedido.getNumero(), novoPedido);
        contadorPedidos++;
        return novoPedido;
    }

    public Pedido buscarPedido(int numero) {
        return pedidos.get(numero);
    }

    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }

    public Set<String> getCombinacoesDiferentes() {
        Set<String> combinacoes = new HashSet<>();
        for (Pedido p : pedidos.values()) {
            for (ItemCardapio item : p.getItens()) {
                combinacoes.add(item.getDescricao());
            }
        }
        return combinacoes;
    }

    public Set<String> getLanchesBaseDiferentes() {
        Set<String> bases = new HashSet<>();
        for (Pedido p : pedidos.values()) {
            for (ItemCardapio item : p.getItens()) {
                bases.add(item.getNomeBase());
            }
        }
        return bases;
    }

    public void cancelarPedido(int numero) {
        pedidos.remove(numero);
    }

    public double calcularTotalDoDia() {
        double total = 0.0;
        for (Pedido pedido : pedidos.values()) {
            total += pedido.calcularTotal();
        }
        return total;
    }

}
