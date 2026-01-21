package br.com.rodneybarreto.coinsmatic.repository;

import br.com.rodneybarreto.coinsmatic.domain.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

    Optional<Coin> findByCode(String code);

}
