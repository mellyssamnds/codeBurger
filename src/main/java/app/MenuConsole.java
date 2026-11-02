package app;

import cardapio.ItemCardapio;
import cardapio.Lanche;
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
        System.out.println(Cores.AZUL + "3. " + Cores.RESET + "Modificar pedido"); // NOVO
        System.out.println(Cores.AZUL + "4. " + Cores.RESET + "Ver pedidos");
        System.out.println(Cores.AZUL + "5. " + Cores.RESET + "Fechar o dia"); // Antigo 4
        System.out.println(Cores.VERMELHO + "6. " + Cores.RESET + "Sair"); // Antigo 5
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

    public void personalizarLanche(Lanche lanche) {
        System.out.println(Cores.AMARELO + "\nPersonalize seu " + lanche.getNome() + ":" + Cores.RESET);
        if (lerSimNao("Deseja retirar o QUEIJO? (S/N): ")) {
            lanche.setQueijo(false);
        }
        if (lerSimNao("Deseja retirar o ALFACE? (S/N): ")) {
            lanche.setAlface(false);
        }
        if (lerSimNao("Deseja retirar o TOMATE? (S/N): ")) {
            lanche.setTomate(false);
        }
        if (lerSimNao("Deseja retirar a CEBOLA? (S/N): ")) {
            lanche.setCebola(false);
        }
    }

    public boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(Cores.AMARELO + mensagem + Cores.RESET);
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("S")) {
                return true;
            }

            if (resposta.equals("N")) {
                return false;
            }

            System.out.println(Cores.VERMELHO + "Resposta inválida! Digite apenas 'S' para Sim ou 'N' para Não." + Cores.RESET);
        }
    }

    public boolean queroAdicional() {
        return lerSimNao("Deseja turbinar seu lanche? (S/N): ");
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

    public void exibirMenuModificarPedido() {
        System.out.println(Cores.AMARELO + "\n--- MODIFICAR PEDIDO ---" + Cores.RESET);
        System.out.println(Cores.AZUL + "1. " + Cores.RESET + "Adicionar item");
        System.out.println(Cores.AZUL + "2. " + Cores.RESET + "Remover item");
        System.out.println(Cores.VERMELHO + "3. " + Cores.RESET + "Cancelar pedido inteiro");
        System.out.println(Cores.AZUL + "0. " + Cores.RESET + "Voltar");
        System.out.print(Cores.NEGRITO + "Escolha uma opção: " + Cores.RESET);
    }

    public int escolherItemParaRemover(Pedido pedido) {
        System.out.println(Cores.AMARELO + "\n--- ITENS DO PEDIDO #" + pedido.getNumero() + " ---" + Cores.RESET);
        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemCardapio item = pedido.getItens().get(i);
            System.out.printf("%d. %s - R$ %.2f%n", i + 1, item.getDescricao(), item.getPreco());
        }
        System.out.print("Digite o número do item que deseja remover (0 para cancelar): ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            return index - 1;
        } catch (Exception e) {
            scanner.nextLine();
            return -2;
        }
    }

    public void exibirFechamentoDoDia(double totalPedidos, double gorjetas, double totalGeral, java.util.Set<String> combinacoes, java.util.Set<String> bases) {
        System.out.println(Cores.VERMELHO + Cores.NEGRITO + "\n=== FECHAMENTO DO DIA ===" + Cores.RESET);

        System.out.printf("Vendas (pedidos): " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, totalPedidos);
        System.out.printf("Gorjetas:         " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, gorjetas);
        System.out.printf(Cores.NEGRITO + "TOTAL GERAL:      " + Cores.VERDE + "R$ %.2f%n" + Cores.RESET, totalGeral);

        System.out.println(Cores.AZUL + "\nLanches base diferentes vendidos: " + bases.size() + Cores.RESET);
        for (String base : bases) {
            System.out.println("- " + base);
        }

        System.out.println(Cores.AZUL + "\nCombinações diferentes vendidas: " + combinacoes.size() + Cores.RESET);
        for (String comb : combinacoes) {
            System.out.println("- " + comb);
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public double lerDouble() {
        try {
            double valor = scanner.nextDouble();
            scanner.nextLine();
            return valor;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println(Cores.VERMELHO + "Valor inválido. Por favor, digite um número!" + Cores.RESET);
            return 0.0;
        }
    }

    public void fecharScanner() {
        scanner.close();
    }
}