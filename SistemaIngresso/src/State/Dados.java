package State;
import Models.*;

import java.util.ArrayList;

public class Dados {
    private static Usuario usuarioLogado = null;
    private static Cliente clienteLogado = null;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static ArrayList<Usuario> getUsuarios() {
        if (usuarios.isEmpty()) {
            Administrador adm = new Administrador();
            adm.setNome("Admin");
            adm.setEmail("admin@email.com");
            adm.setSenha("@admin123");
            adm.setPrimeiroLogin(false);
            usuarios.add(adm);
        }
        return usuarios;
    }

    public static ArrayList<Cliente> getClientes() {
        if (clientes.isEmpty()) {
            Cliente cl = new Cliente();
            cl.setNome("Paulo");
            cl.setEmail("email");
            cl.setSenha("123");
            cl.setCpf("11122233344");
            cl.setPrimeiroLogin(false);
            clientes.add(cl);
        }
        return clientes;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        Dados.usuarioLogado = usuarioLogado;
    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static void setClienteLogado(Cliente clienteLogado) {
        Dados.clienteLogado = clienteLogado;
    }
}
