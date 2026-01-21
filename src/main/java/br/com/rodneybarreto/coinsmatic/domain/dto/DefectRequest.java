package br.com.rodneybarreto.coinsmatic.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DefectRequest(
        @JsonAlias("coin_code")
        @NotBlank(message = "Coin code is required")
        String coinCode,

        @NotNull(message = "Year is required")
        int year,

        @NotBlank(message = "Description is required")
        String description,

        @JsonAlias("estimated_value")
        double estimatedValue
) {
}
