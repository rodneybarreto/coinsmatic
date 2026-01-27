package br.com.rodneybarreto.coinsmatic.controller;

import br.com.rodneybarreto.coinsmatic.domain.dto.CoinRequest;
import br.com.rodneybarreto.coinsmatic.domain.dto.CoinResponse;
import br.com.rodneybarreto.coinsmatic.service.CoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coins")
public class CoinsController {

    private final CoinService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody CoinRequest request, UriComponentsBuilder uriBuilder) {
        String code = service.create(request);
        var uri = uriBuilder.path("/coins/{code}").buildAndExpand(code).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoinResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{code}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinResponse> findByCode(@PathVariable String code) {
        return ResponseEntity.ok().body(service.findByCode(code));
    }

}
