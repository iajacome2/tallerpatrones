package ec.edu.espe.tallersubscripcion.Mapeadores;

import ec.edu.espe.tallersubscripcion.dto.CursoDTO;
import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;

public class CursoMapper {
    public static CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setEstado(curso.getEstado().name());
        dto.setCreadorId(curso.getCreador().getId());
        return dto;
    }

    public static Curso toEntity(CursoDTO dto, Usuario creador) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setEstado(Curso.EstadoCurso.valueOf(dto.getEstado()));
        curso.setCreador(creador);
        return curso;
    }
}
