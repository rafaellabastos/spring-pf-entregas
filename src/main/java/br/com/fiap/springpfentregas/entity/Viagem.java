package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
