package br.com.rodneybarreto.coinsmatic.service;

import br.com.rodneybarreto.coinsmatic.domain.dto.DefectRequest;
import br.com.rodneybarreto.coinsmatic.domain.entity.Defect;
import br.com.rodneybarreto.coinsmatic.repository.CoinRepository;
import br.com.rodneybarreto.coinsmatic.repository.DefectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.rodneybarreto.coinsmatic.service.CoinService.COIN_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DefectService {

    private final CoinRepository coinRepository;
    private final DefectRepository defectRepository;

    @Transactional
    public void create(DefectRequest request) {
        var coin = coinRepository.findByCode(request.coinCode()).orElseThrow(() -> new RuntimeException(COIN_NOT_FOUND));

        var defect = Defect.builder()
                .year(request.year())
                .description(request.description())
                .estimatedValue(request.estimatedValue())
                .coin(coin)
                .build();

        defectRepository.save(defect);
    }

}
