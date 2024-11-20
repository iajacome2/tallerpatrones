package ec.edu.espe.tallersubscripcion.dto;

import lombok.Data;

@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String estado; // EN_CONSTRUCCION, ACTIVO, INACTIVO
    private Long creadorId; // Relación con el creador del curso
}
