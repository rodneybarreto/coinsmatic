package br.com.rodneybarreto.coinsmatic.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;

@Builder
public record CoinValuesRequest(
        @JsonAlias("mbc_value")
        double mbcValue,

        @JsonAlias("s_value")
        double sValue,

        @JsonAlias("fc_value")
        double fcValue
) { }
