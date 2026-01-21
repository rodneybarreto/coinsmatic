package br.com.rodneybarreto.coinsmatic.controller;

import br.com.rodneybarreto.coinsmatic.domain.dto.CoinRequest;
import br.com.rodneybarreto.coinsmatic.domain.dto.CoinResponse;
import br.com.rodneybarreto.coinsmatic.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coins")
public class CoinsController {

    private final CoinService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CoinRequest request, UriComponentsBuilder uriComponentsBuilder) {
        String code = service.create(request);
        var uri = uriComponentsBuilder.path("/coins/{code}").buildAndExpand(code).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoinResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinResponse> findByCode(@PathVariable String code) {
        return ResponseEntity.ok().body(service.findByCode(code));
    }

}
