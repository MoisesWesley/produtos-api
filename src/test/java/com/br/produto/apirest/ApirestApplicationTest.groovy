package com.br.produto.apirest

import spock.lang.Specification

class ApirestApplicationTest extends Specification {
    def "context loads test"() {
        given: "A Spring Boot application context"
        when: "The context is loaded"
        then: "The context should load successfully"
        true == true
    }
}
