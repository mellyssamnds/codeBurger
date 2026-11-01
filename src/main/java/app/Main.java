package app;

import cardapio.*;
import pedido.Pedido;

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

                            ItemCardapio novoItem = sistema.criarItemDoCardapio(escolhaLanche - 1);

                            while (menu.queroAdicional()) {
                                int extra = menu.escolherAdicional();
                                switch (extra) {
                                    case 1:
                                        novoItem = new ComCheddar(novoItem);
                                        break;
                                    case 2:
                                        novoItem = new ComBaconExtra(novoItem);
                                        break;
                                    case 3:
                                        novoItem = new ComCarneExtra(novoItem);
                                        break;
                                    case 4:
                                        novoItem = new ComCebolaCaramelizada(novoItem);
                                        break;
                                    case 5:
                                        novoItem = new ComMussarela(novoItem);
                                        break;
                                    case 6:
                                        novoItem = new ComPicles(novoItem);
                                        break;
                                    case 7:
                                        novoItem = new ComBanana(novoItem);
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        menu.exibirMensagem("Opção de adicional inválida");
                                        break;
                                }
                            }

                            pedido.adicionarItem(novoItem);
                            menu.exibirMensagem("Adicionado: " + novoItem.getDescricao());
                        } else if (escolhaLanche != 0 && escolhaLanche != -1) {
                            menu.exibirMensagem("Escolha inválida. Tente novamente!");
                        }
                    } while (escolhaLanche != 0);

                    if (!pedido.getItens().isEmpty()) {
                        menu.exibirPedido(pedido);
                    } else {
                        menu.exibirMensagem("Pedido cancelado (nenhum item adicionado)");
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