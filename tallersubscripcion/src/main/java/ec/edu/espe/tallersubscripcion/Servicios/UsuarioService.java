package ec.edu.espe.tallersubscripcion.Servicios;

import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import ec.edu.espe.tallersubscripcion.repositorios.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario modificarUsuario(Long id, Usuario nuevosDatos) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioExistente.setNombres(nuevosDatos.getNombres());
        usuarioExistente.setApellidos(nuevosDatos.getApellidos());
        usuarioExistente.setEmail(nuevosDatos.getEmail());
        usuarioExistente.setPassword(nuevosDatos.getPassword());
        usuarioExistente.setTipoUsuario(nuevosDatos.getTipoUsuario());
        return usuarioRepository.save(usuarioExistente);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);  // Guardar el usuario actualizado
    }
}

