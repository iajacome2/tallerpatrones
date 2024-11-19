package ec.edu.espe.tallersubscripcion.Servicios;



import ec.edu.espe.tallersubscripcion.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO modificarUsuario(Long id, UsuarioDTO usuarioDTO);
    void eliminarUsuario(Long id);
    UsuarioDTO consultarUsuario(Long id);
    List<UsuarioDTO> listarUsuarios();
}