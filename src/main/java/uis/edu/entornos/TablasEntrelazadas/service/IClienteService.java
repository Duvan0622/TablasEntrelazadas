package uis.edu.entornos.TablasEntrelazadas.service;

import uis.edu.entornos.TablasEntrelazadas.models.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getClientes();
    Cliente buscarClienteId(Long id);
    Cliente guardarCliente(Cliente cliente);
    int borrarCliente(Long id);
}
