package br.com.rodneybarreto.coinsmatic.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CoinValuesRequest(
        @JsonAlias("mbc_value")
        @NotNull(message = "MBC value is required")
        double mbcValue,

        @JsonAlias("s_value")
        @NotNull(message = "S value is required")
        double sValue,

        @JsonAlias("fc_value")
        @NotNull(message = "FC value is required")
        double fcValue
) { }
