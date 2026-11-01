package cardapio;

public class Lanche implements ItemCardapio {
    private String nome;
    private double preco;

    public Lanche(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do lanche não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço do lanche não pode ser negativo");
        }
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return this.nome;
    }
}
