package ec.edu.espe.tallersubscripcion.Controladores;

import ec.edu.espe.tallersubscripcion.Mapeadores.SuscripcionMapper;
import ec.edu.espe.tallersubscripcion.Servicios.CursoService;
import ec.edu.espe.tallersubscripcion.Servicios.SuscripcionService;
import ec.edu.espe.tallersubscripcion.Servicios.UsuarioService;
import ec.edu.espe.tallersubscripcion.dto.SuscripcionDTO;
import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Suscripcion;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {
    private final SuscripcionService suscripcionService;
    private final UsuarioService usuarioService;
    private final CursoService cursoService;

    public SuscripcionController(SuscripcionService suscripcionService, UsuarioService usuarioService, CursoService cursoService) {
        this.suscripcionService = suscripcionService;
        this.usuarioService = usuarioService;
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<SuscripcionDTO> suscribirACurso(@RequestParam Long usuarioId, @RequestParam Long cursoId) {
        Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
        Curso curso = cursoService.obtenerCurso(cursoId);

        Suscripcion nuevaSuscripcion = suscripcionService.suscribirACurso(usuarioId, cursoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(SuscripcionMapper.toDTO(nuevaSuscripcion));
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelarSuscripcion(@RequestParam Long usuarioId, @RequestParam Long cursoId) {
        Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
        Curso curso = cursoService.obtenerCurso(cursoId);

        suscripcionService.cancelarSuscripcion(usuarioId, cursoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SuscripcionDTO>> obtenerTodasSuscripciones() {
        List<Suscripcion> suscripciones = suscripcionService.obtenerTodasSuscripciones();
        // Mapeamos las suscripciones a DTOs para la respuesta
        List<SuscripcionDTO> suscripcionesDTO = suscripciones.stream()
                .map(SuscripcionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(suscripcionesDTO);
    }
}

