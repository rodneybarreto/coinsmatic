package br.com.rodneybarreto.coinsmatic.service;

import br.com.rodneybarreto.coinsmatic.domain.dto.CoinRequest;
import br.com.rodneybarreto.coinsmatic.domain.dto.CoinResponse;
import br.com.rodneybarreto.coinsmatic.domain.entity.Coin;
import br.com.rodneybarreto.coinsmatic.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinService {

    public static final String COIN_NOT_FOUND = "Coin not found";

    private final CoinRepository repository;

    @Transactional
    public String create(CoinRequest request) {
        var coin = Coin.builder()
                .code(request.code())
                .name(request.name())
                .description(request.description())
                .value(request.value())
                .build();
        repository.save(coin);
        return coin.getCode();
    }

    @Transactional(readOnly = true)
    public List<CoinResponse> findAll() {
        return repository.findAll().stream().map(CoinResponse::new).toList();
    }

    @Transactional(readOnly = true)
    public CoinResponse findByCode(String code) {
        return repository.findByCode(code)
                .map(CoinResponse::new)
                .orElseThrow(() -> new RuntimeException(COIN_NOT_FOUND));
    }

}
