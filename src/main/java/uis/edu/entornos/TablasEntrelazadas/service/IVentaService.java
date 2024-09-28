package uis.edu.entornos.TablasEntrelazadas.service;

import uis.edu.entornos.TablasEntrelazadas.models.Venta;

import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();
    Venta buscarVenta(Long id);
    Venta guardarVenta(Venta venta);
    int borrarVenta(Long id);
}
