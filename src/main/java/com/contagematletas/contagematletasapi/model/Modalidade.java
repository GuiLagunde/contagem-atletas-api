package com.contagematletas.contagematletasapi.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Modalidade")
public class Modalidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotEmpty(message = "O nome deve ser informado. Verifique!")
    @Column(name = "nome",nullable = false)
    private String nome;

    @NotNull(message = "Distância deve ser informada. Verifique!")
    @Column(name = "distancia", nullable = false)
    private Integer distancia;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;


}
