package edu.upb.ezo.repository.dto.response;


import edu.upb.ezo.repository.entity.Developer;
import edu.upb.ezo.repository.entity.Pais;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DeveloperResponseDto {
    private UUID id;
    private String nombre;
    private Pais pais;
    private LocalDate fechaFundacion;

    public DeveloperResponseDto(UUID id, String nombre, Pais pais, LocalDate fechaFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.fechaFundacion = fechaFundacion;
    }

    public DeveloperResponseDto(Developer developer) {
        this.id = developer.getId();
        this.nombre = developer.getNombre();
        this.pais = developer.getPais();
        this.fechaFundacion = developer.getFechaFundacion();
    }
}
