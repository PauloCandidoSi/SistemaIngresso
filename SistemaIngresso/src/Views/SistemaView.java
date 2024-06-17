package Views;

import Services.ClienteService;
import Models.Cliente;

public class SistemaView {
    public static void iniciar() {
        ClienteService servico = new ClienteService();
        Cliente clienteLogado;

        boolean continuar;

        do {
            clienteLogado = servico.getClienteLogado();

            if (clienteLogado == null) {
                ClienteView.login();
            }

            clienteLogado = servico.getClienteLogado();

            if (clienteLogado != null) {
                continuar = apresentarMenu();
            } else {
                continuar = true;
            }
        } while (continuar);
    }

    private static boolean apresentarMenu() {
        ClienteView.apresentarMenu();
        return true;
    }
}
