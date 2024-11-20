package ec.edu.espe.tallersubscripcion.Controladores;

import ec.edu.espe.tallersubscripcion.Mapeadores.CursoMapper;
import ec.edu.espe.tallersubscripcion.Servicios.CursoService;
import ec.edu.espe.tallersubscripcion.Servicios.UsuarioService;
import ec.edu.espe.tallersubscripcion.dto.CursoDTO;
import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;
    private final UsuarioService usuarioService;

    public CursoController(CursoService cursoService, UsuarioService usuarioService) {
        this.cursoService = cursoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody @Valid CursoDTO cursoDTO) {
        Usuario creador = usuarioService.obtenerUsuario(cursoDTO.getCreadorId());
        Curso curso = CursoMapper.toEntity(cursoDTO, creador);
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDTO(nuevoCurso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> modificarCurso(@PathVariable Long id, @RequestBody @Valid CursoDTO cursoDTO) {
        Usuario creador = usuarioService.obtenerUsuario(cursoDTO.getCreadorId());
        Curso nuevosDatos = CursoMapper.toEntity(cursoDTO, creador);
        Curso cursoActualizado = cursoService.modificarCurso(id, nuevosDatos);
        return ResponseEntity.ok(CursoMapper.toDTO(cursoActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerCurso(@PathVariable Long id) {
        Curso curso = cursoService.obtenerCurso(id);
        return ResponseEntity.ok(CursoMapper.toDTO(curso));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<CursoDTO> cambiarEstadoCurso(@PathVariable Long id, @RequestBody String nuevoEstado) {
        Curso.EstadoCurso estado = Curso.EstadoCurso.valueOf(nuevoEstado.toUpperCase());
        Curso cursoActualizado = cursoService.cambiarEstadoCurso(id, estado);
        return ResponseEntity.ok(CursoMapper.toDTO(cursoActualizado));
    }
}

