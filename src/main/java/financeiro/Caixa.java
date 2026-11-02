package financeiro;

import java.util.HashSet;
import java.util.Set;

public class Caixa {
    private final Set<Transacao> transacoes = new HashSet<>();
    private double gorjetas = 0.0;

    private Caixa() {}

    private static class Holder {
        private static final Caixa INSTANCE = new Caixa();
    }

    public static Caixa getInstance() {
        return Holder.INSTANCE;
    }

    public void registrarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void registrarGorjeta(double valor) {
        if (valor > 0) {
            this.gorjetas += valor;
        }
    }

    public double getTotalTransacoes() {
        double total = 0.0;
        for (Transacao t : transacoes) {
            total += t.getValor();
        }
        return total;
    }

    public double getGorjetas() {
        return gorjetas;
    }

    public double getFechamentoTotal() {
        return getTotalTransacoes() + gorjetas;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    public void limpar() {
        transacoes.clear();
        gorjetas = 0.0;
    }
}