package uis.edu.entornos.TablasEntrelazadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.TablasEntrelazadas.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
