package uis.edu.entornos.TablasEntrelazadas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.TablasEntrelazadas.models.Usuario;
import uis.edu.entornos.TablasEntrelazadas.repository.UsuarioRepository;

import java.util.List;

@Service
@Transactional
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario nuevoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public int borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return 1;
    }
}
