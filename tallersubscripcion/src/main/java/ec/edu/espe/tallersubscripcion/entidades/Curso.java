package ec.edu.espe.tallersubscripcion.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoCurso estado;

    @ManyToOne
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;

    // Getters y setters

    public enum EstadoCurso {
        EN_CONSTRUCCION,
        ACTIVO,
        INACTIVO
    }
}



