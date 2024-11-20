package ec.edu.espe.tallersubscripcion;

import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Suscripcion;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import ec.edu.espe.tallersubscripcion.repositorios.CursoRepository;
import ec.edu.espe.tallersubscripcion.repositorios.SuscripcionRepository;
import ec.edu.espe.tallersubscripcion.repositorios.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TallersubscripcionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallersubscripcionApplication.class, args);
    }
//
//
//    @Bean
//    CommandLineRunner initData(
//            UsuarioRepository usuarioRepository,
//            CursoRepository cursoRepository,
//            SuscripcionRepository suscripcionRepository) {
//        return args -> {
//            // Crear Usuarios
//            Usuario admin = usuarioRepository.save(Usuario.builder()
//                    .nombres("Admin")
//                    .apellidos("Principal")
//                    .email("admin@admin.com")
//                    .password("12345678") // Contraseña en texto plano
//                    .tipoUsuario(Usuario.TipoUsuario.ADMINISTRADOR)
//                    .build());
//
//            Usuario creador1 = usuarioRepository.save(Usuario.builder()
//                    .nombres("Pedro")
//                    .apellidos("López")
//                    .email("pedro.lopez@example.com")
//                    .password("password") // Contraseña en texto plano
//                    .tipoUsuario(Usuario.TipoUsuario.CREADOR)
//                    .build());
//
//            Usuario creador2 = usuarioRepository.save(Usuario.builder()
//                    .nombres("Marta")
//                    .apellidos("González")
//                    .email("marta.gonzalez@example.com")
//                    .password("password") // Contraseña en texto plano
//                    .tipoUsuario(Usuario.TipoUsuario.CREADOR)
//                    .build());
//
//            Usuario consumidor = usuarioRepository.save(Usuario.builder()
//                    .nombres("Carlos")
//                    .apellidos("Pérez")
//                    .email("carlos.perez@example.com")
//                    .password("password") // Contraseña en texto plano
//                    .tipoUsuario(Usuario.TipoUsuario.CONSUMIDOR)
//                    .build());
//
//            // Crear Cursos
//            Curso curso1 = cursoRepository.save(Curso.builder()
//                    .nombre("Introducción a Java")
//                    .descripcion("Curso básico para aprender Java")
//                    .estado(Curso.EstadoCurso.ACTIVO)
//                    .creador(creador1)
//                    .build());
//
//            Curso curso2 = cursoRepository.save(Curso.builder()
//                    .nombre("Spring Boot Avanzado")
//                    .descripcion("Curso avanzado de Spring Boot")
//                    .estado(Curso.EstadoCurso.EN_CONSTRUCCION)
//                    .creador(creador1)
//                    .build());
//
//            Curso curso3 = cursoRepository.save(Curso.builder()
//                    .nombre("Bases de Datos con PostgreSQL")
//                    .descripcion("Aprende a usar PostgreSQL desde cero")
//                    .estado(Curso.EstadoCurso.ACTIVO)
//                    .creador(creador2)
//                    .build());
//
//            // Crear Suscripciones
//            suscripcionRepository.save(Suscripcion.builder()
//                    .usuario(consumidor)
//                    .curso(curso1)
//                    .fechaSuscripcion(LocalDateTime.now())
//                    .build());
//
//            suscripcionRepository.save(Suscripcion.builder()
//                    .usuario(consumidor)
//                    .curso(curso3)
//                    .fechaSuscripcion(LocalDateTime.now())
//                    .build());
//        };
//    }
}
