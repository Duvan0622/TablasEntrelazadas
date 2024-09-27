package uis.edu.entornos.TablasEntrelazadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.TablasEntrelazadas.models.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
}
