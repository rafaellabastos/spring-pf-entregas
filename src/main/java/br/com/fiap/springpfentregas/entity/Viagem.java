package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_VIAGEM")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEM")
    @SequenceGenerator(name = "SQ_VIAGEM", sequenceName = "SQ_VIAGEM", allocationSize = 1)
    @Column(name = "ID_VIAGEM")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_VIAGEM_PRODUTO",
            joinColumns = {
                    @JoinColumn(
                            name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PRODUTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PRODUTO_VIAGEM"
                            )
                    )
            }
    )
    private Set<Produto> produtos = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_VIAGEM_PASSAGEIRO",
            joinColumns = {
                    @JoinColumn(
                            name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PASSAGEIRO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PASSAGEIRO",
                            referencedColumnName = "ID_PASSAGEIRO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PASSAGEIRO_VIAGEM"
                            )
                    )
            }
    )
    private Set<Passageiro> passageiros = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_VIAGEM_PESSOA"
            )
    )
    private Pessoa cliente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ENDERECO_ORIGEM",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_ORIGEM_PESSOA"
            )
    )
    private Endereco origem;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ENDERECO_DESTINO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_DESTINO_PESSOA"
            )
    )

    private Endereco destino;

    private LocalDateTime saida;
    private LocalDateTime chegada;
}
