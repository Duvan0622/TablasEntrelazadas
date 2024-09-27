package uis.edu.entornos.TablasEntrelazadas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.TablasEntrelazadas.models.TipoDocumento;
import uis.edu.entornos.TablasEntrelazadas.repository.TipoDocumentoRepository;

import java.util.List;

@Service
@Transactional
public class TipoDocumentoService implements ITipoDocumentoService{
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> getTipoDocumentos() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento buscarTipoDocumento(Long id) {
        return tipoDocumentoRepository.findById(id).orElse(null);
    }

    @Override
    public TipoDocumento guardarTipoDocumento(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public int borrarTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
        return 1;
    }
}
