package Services;

import Models.Cliente;
import State.Dados;
import java.util.ArrayList;

public class ClienteService {
    public ArrayList<Cliente> getClientes() {
        return Dados.getClientes();
    }

    public void inserir(Cliente cliente) {
        Dados.getClientes().add(cliente);
    }

    public Cliente getClientePorEmail(String email) {
        for (Cliente cl : Dados.getClientes()) {
            if (cl.getEmail().equals(email)) {
                return cl;
            }
        }
        return null;
    }

    public void alterar(Cliente clienteAlterado) throws Exception {
        Cliente cliente = getClientePorEmail(clienteAlterado.getEmail());

        if (cliente == null)
            throw new Exception("Não é possível alterar. Cliente não encontrado.");

        cliente.setNome(clienteAlterado.getNome());
        cliente.setTelefone(clienteAlterado.getTelefone());
    }

    public void excluir(String email) throws Exception {
        Cliente cliente = getClientePorEmail(email);

        if (cliente == null)
            throw new Exception("Não é possível excluir. Cliente não encontrado.");

        Dados.getClientes().remove(cliente);
    }

    public void login(String email, String senha) throws Exception {
        Cliente cliente = getClientePorEmail(email);

        if (cliente == null || !cliente.getSenha().equals(senha)) {
            throw new Exception("E-mail e/ou senha inválido(s)!");
        }

        Dados.setClienteLogado(cliente);
    }

    public void logout() {
        Dados.setClienteLogado(null);
    }

    public Cliente getClienteLogado() {
        return Dados.getClienteLogado();
    }
}
