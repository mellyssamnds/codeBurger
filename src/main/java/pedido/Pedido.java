package pedido;

import cardapio.ItemCardapio;
import cardapio.Lanche;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens;

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        setNomeCliente(nomeCliente);
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException("Lanche não pode ser nulo");
        }
        itens.add(item);
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public void removerItem(int index) {
        if (index >= 0 && index < itens.size()) {
            itens.remove(index);
        } else {
            throw new IllegalArgumentException("Índice de item inválido!");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }
        return total;
    }
}
