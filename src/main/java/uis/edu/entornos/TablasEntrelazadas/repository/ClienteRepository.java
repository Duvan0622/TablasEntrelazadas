package uis.edu.entornos.TablasEntrelazadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.TablasEntrelazadas.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
