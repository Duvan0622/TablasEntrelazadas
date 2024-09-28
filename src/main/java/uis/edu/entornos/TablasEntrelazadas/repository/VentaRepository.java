package uis.edu.entornos.TablasEntrelazadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.TablasEntrelazadas.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
