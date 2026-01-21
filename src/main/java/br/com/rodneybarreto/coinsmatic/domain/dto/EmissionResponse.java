package br.com.rodneybarreto.coinsmatic.domain.dto;

import br.com.rodneybarreto.coinsmatic.domain.entity.Emission;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.text.NumberFormat;

@Builder
public record EmissionResponse(
        int year,

        String production,

        @JsonProperty("mbc_value")
        double mbcValue,

        @JsonProperty("s_value")
        double sValue,

        @JsonProperty("fc_value")
        double fcValue
) {

    public EmissionResponse(Emission emission) {
        this(
                emission.getYear(),
                NumberFormat.getInstance().format(emission.getProduction()),
                emission.getMbcValue(),
                emission.getSValue(),
                emission.getFcValue()
        );
    }

}
