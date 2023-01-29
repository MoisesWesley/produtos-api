package com.br.produto.apirest.services

import com.br.produto.apirest.entities.ClasseInvestimento
import com.br.produto.apirest.entities.Produto
import com.br.produto.apirest.repositories.ProdutoRepository
import spock.lang.Specification

class ProdutoServiceTest extends Specification {

    public static final long codigoProduto = 4345
    public static final String nomeProduto = "CDB"

    public static final long codigoClasseInvestimento = 6548
    public static final String nomeClasseInvestimento = "Pós Fixado"

    ProdutoService produtoService

    ProdutoRepository produtoRepository

    def setup() {
        produtoRepository = Mock(ProdutoRepository)
        produtoService = new ProdutoService(produtoRepository: produtoRepository)
    }

    def "should return thrown exception when produto does not exist in base"() {
        given:
            produtoRepository.findByCodigo(codigoProduto) >> Optional.empty()
        when:
            produtoService.findByCodigo(codigoProduto)
        then:
            Exception ex = thrown()
            ex.message == "Registro não encontrado"
    }

    def "should return produto existing"() {
        given:
            produtoRepository.findByCodigo(codigoProduto) >> Optional.of(new Produto(codigo: codigoProduto))
        when:
            Produto produto = produtoService.findByCodigo(codigoProduto)
        then:
            produto.getCodigo() == codigoProduto
    }

    def "should return thrown exception when trying to save produto existing"() {
        given:
            Produto produto = new Produto()
            produto.setCodigo(codigoProduto)
            produto.setNome(nomeProduto)
            produtoRepository.findByCodigo(codigoProduto) >> Optional.of(new Produto(codigo: codigoProduto))
        when:
            produtoService.salvarProduto(produto)
        then:
            Exception ex = thrown()
            ex.message == "Produto já existe."
    }

    def "should return thrown exception when no produto exists in base"() {
        given:
            produtoRepository.findAll() >> []
        when:
            produtoService.buscarProdutos()
        then:
            Exception ex = thrown()
            ex.message == "Não existem produtos."
    }

    def "should return all produtos"() {
        given:
            produtoRepository.findAll() >> [new Produto()]
        when:
            produtoService.buscarProdutos()
        then:
            produtoService.buscarProdutos().size() > 0
    }

    def "should save produto if does not exists"() {
        given:
            Produto produto = new Produto()
            produto.setCodigo(codigoProduto)
            produto.setNome(nomeProduto)
            produtoRepository.findByCodigo(produto.getCodigo()) >> Optional.empty()
        when:
            produtoService.salvarProduto(produto)
        then:
            1 * produtoRepository.save(produto)
    }

    def "should update produto if exists"() {
        given:
            Produto produto = new Produto()
            produto.setCodigo(codigoProduto)
            produto.setNome(nomeProduto)
            produto.setClassesInvestimento([new ClasseInvestimento(codigo: codigoClasseInvestimento, nome: nomeClasseInvestimento, risco: 2.2)])
            produtoRepository.findByCodigo(produto.getCodigo()) >> Optional.of(new Produto(codigo: codigoProduto))
        when:
            produtoService.atualizarProduto(produto.getCodigo(), produto)
        then:
            1 * produtoRepository.save(produto)
    }

    def "should thrown exception when trying to update produto not exists"() {
        given:
            Produto produto = new Produto()
            produto.setCodigo(codigoProduto)
            produto.setNome(nomeProduto)
            produto.setClassesInvestimento([new ClasseInvestimento(codigo: codigoClasseInvestimento, nome: nomeClasseInvestimento, risco: 2.2)])
            produtoRepository.findByCodigo(produto.getCodigo()) >> Optional.empty()
        when:
            produtoService.atualizarProduto(produto.getCodigo(), produto)
        then:
            Exception ex = thrown()
            ex.message == "Impossivel atualizar produto inexistente"
    }

    def "should delete produto by codigo"() {
        when:
            produtoService.deleteByCodigoProduto(codigoProduto)
        then:
            1 * produtoRepository.deleteByCodigo(codigoProduto)
    }

    def "should delete all produto"() {
        when:
            produtoService.deleteAll()
        then:
        1 * produtoRepository.deleteAll()
    }
}
