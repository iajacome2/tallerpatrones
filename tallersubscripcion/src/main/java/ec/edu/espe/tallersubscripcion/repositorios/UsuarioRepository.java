package ec.edu.espe.tallersubscripcion.repositorios;

import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Suscripcion;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

