package uis.edu.entornos.TablasEntrelazadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.TablasEntrelazadas.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
