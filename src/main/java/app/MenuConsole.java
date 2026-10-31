package app;

import cardapio.Lanche;
import pedido.Pedido;

import java.util.List;
import java.util.Scanner;

public class MenuConsole {
    private Scanner scanner;

    public MenuConsole() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\n=== CODE BURGER ===");
        System.out.println("1. Exibir cardápio");
        System.out.println("2. Criar pedido");
        System.out.println("3. Ver pedidos");
        System.out.println("4. Calcular total do dia");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Opção inválida. Por favor, digite um número!");
            return -1;
        }
    }

    public String lerNomeCliente() {
        System.out.print("Digite o nome do cliente: ");
        return scanner.nextLine();
    }

    public void exibirCardapio(List<Lanche> cardapio) {
        System.out.println("\n--- CARDÁPIO ---");
        for (int i = 0; i < cardapio.size(); i++) {
            Lanche l = cardapio.get(i);
            System.out.printf("%d. %s - R$ %.2f%n", i + 1, l.getNome(), l.getPreco());
        }
    }

    public int escolherLanche(List<Lanche> cardapio) {
        System.out.println("\n--- CARDÁPIO ---");
        System.out.println("Escolha um lanche pelo número:");
        for (int i = 0; i < cardapio.size(); i++) {
            Lanche lanche = cardapio.get(i);
            System.out.printf("%d. %s - R$ %.2f%n", i + 1, lanche.getNome(), lanche.getPreco());
        }
        System.out.print("Escolha o número do lanche (ou 0 para parar): ");

        try {
            int escolha = scanner.nextInt();
            scanner.nextLine();
            return escolha;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Escolha inválida. Por favor, digite um número!");
            return -1;
        }
    }

    public boolean queroAdicional() {
        System.out.println("Deseja adicionar itens ao seu lanche? (S/N)");
        String resposta = scanner.nextLine().trim().toUpperCase();
        return resposta.equals("S");
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\n--- PEDIDO #" + pedido.getNumero() + " ---");
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Itens:");
        for (Lanche item : pedido.getItens()) {
            System.out.printf("- %s - R$ %.2f%n", item.getNome(), item.getPreco());
        }
        System.out.printf("Total do pedido: R$ %.2f%n", pedido.calcularTotal());
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.printf("\n=== FECHAMENTO DO DIA ===%n");
        System.out.printf("Total do dia: R$ %.2f%n", total);
    }

    public void exibirListaDePedidos(java.util.Collection<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado hoje.");
            return;
        }
        for (Pedido p : pedidos) {
            exibirPedido(p);
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void fecharScanner() {
        scanner.close();
    }

}