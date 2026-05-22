package edu.upb.ezo.repository.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class IdRequestDto {
    private UUID id;
}
