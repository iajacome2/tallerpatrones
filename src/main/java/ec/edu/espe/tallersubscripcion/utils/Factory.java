package ec.edu.espe.tallersubscripcion.utils;


import  ec.edu.espe.tallersubscripcion.dto.CursoDTO;
import  ec.edu.espe.tallersubscripcion.dto.UsuarioDTO;
import  ec.edu.espe.tallersubscripcion.entidades.Curso;
import  ec.edu.espe.tallersubscripcion.entidades.Usuario;

public class Factory {

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombres(usuario.getNombres());
        dto.setApellidos(usuario.getApellidos());
        dto.setEmail(usuario.getEmail());
        dto.setTipoUsuario(usuario.getTipoUsuario().name());
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(dto.getEmail());
        usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(dto.getTipoUsuario()));
        return usuario;
    }

    public static CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setEstado(curso.getEstado().name());
        dto.setCreadorId(curso.getCreador().getId());
        return dto;
    }

    public static Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setEstado(Curso.EstadoCurso.valueOf(dto.getEstado()));
        return curso;
    }
}
