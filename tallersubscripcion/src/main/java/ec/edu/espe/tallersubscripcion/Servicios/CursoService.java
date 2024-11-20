package ec.edu.espe.tallersubscripcion.Servicios;

import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import ec.edu.espe.tallersubscripcion.repositorios.CursoRepository;
import ec.edu.espe.tallersubscripcion.repositorios.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public CursoService(CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Curso crearCurso(Curso curso) {
        if (curso.getCreador().getTipoUsuario() != Usuario.TipoUsuario.CREADOR) {
            throw new RuntimeException("Solo usuarios con rol CREADOR pueden crear cursos.");
        }

        long cursosActivos = cursoRepository.findAll().stream()
                .filter(c -> c.getCreador().getId().equals(curso.getCreador().getId()) && c.getEstado() == Curso.EstadoCurso.ACTIVO)
                .count();

        if (cursosActivos >= 2) {
            throw new RuntimeException("Un creador no puede tener más de dos cursos activos.");
        }

        return cursoRepository.save(curso);
    }

    public Curso modificarCurso(Long id, Curso nuevosDatos) {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        cursoExistente.setNombre(nuevosDatos.getNombre());
        cursoExistente.setDescripcion(nuevosDatos.getDescripcion());
        cursoExistente.setEstado(nuevosDatos.getEstado());
        return cursoRepository.save(cursoExistente);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso obtenerCurso(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Curso cambiarEstadoCurso(Long id, Curso.EstadoCurso nuevoEstado) {
        Curso curso = obtenerCurso(id);
        curso.setEstado(nuevoEstado);
        return cursoRepository.save(curso);
    }
}

