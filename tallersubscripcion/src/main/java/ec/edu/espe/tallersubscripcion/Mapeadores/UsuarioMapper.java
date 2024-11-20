package ec.edu.espe.tallersubscripcion.Mapeadores;

import ec.edu.espe.tallersubscripcion.dto.UsuarioDTO;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombres(usuario.getNombres());
        dto.setApellidos(usuario.getApellidos());
        dto.setEmail(usuario.getEmail());
        dto.setPassword(usuario.getPassword());
        dto.setTipoUsuario(usuario.getTipoUsuario().name());
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(dto.getEmail());
        dto.setPassword(usuario.getPassword());
        usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(dto.getTipoUsuario()));
        return usuario;
    }
}
