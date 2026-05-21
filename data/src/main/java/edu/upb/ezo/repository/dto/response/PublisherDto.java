package edu.upb.ezo.repository.dto.response;

import edu.upb.ezo.repository.entity.Publisher;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class PublisherDto {
    private UUID id;
    private String nombre;
    private String pais;
    private String fechaFundacion;

    public PublisherDto(Publisher publisher) {
        this.id = publisher.getId();
        this.nombre = publisher.getNombre();
        this.pais = publisher.getPais() == null ? null : publisher.getPais().getNombre();
        LocalDate fd = publisher.getFecha_fundacion();
        this.fechaFundacion = Objects.toString(fd, null);
    }

    public PublisherDto(UUID id, String nombre, String pais, LocalDate fechaFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.fechaFundacion = Objects.toString(fechaFundacion, null);
    }

    public PublisherDto(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PublisherDto(String nombre) {
        this.nombre = nombre;
    }

}
