package ec.edu.espe.tallersubscripcion.Controladores;

import ec.edu.espe.tallersubscripcion.Mapeadores.UsuarioMapper;
import ec.edu.espe.tallersubscripcion.Servicios.UsuarioService;
import ec.edu.espe.tallersubscripcion.dto.UsuarioDTO;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

//    @PostMapping
//    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
//        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
//        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDTO(nuevoUsuario));
//    }
    @PostMapping("/usuarios")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("La contraseña es obligatoria.");
        }
        usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente.");
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<UsuarioDTO> modificarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO) {
//        Usuario nuevosDatos = UsuarioMapper.toEntity(usuarioDTO);
//        Usuario usuarioActualizado = usuarioService.modificarUsuario(id, nuevosDatos);
//        return ResponseEntity.ok(UsuarioMapper.toDTO(usuarioActualizado));
//    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
            if (usuarioExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            usuarioExistente.setNombres(usuario.getNombres());
            usuarioExistente.setApellidos(usuario.getApellidos());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());

            Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuarioExistente);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioActualizado);
        } catch (Exception e) {
            e.printStackTrace(); // Esto es útil para ver el error en los logs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuario(id);
        return ResponseEntity.ok(UsuarioMapper.toDTO(usuario));
    }
}

