package br.com.rodneybarreto.coinsmatic.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CoinRequest(
        @NotBlank(message = "O código é obrigatório")
        String code,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        String description,

        @NotNull(message = "O valor é obrigatório")
        double value
) { }
