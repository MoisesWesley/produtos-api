package com.br.produto.apirest.entities

import spock.lang.Specification

class ProdutoTest extends Specification {

    def "should the risk when passing classeInvestimento"(){
        given:
            Produto produto = new Produto()
            produto.setClassesInvestimento(classeInvestimento)
        when:
            double result = produto.getRisco()
        then:
            result == expected
        where:
            expected                        | classeInvestimento
            0                               | null
            0                               | [null]
            0                               | [new ClasseInvestimento(codigo: 123, nome: "Pós fixado", risco: null)]
            2                               | [new ClasseInvestimento(codigo: 123, nome: "Pós fixado", risco: 2), null]
            2                               | [new ClasseInvestimento(codigo: 123, nome: "Pós fixado", risco: 2), new ClasseInvestimento(codigo: 123, nome: "Pós fixado", risco: 2)]
    }

    def "should return produto valid"() {
        given:
            Produto produto = new Produto()
            produto.setCodigo(codigo)
            produto.setNome(nome)
        when:
            boolean result = produto.isValid()
        then:
            result == expected
        where:
            expected                | codigo                | nome
            true                    | 1                     | "CDB"
    }

    def "should return thrown exception if fields produto invalid"() {
        given:
            Produto produto = new Produto()
            produto.setCodigo(codigo)
            produto.setNome(nome)
        when:
            produto.isValid()
        then:
            Exception ex = thrown()
            ex.message == expected
        where:
            expected                                                    | codigo        | nome
            "Os campos codigo e nome não podem ser nulos ou vazios"     | 0             | "CDB"
            "Os campos codigo e nome não podem ser nulos ou vazios"     | 123           | ""
            "Os campos codigo e nome não podem ser nulos ou vazios"     | 123           | null
    }
}
