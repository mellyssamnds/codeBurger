package cardapio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LancheTest {

    @Test
    void falhaAoCriarLancheComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Lanche("X-Burger", -5.0));
    }

    @Test
    void falhaAoCriarLancheComNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Lanche("   ", 10.0));
    }

    @Test
    void falhaAoCriarLancheComNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Lanche(null, 10.0));
    }
}
