package ec.edu.espe.tallersubscripcion;


import ec.edu.espe.tallersubscripcion.entidades.Curso;
import ec.edu.espe.tallersubscripcion.entidades.Usuario;
import ec.edu.espe.tallersubscripcion.entidades.Usuario.TipoUsuario;
import ec.edu.espe.tallersubscripcion.repositorios.CursoRepository;
import ec.edu.espe.tallersubscripcion.repositorios.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ec.edu.espe.tallersubscripcion.repositorios")

public class TallersubscripcionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallersubscripcionApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        return args -> {
            // Crear Usuarios
            Usuario admin = usuarioRepository.save(Usuario.builder()
                    .nombres("Administrador")
                    .apellidos("Sistema")
                    .email("admin@admin.com")
                    .contraseña("12345678")
                    .tipoUsuario(TipoUsuario.ADMINISTRADOR)
                    .build());

            Usuario creador1 = usuarioRepository.save(Usuario.builder()
                    .nombres("Carlos")
                    .apellidos("Creador")
                    .email("carlos.creador@example.com")
                    .contraseña("password1")
                    .tipoUsuario(TipoUsuario.CREADOR_DE_CURSOS)
                    .build());

            Usuario consumidor = usuarioRepository.save(Usuario.builder()
                    .nombres("Ana")
                    .apellidos("Consumidor")
                    .email("ana.consumidor@example.com")
                    .contraseña("password2")
                    .tipoUsuario(TipoUsuario.CONSUMIDOR_DE_CURSOS)
                    .build());

            // Crear Cursos
            cursoRepository.save(Curso.builder()
                    .nombre("Introducción a Java")
                    .descripcion("Curso básico de programación en Java")
                    .estado(Curso.EstadoCurso.ACTIVO)
                    .creador(creador1)
                    .build());

            cursoRepository.save(Curso.builder()
                    .nombre("Spring Boot Avanzado")
                    .descripcion("Curso avanzado de desarrollo de aplicaciones con Spring Boot")
                    .estado(Curso.EstadoCurso.EN_CONSTRUCCION)
                    .creador(creador1)
                    .build());

            cursoRepository.save(Curso.builder()
                    .nombre("Diseño de APIs RESTful")
                    .descripcion("Curso sobre mejores prácticas en el diseño de APIs RESTful")
                    .estado(Curso.EstadoCurso.INACTIVO)
                    .creador(creador1)
                    .build());
        };
    }
}
