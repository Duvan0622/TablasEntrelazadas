package uis.edu.entornos.TablasEntrelazadas.service;

import uis.edu.entornos.TablasEntrelazadas.models.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getProductos();
    Producto buscarProducto(Long id);
    Producto guardarProducto(Producto producto);
    int borrarProducto(Long id);
}
