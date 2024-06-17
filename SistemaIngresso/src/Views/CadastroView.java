package Views;
import Models.Cliente;
import Services.ClienteService;

import java.util.Scanner;

public class CadastroView {
    private static ClienteService clienteService = new ClienteService();

    public static void cadastroCliente() {
        Scanner sc = new Scanner(System.in);
        Cliente clienteLogado = null;

        System.out.println("Já possui cadastro? (1: Sim / 2: Não)");
        int cadastro = sc.nextInt();
        sc.nextLine();

        if (cadastro == 1 ) {
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
        } else {
            System.out.println("Cadastro de Novo Cliente");
            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite seu email: ");
            String email = sc.nextLine();

            System.out.print("Digite seu telefone: ");
            String telefone = sc.nextLine();

            System.out.print("Digite sua senha: ");
            String senha = sc.nextLine();

            Cliente novoCliente = new Cliente();
            novoCliente.setNome(nome);
            novoCliente.setEmail(email);
            novoCliente.setTelefone(telefone);
            novoCliente.setSenha(senha);

            try {
                clienteService.inserir(novoCliente);
                System.out.println("Cliente cadastrado com sucesso!");

                System.out.println("Efetue o login:");
                System.out.print("   Email: ");
                email = sc.nextLine();
                System.out.print("   Senha: ");
                senha = sc.nextLine();

                clienteService.login(email, senha);
                System.out.println("Login realizado com sucesso!");
                SistemaView.iniciar();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
