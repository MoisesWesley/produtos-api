package com.br.produto.apirest.entities;

import com.br.produto.apirest.services.exceptions.ResourceNotFoundException;
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

    public boolean isValid() {
        if (codigo > 0 && nome != null && !nome.isEmpty()) {
            return true;
        }
        throw new ResourceNotFoundException("Os campos codigo e nome não podem ser nulos ou vazios");
    }
}
