package br.com.rodneybarreto.coinsmatic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emissions")
public class Emission {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private int year;

    @Getter
    @Setter
    private long production;

    @Getter
    @Setter
    @Column(name = "mbc_value", columnDefinition = "double default 0 comment 'Muito Bem Conservada'")
    private double mbcValue;

    @Getter
    @Setter
    @Column(name = "s_value", columnDefinition = "double default 0 comment 'Soberba'")
    private double sValue;

    @Getter
    @Setter
    @Column(name = "fc_value", columnDefinition = "double default 0 comment 'Flor de Cunho'")
    private double fcValue;

    @Getter
    @Setter
    @JoinColumn(name = "coin_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Coin coin;

}
