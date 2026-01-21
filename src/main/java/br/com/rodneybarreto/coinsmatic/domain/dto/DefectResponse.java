package br.com.rodneybarreto.coinsmatic.domain.dto;

import br.com.rodneybarreto.coinsmatic.domain.entity.Defect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record DefectResponse(
        int year,

        String description,

        @JsonProperty("estimated_value")
        double estimatedValue
) {

    public DefectResponse(Defect defect) {
        this(defect.getYear(), defect.getDescription(), defect.getEstimatedValue());
    }

}
