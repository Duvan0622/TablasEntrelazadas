package uis.edu.entornos.TablasEntrelazadas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.TablasEntrelazadas.models.Producto;
import uis.edu.entornos.TablasEntrelazadas.repository.ProductoRepository;

import java.util.List;
@Service
@Transactional
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public int borrarProducto(Long id) {
        productoRepository.deleteById(id);
        return 1;
    }
}
