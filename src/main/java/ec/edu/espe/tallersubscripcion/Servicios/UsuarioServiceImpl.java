package ec.edu.espe.tallersubscripcion.Servicios;


import ec.edu.espe.tallersubscripcion.dto.UsuarioDTO;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import ec.edu.espe.tallersubscripcion.repositorios.UsuarioRepository;
import ec.edu.espe.tallersubscripcion.Servicios.UsuarioService;
import ec.edu.espe.tallersubscripcion.utils.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = Factory.toEntity(usuarioDTO);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return Factory.toDTO(nuevoUsuario);
    }

    @Override
    public UsuarioDTO modificarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombres(usuarioDTO.getNombres());
        usuario.setApellidos(usuarioDTO.getApellidos());
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return Factory.toDTO(usuarioActualizado);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO consultarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .map(Factory::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(Factory::toDTO).collect(Collectors.toList());
    }
}
