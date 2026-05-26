package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.upb.ezo.repository.entity.Materia;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class EstudianteRequestDto {
    private UUID id;
    private String nombre;

    private String apellido;

    private UUID id_materia;

    private int nota;

    @JsonProperty("nro_telefono")
    private String telefono;

    @JsonProperty("nro_documento")
    private String ci;
}
