package edu.upb.ezo.repository.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public interface EstudianteIntDto {
    UUID getId();
    String getNombre();
    String getApellido();
    int getNota();
    UUID getMateriaId();
    @JsonProperty("nro_telefono")
    String getTelefono();
    @JsonProperty("nro_ci")
    String getCi();
}
