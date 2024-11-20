package ec.edu.espe.tallersubscripcion.dto;


import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    private String tipoUsuario; // ADMINISTRADOR, CREADOR, CONSUMIDOR

}
