package edu.upb.ezo.service;


import ch.qos.logback.core.util.StringUtil;
import edu.upb.ezo.repository.repos.PublisherRepository;
import edu.upb.ezo.repository.dto.request.PublisherRequestDto;
import edu.upb.ezo.repository.dto.response.PublisherDto;
import edu.upb.ezo.repository.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class PublisherService {
    private final PublisherRepository repository;

    @Transactional
    public void save(PublisherRequestDto publisher) throws Exception {
        if (StringUtil.isNullOrEmpty(publisher.getNombre())) {
            log.error("Error al guardar publisher. El campo nombre null");
            throw new Exception("El campo nombre es null");
        }

        if (StringUtil.isNullOrEmpty(publisher.getFechaFundacion())) {
            log.error("Error al guardar publisher. El campo Descripcion null");
            throw new Exception("El campo Descripcion es null");
        }

        Publisher publisher1 = new Publisher();
        publisher1.setNombre(publisher.getNombre());
        publisher1.setFecha_fundacion(LocalDate.parse(publisher.getFechaFundacion()));
        this.repository.save(publisher1);
    }

    @Transactional(readOnly = true)
    public List<PublisherDto> listar() {
        return this.repository.findAllDto();
    }

    @Transactional(readOnly = true)
    public Optional<Publisher> findByID(UUID id) {
        return this.repository.findById(id);
    }

}
