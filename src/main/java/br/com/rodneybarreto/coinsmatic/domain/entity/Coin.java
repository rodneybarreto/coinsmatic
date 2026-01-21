package br.com.rodneybarreto.coinsmatic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coins")
public class Coin {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 10, nullable = false, unique = true)
    private String code;

    @Getter
    @Setter
    @Column(length = 50, nullable = false)
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column(nullable = false)
    private double value;

    @Getter
    @Setter
    @OneToMany(mappedBy = "coin", fetch = FetchType.LAZY)
    private List<Defect> defects;

    @Getter
    @Setter
    @OneToMany(mappedBy = "coin", fetch = FetchType.LAZY)
    private List<Emission> emissions;

}
