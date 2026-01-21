package br.com.rodneybarreto.coinsmatic.repository;

import br.com.rodneybarreto.coinsmatic.domain.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {
}
