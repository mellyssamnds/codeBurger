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

                case 2: {
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nomeCliente);
                    adicionarItensAoCarrinho(menu, sistema, pedido);

                    if (!pedido.getItens().isEmpty()) {
                        menu.exibirPedido(pedido);
                    } else {
                        menu.exibirMensagem("Pedido cancelado (nenhum item adicionado)");
                        sistema.cancelarPedido(pedido.getNumero());
                    }
                    break;
                }

                case 3: {
                    System.out.print("Digite o número do pedido que deseja modificar: ");
                    int numModificar = menu.lerOpcao();
                    Pedido pedidoMod = sistema.buscarPedido(numModificar);

                    if (pedidoMod == null) {
                        menu.exibirMensagem("Pedido não encontrado!");
                        break;
                    }

                    menu.exibirMenuModificarPedido();
                    int opcaoMod = menu.lerOpcao();

                    switch (opcaoMod) {
                        case 1:
                            adicionarItensAoCarrinho(menu, sistema, pedidoMod);
                            menu.exibirPedido(pedidoMod);
                            break;
                        case 2:
                            int indexRemover = menu.escolherItemParaRemover(pedidoMod);
                            if (indexRemover >= 0) {
                                pedidoMod.removerItem(indexRemover);
                                menu.exibirMensagem("Item removido com sucesso!");
                                menu.exibirPedido(pedidoMod);
                            }
                            break;
                        case 3:
                            sistema.cancelarPedido(numModificar);
                            menu.exibirMensagem("Pedido #" + numModificar + " cancelado.");
                            break;
                        case 0:
                            break;
                        default:
                            menu.exibirMensagem("Opção inválida!");
                            break;
                    }
                    break;
                }

                case 4:
                    menu.exibirListaDePedidos(sistema.getPedidos());
                    break;

                case 5: {
                    if (menu.lerSimNao("Deseja registrar gorjeta? (S/N): ")) {
                        System.out.print("Valor da gorjeta: R$ ");
                        double gorjeta = menu.lerDouble();
                        sistema.registrarGorjeta(gorjeta);
                    }

                    sistema.registrarTransacoesDoDia();

                    double totalPedidos = sistema.calcularTotalDoDia();
                    double totalGorjetas = sistema.getCaixa().getGorjetas();
                    double totalGeral = sistema.getCaixa().getFechamentoTotal();

                    java.util.Set<String> combinacoes = sistema.getCombinacoesDiferentes();
                    java.util.Set<String> bases = sistema.getLanchesBaseDiferentes();

                    menu.exibirFechamentoDoDia(totalPedidos, totalGorjetas, totalGeral, combinacoes, bases);
                    break;
                }

                case 6:
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

    private static void adicionarItensAoCarrinho(MenuConsole menu, RestauranteFacade sistema, Pedido pedido) {
        int escolhaLanche;
        do {
            escolhaLanche = menu.escolherLanche(sistema.getCardapio());

            if (escolhaLanche > 0 && escolhaLanche <= sistema.getCardapio().size()) {
                ItemCardapio novoItem = sistema.criarItemDoCardapio(escolhaLanche - 1);

                if (novoItem instanceof Lanche) {
                    Lanche lanche = (Lanche) novoItem;
                    menu.personalizarLanche(lanche);
                }

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
    }
}