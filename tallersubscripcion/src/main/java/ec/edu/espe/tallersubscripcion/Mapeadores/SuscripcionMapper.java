package ec.edu.espe.tallersubscripcion.Mapeadores;

import ec.edu.espe.tallersubscripcion.dto.SuscripcionDTO;
import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Suscripcion;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;

public class SuscripcionMapper {
    public static SuscripcionDTO toDTO(Suscripcion suscripcion) {
        SuscripcionDTO dto = new SuscripcionDTO();
        dto.setId(suscripcion.getId());
        dto.setUsuarioId(suscripcion.getUsuario().getId());
        dto.setCursoId(suscripcion.getCurso().getId());
        dto.setFechaSuscripcion(suscripcion.getFechaSuscripcion());
        return dto;
    }

    public static Suscripcion toEntity(SuscripcionDTO dto, Usuario usuario, Curso curso) {
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setId(dto.getId());
        suscripcion.setUsuario(usuario);
        suscripcion.setCurso(curso);
        suscripcion.setFechaSuscripcion(dto.getFechaSuscripcion());
        return suscripcion;
    }

}

