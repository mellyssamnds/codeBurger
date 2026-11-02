package cardapio;

public class Lanche implements ItemCardapio {
    private String nome;
    private double preco;

    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

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

    public boolean queroQueijo() {
        return queijo;
    }

    public void setQueijo(boolean queijo) {
        this.queijo = queijo;
    }

    public boolean queroAlface() {
        return alface;
    }

    public void setAlface(boolean alface) {
        this.alface = alface;
    }

    public boolean queroTomate() {
        return tomate;

    }
    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public boolean queroCebola() {
        return cebola;
    }

    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }

    @Override
    public String getDescricao() {
        String descricao = this.nome;

        if (!queijo) {
            descricao += " sem queijo";
        }
        if (!alface) {
            descricao += " sem alface";
        }
        if (!tomate) {
            descricao += " sem tomate";
        }
        if (!cebola) {
            descricao += " sem cebola";
        }

        return descricao;
    }
}
