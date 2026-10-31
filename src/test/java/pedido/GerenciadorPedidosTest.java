package pedido;

import cardapio.Lanche;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorPedidosTest {

    @Test
    void deveGerarNumerosSequenciaisParaNovosPedidos() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido p1 = gerenciador.criarPedido("Mell");
        Pedido p2 = gerenciador.criarPedido("Alex");

        assertEquals(1, p1.getNumero());
        assertEquals(2, p2.getNumero());
    }

    @Test
    void deveBuscarPedidoPeloNumeroCorretamente() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();
        Pedido p1 = gerenciador.criarPedido("Mell");

        Pedido buscado = gerenciador.buscarPedido(1);

        assertNotNull(buscado);
        assertEquals(p1.getNomeCliente(), buscado.getNomeCliente());
    }

    @Test
    void deveRetornarNuloAoBuscarPedidoInexistente() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido buscado = gerenciador.buscarPedido(99);

        assertNull(buscado);
    }

    @Test
    void deveCalcularTotalDoDiaSomandoTodosOsPedidos() {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido p1 = gerenciador.criarPedido("Mell");
        p1.adicionarItem(new Lanche("X-Burger", 16.0));

        Pedido p2 = gerenciador.criarPedido("Alex");
        p2.adicionarItem(new Lanche("X-Bacon", 22.0));
        p2.adicionarItem(new Lanche("X-Salada", 18.0));

        // Total: 16.0 + 22.0 + 18.0 = 56.0
        assertEquals(56.0, gerenciador.calcularTotalDoDia(), 0.001);
    }
}