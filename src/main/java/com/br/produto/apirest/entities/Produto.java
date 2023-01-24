package com.br.produto.apirest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Produto {

    private String id;

    private long codigo;

    private String nome;

    private List<ClasseInvestimento> classesInvestimento;

    private double risco;

    public double getRisco() {
        if (classesInvestimento == null) {
            return 0.0;
        }
        List<ClasseInvestimento> classeInvestimentoValida = classesInvestimento.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (classeInvestimentoValida.isEmpty()) {
            return 0.0;
        }

        return classeInvestimentoValida.stream()
                .mapToDouble(this::getRisco)
                .sum() / classeInvestimentoValida.size();
    }

    private double getRisco(ClasseInvestimento classeInvestimento) {
        if (classeInvestimento.getRisco() == null) {
            return 0.0;
        }
        return classeInvestimento.getRisco();
    }
}
