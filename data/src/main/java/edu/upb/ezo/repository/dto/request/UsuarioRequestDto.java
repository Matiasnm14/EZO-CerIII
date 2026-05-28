package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("nombre_usuario")
    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    private String nombreUsuario;

    @JsonProperty("email")
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede estar en blanco")
    private String email;

    @JsonProperty("id_pais")
    private UUID idPais; // Opcional en BD, si lo requieres obligatorio añade @NotNull/@NotBlank

    @JsonProperty("password")
    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String passwordHash; // Se recibe plano y se procesa a hash en el servicio

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("fecha_nacimiento")
    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @NotBlank(message = "La fecha de nacimiento no puede estar en blanco")
    private String fechaNacimiento;

    @JsonProperty("telefono")
    @NotNull(message = "El teléfono no puede ser nulo")
    @NotBlank(message = "El teléfono no puede estar en blanco")
    private String telefono;

    @JsonProperty("rol")
    @NotNull(message = "El rol no puede ser nulo")
    @NotBlank(message = "El rol no puede estar en blanco")
    private String rol;
}
