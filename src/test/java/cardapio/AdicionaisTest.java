package cardapio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdicionaisTest {

    @Test
    void falhaAoCriarLancheComPrecoNegativo() {
        // Teste de validação
        assertThrows(IllegalArgumentException.class, () -> new Lanche("X-Burger", -5.0));
    }

    @Test
    void xTudoTriploComCheddarEBaconExtraCustaOValorCorreto() {
        // Teste do Decorator
        // X-Tudo (32) + Cheddar (4) + Bacon Extra (6) = 42.0
        ItemCardapio lanche = LancheFactory.XTudoTriplo();
        lanche = new ComCheddar(lanche);
        lanche = new ComBaconExtra(lanche);

        assertEquals(42.0, lanche.getPreco(), 0.001);
        assertEquals("X-Tudo Triplo + cheddar + bacon extra", lanche.getDescricao());
    }
}