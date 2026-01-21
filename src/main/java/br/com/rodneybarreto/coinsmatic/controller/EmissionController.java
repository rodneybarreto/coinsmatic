package br.com.rodneybarreto.coinsmatic.controller;

import br.com.rodneybarreto.coinsmatic.domain.dto.CoinValuesRequest;
import br.com.rodneybarreto.coinsmatic.service.EmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emissions")
public class EmissionController {

    private final EmissionService service;

    @PatchMapping(value = "/{year}/coins/{code}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateValues(
            @PathVariable int year,
            @PathVariable String code,
            @RequestBody CoinValuesRequest request
    ) {
        service.updateValues(year, code, request);
        return ResponseEntity.noContent().build();
    }

}
