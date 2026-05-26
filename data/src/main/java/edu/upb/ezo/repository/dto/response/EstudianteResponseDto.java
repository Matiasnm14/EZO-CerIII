package edu.upb.ezo.repository.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record EstudianteResponseDto(UUID id,String nombre, String apellido, @JsonProperty(namespace = "id_matera") UUID materiaId, int nota, String telefono,String ci) {
}
