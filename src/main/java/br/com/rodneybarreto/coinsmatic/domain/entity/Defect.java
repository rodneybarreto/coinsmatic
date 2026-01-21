package br.com.rodneybarreto.coinsmatic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "defects")
public class Defect {

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
    @Column(nullable = false)
    private String description;

    @Getter
    @Setter
    @Column(name = "estimated_value", columnDefinition = "double default 0")
    private double estimatedValue;

    @Getter
    @Setter
    @JoinColumn(name = "coin_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Coin coin;

}
