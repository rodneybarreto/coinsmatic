package br.com.rodneybarreto.coinsmatic.controller;

import br.com.rodneybarreto.coinsmatic.domain.dto.CoinValuesRequest;
import br.com.rodneybarreto.coinsmatic.service.EmissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emissions")
public class EmissionController {

    private final EmissionService service;

    @PatchMapping(value = "/{year}/coins/{code}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateValues(
            @PathVariable int year,
            @PathVariable String code,
            @Valid @RequestBody CoinValuesRequest request
    ) {
        service.updateValues(year, code, request);
        return ResponseEntity.noContent().build();
    }

}
