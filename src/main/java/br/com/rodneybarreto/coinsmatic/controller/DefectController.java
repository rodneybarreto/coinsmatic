package br.com.rodneybarreto.coinsmatic.controller;

import br.com.rodneybarreto.coinsmatic.domain.dto.DefectRequest;
import br.com.rodneybarreto.coinsmatic.service.DefectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/defects")
public class DefectController {

    private final DefectService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody DefectRequest request) {
        service.create(request);
        return ResponseEntity.ok().build();
    }

}
