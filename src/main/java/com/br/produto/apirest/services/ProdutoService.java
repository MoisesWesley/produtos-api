package com.br.produto.apirest.services;

import com.br.produto.apirest.entities.Produto;
import com.br.produto.apirest.repositories.ProdutoRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutos () {
        return produtoRepository.findAll();
    }

    public Produto findByCodigo(long codigo) {
        Optional<Produto> produto = produtoRepository.findByCodigo(codigo);
        return produto.orElseThrow(() -> new NoSuchElementException("Registro nao encontrado"));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto atualizarProduto(long codigo, Produto produto) {
        if (produtoRepository.findByCodigo(codigo).isPresent()) {
            return produtoRepository.save(produto);
        }
        throw new NoSuchElementException("Impossivel atualizar produto nao existe ou codigo invalido");
    }

    public void deleteByCodigoProduto(long codigo) {
        produtoRepository.deleteByCodigo(codigo);
    }

    public void deleteAll() {
        produtoRepository.deleteAll();
    }
}
