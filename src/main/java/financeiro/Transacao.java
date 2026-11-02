package financeiro;

import java.util.Objects;

public class Transacao {
    private final int numeroPedido;
    private final double valor;

    public Transacao(int numeroPedido, double valor) {
        this.numeroPedido = numeroPedido;
        this.valor = valor;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return numeroPedido == transacao.numeroPedido &&
                Double.compare(transacao.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPedido, valor);
    }

    @Override
    public String toString() {
        return "Pedido #" + numeroPedido + " - R$ " + String.format("%.2f", valor);
    }
}