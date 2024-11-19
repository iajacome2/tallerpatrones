package ec.edu.espe.tallersubscripcion.repositorios;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}