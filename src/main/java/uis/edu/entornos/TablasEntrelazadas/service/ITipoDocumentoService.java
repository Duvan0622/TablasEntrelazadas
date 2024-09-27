package uis.edu.entornos.TablasEntrelazadas.service;

import uis.edu.entornos.TablasEntrelazadas.models.TipoDocumento;

import java.util.List;

public interface ITipoDocumentoService {
    List<TipoDocumento> getTipoDocumentos();
    TipoDocumento buscarTipoDocumento(Long id);
    TipoDocumento guardarTipoDocumento(TipoDocumento tipoDocumento);
    int borrarTipoDocumento(Long id);
}
