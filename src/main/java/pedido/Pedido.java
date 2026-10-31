package pedido;

import cardapio.Lanche;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<Lanche> itens;

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

    public void adicionarItem(Lanche lanche) {
        if (lanche == null) {
            throw new IllegalArgumentException("Lanche não pode ser nulo");
        }
        itens.add(lanche);
    }

    public ArrayList<Lanche> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Lanche lanche : itens) {
            total += lanche.getPreco();
        }
        return total;
    }
}
