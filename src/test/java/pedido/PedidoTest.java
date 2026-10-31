package pedido;

import cardapio.Lanche;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void falhaAoCriarPedidoComNomeClienteNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(1, null));
    }

    @Test
    void falhaAoCriarPedidoComNomeClienteVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(1, "   "));
    }

    @Test
    void calculaTotalCorretamenteParaMultiplosItens() {
        // Arrange
        Pedido pedido = new Pedido(1, "Mell");

        // Act
        pedido.adicionarItem(new Lanche("X-Burger", 16.0));
        pedido.adicionarItem(new Lanche("X-Salada", 18.0));

        // Assert
        assertEquals(34.0, pedido.calcularTotal(), 0.001);
    }
}