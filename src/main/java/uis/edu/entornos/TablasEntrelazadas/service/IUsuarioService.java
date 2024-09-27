package uis.edu.entornos.TablasEntrelazadas.service;

import uis.edu.entornos.TablasEntrelazadas.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getUsuarios();
    Usuario nuevoUsuario(Usuario usuario);
    Usuario buscarUsuario(Long id);
    int borrarUsuario(Long id);
}
