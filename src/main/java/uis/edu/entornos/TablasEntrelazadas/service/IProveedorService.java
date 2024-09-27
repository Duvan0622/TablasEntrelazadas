package uis.edu.entornos.TablasEntrelazadas.service;

import uis.edu.entornos.TablasEntrelazadas.models.Proveedor;

import java.util.List;

public interface IProveedorService {
    List<Proveedor> getProveedores();
    Proveedor buscarProveedor(Long id);
    Proveedor guardarProveedor(Proveedor proveedor);
    int borrarProveedor(Long id);
}
