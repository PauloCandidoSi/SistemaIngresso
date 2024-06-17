package Views;

import Models.Cliente;
import Models.Ingresso;
import Services.ClienteService;

import java.util.Scanner;

public class ClienteView {
    private static Scanner sc = new Scanner(System.in);

    public static void login() {
        ClienteService clienteService = new ClienteService();
        System.out.println("Login:");
        System.out.print("   Email: ");
        String email = sc.nextLine();
        System.out.print("   Senha: ");
        String senha = sc.nextLine();

        try {
            clienteService.login(email, senha);
            System.out.println("Login realizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
        }
    }

    public static void apresentarMenu() {
        ClienteService clienteService = new ClienteService();
        Cliente clienteLogado = clienteService.getClienteLogado();

        System.out.printf("Olá %s!\n", clienteLogado.getNome());
        System.out.println("Menu (escolha a opção desejada):");
        System.out.println(" 0 - Sair");
        System.out.println(" 1 - Logout");
        System.out.println(" 2 - Verificar setores disponíveis");
        System.out.println(" 3 - Comprar ingresso");
        System.out.println(" 4 - Visualizar ingresso");

        System.out.print(" Opção: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                System.exit(0);
                break;
            case 1:
                clienteService.logout();
                break;
            case 2:
                System.out.println("Verificando setores disponíveis...");
                setoresDisponiveis();
                break;
            case 3:
                comprarIngresso();
                break;
            case 4:
                visualizarIngresso();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void setoresDisponiveis() {
        System.out.println("\nSetores Disponíveis:");
        System.out.println("Setor Norte - Valor: R$ 30,00");
        System.out.println("Setor Sul - Valor: R$ 30,00");
        System.out.println("Setor Leste - Valor: R$ 60,00");
        System.out.println("Setor Oeste - Valor: R$ 70,00");
        System.out.println("-----------------------------\n");
    }

    private static void comprarIngresso() {
        System.out.println("\nEscolha um setor:");
        System.out.println("1: Setor Norte, 2: Setor Sul, 3: Setor Leste, 4: Setor Oeste");
        int opcao = sc.nextInt();

        Ingresso ingresso = null;
        double valor = 0;

        switch (opcao) {
            case 1:
                valor = 30.00;
                ingresso = new Ingresso("Norte", valor);
                break;
            case 2:
                valor = 30.00;
                ingresso = new Ingresso("Sul", valor);
                break;
            case 3:
                valor = 60.00;
                ingresso = new Ingresso("Leste", valor);
                break;
            case 4:
                valor = 70.00;
                ingresso = new Ingresso("Oeste", valor);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.printf("Você escolheu o Setor %s. O valor é R$ %.2f. Confirmar compra? (S/N): ", ingresso.getSetor(), ingresso.getValor());
        char confirmacao = sc.next().charAt(0);

        if (confirmacao == 'S' || confirmacao == 's') {
            ClienteService clienteService = new ClienteService();
            Cliente clienteLogado = clienteService.getClienteLogado();
            clienteLogado.setIngresso(ingresso);
            System.out.println("Compra confirmada!");
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    private static void visualizarIngresso() {
        ClienteService clienteService = new ClienteService();
        Cliente clienteLogado = clienteService.getClienteLogado();

        if (clienteLogado != null && clienteLogado.getIngresso() != null) {
            Ingresso ingresso = clienteLogado.getIngresso();
            System.out.println("\nIngresso:");
            System.out.println("Setor: " + ingresso.getSetor());
            System.out.println("Valor: R$ " + ingresso.getValor());
        } else {
            System.out.println("\nVocê ainda não comprou nenhum ingresso.");
        }
    }
}
