package uis.edu.entornos.TablasEntrelazadas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.TablasEntrelazadas.models.Venta;
import uis.edu.entornos.TablasEntrelazadas.repository.VentaRepository;

import java.util.List;
@Service
@Transactional
public class VentaService implements IVentaService{
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta buscarVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public int borrarVenta(Long id) {
        ventaRepository.deleteById(id);
        return 1;
    }
}
