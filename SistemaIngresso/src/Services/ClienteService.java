package Services;

import Models.Cliente;
import State.Dados;

public class ClienteService {
    public void inserir(Cliente cliente) {
        Dados.getClientes().add(cliente);
    }

    public void login(String email, String senha) throws Exception {
        for (Cliente cliente : Dados.getClientes()) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                Dados.setClienteLogado(cliente);
                return;
            }
        }
        throw new Exception("Email ou senha inválidos.");
    }

    public Cliente getClienteLogado() {
        return Dados.getClienteLogado();
    }

    public void logout() {
        Dados.setClienteLogado(null);
    }
}
