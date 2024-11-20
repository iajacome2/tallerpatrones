package ec.edu.espe.tallersubscripcion.Servicios;

import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Suscripcion;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import ec.edu.espe.tallersubscripcion.repositorios.CursoRepository;
import ec.edu.espe.tallersubscripcion.repositorios.SuscripcionRepository;
import ec.edu.espe.tallersubscripcion.repositorios.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuscripcionService {
    private final SuscripcionRepository suscripcionRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public SuscripcionService(SuscripcionRepository suscripcionRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.suscripcionRepository = suscripcionRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public Suscripcion suscribirACurso(Long usuarioId, Long cursoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        boolean yaSuscrito = suscripcionRepository.findByUsuarioId(usuarioId).stream()
                .anyMatch(s -> s.getCurso().getCreador().getId().equals(curso.getCreador().getId()));

        if (yaSuscrito) {
            throw new RuntimeException("Un consumidor solo puede estar suscrito a un curso de cada creador.");
        }

        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setUsuario(usuario);
        suscripcion.setCurso(curso);
        suscripcion.setFechaSuscripcion(LocalDateTime.now());
        return suscripcionRepository.save(suscripcion);
    }

    public void cancelarSuscripcion(Long usuarioId, Long cursoId) {
        Suscripcion suscripcion = suscripcionRepository.findByUsuarioId(usuarioId).stream()
                .filter(s -> s.getCurso().getId().equals(cursoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));
        suscripcionRepository.delete(suscripcion);
    }

    public List<Suscripcion> obtenerTodasSuscripciones() {
        return suscripcionRepository.findAll();  // Esto recupera todas las suscripciones
    }

}
