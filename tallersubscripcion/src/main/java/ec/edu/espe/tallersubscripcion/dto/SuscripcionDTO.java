package ec.edu.espe.tallersubscripcion.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SuscripcionDTO {
    private Long id;
    private Long usuarioId; // Relación con el usuario
    private Long cursoId; // Relación con el curso
    private LocalDateTime fechaSuscripcion;
}

