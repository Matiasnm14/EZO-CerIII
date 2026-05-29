package edu.upb.ezo.implementation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class B2BAuthRequest {
    private String email;
    private String passwordHash;
}
