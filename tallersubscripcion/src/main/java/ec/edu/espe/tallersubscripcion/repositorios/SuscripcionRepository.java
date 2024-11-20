package ec.edu.espe.tallersubscripcion.repositorios;

import ec.edu.espe.tallersubscripcion.entidades.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
    List<Suscripcion> findByUsuarioId(Long usuarioId);
    List<Suscripcion> findByCursoId(Long cursoId);
}