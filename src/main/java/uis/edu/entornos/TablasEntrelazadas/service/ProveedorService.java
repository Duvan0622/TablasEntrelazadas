package uis.edu.entornos.TablasEntrelazadas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.TablasEntrelazadas.models.Proveedor;
import uis.edu.entornos.TablasEntrelazadas.repository.ProveedorRepository;

import java.util.List;

@Service
@Transactional
public class ProveedorService implements IProveedorService{
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor buscarProveedor(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public int borrarProveedor(Long id) {
        proveedorRepository.deleteById(id);
        return 1;
    }
}
