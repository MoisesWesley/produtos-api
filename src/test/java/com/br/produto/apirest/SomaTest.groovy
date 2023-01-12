package com.br.produto.apirest

import spock.lang.Specification

class SomaTest extends Specification {

    def "Somando dois numeros" () {
        given:
            Soma soma = new Soma()
        when:
            int resultado = soma.somaNUmeros(1,2)
        then:
            resultado == 3
    }
}
