package com.br.produto.apirest.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Produto {

    private String id;

    private long codigo;

    private String nome;

    private List<ClasseInvestimento> classesInvestimento;

    private double risco;

    public Produto() {
    }

    public Produto(String id, long codigo, String nome, List<ClasseInvestimento> classesInvestimento, double risco) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.classesInvestimento = classesInvestimento;
        this.risco = risco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ClasseInvestimento> getClassesInvestimento() {
        return classesInvestimento;
    }

    public void setClassesInvestimento(List<ClasseInvestimento> classesInvestimento) {
        this.classesInvestimento = classesInvestimento;
    }

    public double getRisco() {
        return risco;
    }

    public void setRisco(double risco) {
        this.risco = risco;
    }
}
