package app;

import cardapio.Lanche;
import pedido.Pedido;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestauranteFacade sistema = new RestauranteFacade();
        MenuConsole menu = new MenuConsole();

        boolean executando = true;
        while (executando) {
            menu.exibirMenu();
            int opcao = menu.lerOpcao();

            switch (opcao) {
                case 1:
                    menu.exibirCardapio(sistema.getCardapio());
                    break;

                case 2:
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nomeCliente);
                    int escolhaLanche;

                    do {
                        escolhaLanche = menu.escolherLanche(sistema.getCardapio());

                        if (escolhaLanche > 0 && escolhaLanche <= sistema.getCardapio().size()) {
                            Lanche modelo = sistema.getCardapio().get(escolhaLanche - 1);

                            // REGRA DO PROJETO: Criar um NOVO objeto Lanche para não afetar o cardápio original
                            Lanche novoLanche = new Lanche(modelo.getNome(), modelo.getPreco());
                            pedido.adicionarItem(novoLanche);

                            menu.exibirMensagem("Adicionado: " + novoLanche.getNome());
                        } else if (escolhaLanche != 0 && escolhaLanche != -1) {
                            menu.exibirMensagem("Escolha inválida. Tente novamente.");
                        }
                    } while (escolhaLanche != 0);

                    if (!pedido.getItens().isEmpty()) {
                        menu.exibirPedido(pedido);
                    } else {
                        menu.exibirMensagem("Pedido cancelado (nenhum item adicionado).");
                    }
                    break;

                case 3:
                    menu.exibirListaDePedidos(sistema.getPedidos());
                    break;

                case 4:
                    double totalDia = sistema.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(totalDia);
                    break;

                case 5:
                    executando = false;
                    menu.exibirMensagem("Saindo do sistema... Até logo!!");
                    break;

                case -1:
                    break;

                default:
                    menu.exibirMensagem("Opção inválida!! Tente novamente!");
            }
        }
        menu.fecharScanner();
    }
}