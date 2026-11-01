package cardapio;

public class LancheFactory {
    public static Lanche XBurger() {
        return new Lanche("X-Burger", 18.0);
    }

    public static Lanche XSalada() {
        return new Lanche("X-Salada", 23.0);
    }

    public static Lanche XTudoTriplo() {
        return new Lanche("X-Tudo Triplo", 32.0);
    }
}