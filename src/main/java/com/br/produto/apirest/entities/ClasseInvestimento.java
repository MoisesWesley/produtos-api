package com.br.produto.apirest.entities;

public class ClasseInvestimento {

    private Integer codigo;

    private String nome;

    private Double risco;

    public ClasseInvestimento() {
    }

    public ClasseInvestimento(Integer codigo, String nome, Double risco) {
        this.codigo = codigo;
        this.nome = nome;
        this.risco = risco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRisco() {
        return risco;
    }

    public void setRisco(Double risco) {
        this.risco = risco;
    }
}
