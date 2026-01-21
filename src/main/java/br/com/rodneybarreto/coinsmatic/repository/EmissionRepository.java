package br.com.rodneybarreto.coinsmatic.repository;

import br.com.rodneybarreto.coinsmatic.domain.entity.Emission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmissionRepository extends JpaRepository<Emission, Long> {

    Optional<Emission> findByYearAndCoinCode(int year, String code);

}
