package br.com.rodneybarreto.coinsmatic.service;

import br.com.rodneybarreto.coinsmatic.domain.dto.CoinValuesRequest;
import br.com.rodneybarreto.coinsmatic.repository.EmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmissionService {

    private final EmissionRepository repository;

    @Transactional
    public void updateValues(int year, String code, CoinValuesRequest request) {
        var emission = repository.findByYearAndCoinCode(year, code)
                .orElseThrow(() -> new RuntimeException("Emission not found"));

        emission.setMbcValue(request.mbcValue());
        emission.setSValue(request.sValue());
        emission.setFcValue(request.fcValue());

        repository.save(emission);
    }

}
