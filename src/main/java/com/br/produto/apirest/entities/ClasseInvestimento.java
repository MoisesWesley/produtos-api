package com.br.produto.apirest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClasseInvestimento {

    private Integer codigo;

    private String nome;

    private Double risco;
}
