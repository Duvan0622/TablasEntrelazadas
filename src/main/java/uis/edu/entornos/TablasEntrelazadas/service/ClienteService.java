package uis.edu.entornos.TablasEntrelazadas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.TablasEntrelazadas.models.Cliente;
import uis.edu.entornos.TablasEntrelazadas.repository.ClienteRepository;

import java.util.List;
@Service
@Transactional
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClienteId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public int borrarCliente(Long id) {
        clienteRepository.deleteById(id);
        return 1;
    }
}
