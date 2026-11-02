package financeiro;

import cardapio.Lanche;
import org.junit.jupiter.api.Test;
import pedido.GerenciadorPedidos;
import pedido.Pedido;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    @Test
    void deveEvitarTransacoesDuplicadas() {
        Caixa caixa = Caixa.getInstance();
        caixa.limpar();
        Transacao t1 = new Transacao(1, 30.0);
        Transacao t2 = new Transacao(1, 30.0); // mesma transação
        caixa.registrarTransacao(t1);
        caixa.registrarTransacao(t2);
        assertEquals(1, caixa.getTransacoes().size());
    }

    @Test
    void deveCalcularFechamentoComGorjetas() {
        Caixa caixa = Caixa.getInstance();
        caixa.limpar();
        caixa.registrarTransacao(new Transacao(1, 50.0));
        caixa.registrarGorjeta(10.0);
        assertEquals(60.0, caixa.getFechamentoTotal(), 0.001);
    }

    @Test
    void deveRemoverPedidoCancelado() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();
        Pedido p = gerenciador.criarPedido("Teste");
        p.adicionarItem(new Lanche("X-Burger", 18.0));
        gerenciador.cancelarPedido(p.getNumero());
        assertTrue(gerenciador.getPedidos().isEmpty());
    }
}