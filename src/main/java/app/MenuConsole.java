package app;

import cardapio.ItemCardapio;
import pedido.Pedido;
import util.Cores;

import java.util.List;
import java.util.Scanner;

public class MenuConsole {
    private Scanner scanner;

    public MenuConsole() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println(Cores.LARANJA + Cores.NEGRITO + "\n=== CODE BURGER ===" + Cores.RESET);
        System.out.println(Cores.AZUL + "1. " + Cores.RESET + "Exibir cardápio");
        System.out.println(Cores.AZUL + "2. " + Cores.RESET + "Criar pedido");
        System.out.println(Cores.AZUL + "3. " + Cores.RESET + "Ver pedidos");
        System.out.println(Cores.AZUL + "4. " + Cores.RESET + "Calcular total do dia");
        System.out.println(Cores.VERMELHO + "5. Sair" + Cores.RESET);
        System.out.print(Cores.AMARELO + Cores.NEGRITO + "Escolha uma opção: " + Cores.RESET);
    }

    public int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println(Cores.VERMELHO + "Opção inválida. Por favor, digite um número!" + Cores.RESET);
            return -1;
        }
    }

    public String lerNomeCliente() {
        System.out.print(Cores.AMARELO + "Digite o nome do cliente: " + Cores.RESET);
        return scanner.nextLine();
    }

    public void exibirCardapio(List<ItemCardapio> cardapio) {
        System.out.println(Cores.VERMELHO + Cores.NEGRITO + "\n--- CARDÁPIO ---" + Cores.RESET);
        for (int i = 0; i < cardapio.size(); i++) {
            ItemCardapio item = cardapio.get(i);
            System.out.printf(Cores.AZUL + "%d. " + Cores.RESET + "%s - " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, i + 1, item.getDescricao(), item.getPreco());
        }
    }

    public int escolherLanche(List<ItemCardapio> cardapio) {
        System.out.println(Cores.VERMELHO + Cores.NEGRITO + "\n--- CARDÁPIO ---" + Cores.RESET);
        System.out.println("Escolha um lanche pelo número:");
        for (int i = 0; i < cardapio.size(); i++) {
            ItemCardapio item = cardapio.get(i);
            System.out.printf(Cores.AZUL + "%d. " + Cores.RESET + "%s - " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, i + 1, item.getDescricao(), item.getPreco());
        }
        System.out.print(Cores.AMARELO + Cores.NEGRITO + "Escolha o número do lanche (ou 0 para parar): " + Cores.RESET);

        try {
            int escolha = scanner.nextInt();
            scanner.nextLine();
            return escolha;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println(Cores.VERMELHO + "Escolha inválida. Por favor, digite um número!" + Cores.RESET);
            return -1;
        }
    }

    public boolean queroAdicional() {
        System.out.print(Cores.AMARELO + "Deseja turbinar seu lanche? (S/N): " + Cores.RESET);
        String resposta = scanner.nextLine().trim().toUpperCase();
        return resposta.equals("S");
    }

    public int escolherAdicional() {
        System.out.println(Cores.VERMELHO + "\n--- ADICIONAIS ---" + Cores.RESET);
        System.out.println(Cores.AZUL + "1. " + Cores.RESET + "Cheddar (+ R$ 4,00)");
        System.out.println(Cores.AZUL + "2. " + Cores.RESET + "Bacon Extra (+ R$ 6,00)");
        System.out.println(Cores.AZUL + "3. " + Cores.RESET + "Carne Extra (+ R$ 13,00)");
        System.out.println(Cores.AZUL + "4. " + Cores.RESET + "Cebola Caramelizada (+ R$ 5,00)");
        System.out.println(Cores.AZUL + "5. " + Cores.RESET + "Mussarela (+ R$ 5,00)");
        System.out.println(Cores.AZUL + "6. " + Cores.RESET + "Picles (+ R$ 3,00)");
        System.out.println(Cores.AZUL + "7. " + Cores.RESET + "Banana Frita (+ R$ 4,00)");
        System.out.print(Cores.AMARELO + "Escolha o adicional (0 para nenhum): " + Cores.RESET);
        try {
            int escolha = scanner.nextInt();
            scanner.nextLine();
            return escolha;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println(Cores.VERMELHO + "Opção inválida!" + Cores.RESET);
            return 0;
        }
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println(Cores.AZUL + Cores.NEGRITO + "\n--- PEDIDO #" + pedido.getNumero() + " ---" + Cores.RESET);
        System.out.println("Cliente: " + Cores.ROXO + Cores.NEGRITO + pedido.getNomeCliente() + Cores.RESET);

        System.out.println("Itens:");
        for (ItemCardapio item : pedido.getItens()) {
            System.out.printf(Cores.AZUL + "- " + Cores.RESET + "%s - " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, item.getDescricao(), item.getPreco());
        }
        System.out.printf(Cores.NEGRITO + "Total do pedido: " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, pedido.calcularTotal());
    }

    public void exibirListaDePedidos(java.util.Collection<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println(Cores.VERMELHO + "Nenhum pedido registrado hoje :(" + Cores.RESET);
            return;
        }
        for (Pedido p : pedidos) {
            exibirPedido(p);
        }
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.println(Cores.VERMELHO + Cores.NEGRITO + "\n=== FECHAMENTO DO DIA ===" + Cores.RESET);
        System.out.printf("Total do dia: " + Cores.VERDE + Cores.NEGRITO + "R$ %.2f%n" + Cores.RESET, total);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void fecharScanner() {
        scanner.close();
    }
}