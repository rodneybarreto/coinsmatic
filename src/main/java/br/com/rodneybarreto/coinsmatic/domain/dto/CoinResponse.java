package br.com.rodneybarreto.coinsmatic.domain.dto;

import br.com.rodneybarreto.coinsmatic.domain.entity.Coin;
import lombok.Builder;

import java.util.List;

@Builder
public record CoinResponse(
        String code,

        String name,

        String description,

        double value,

        List<DefectResponse> defects,

        List<EmissionResponse> emissions
) {

    public CoinResponse(Coin coin) {
        this(
                coin.getCode(),
                coin.getName(),
                coin.getDescription(),
                coin.getValue(),
                coin.getDefects().stream().map(DefectResponse::new).toList(),
                coin.getEmissions().stream().map(EmissionResponse::new).toList()
        );
    }

}
