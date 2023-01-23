package com.br.produto.apirest.Controller;

import com.br.produto.apirest.entities.Produto;
import com.br.produto.apirest.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto prod = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @GetMapping
    public List<Produto> listarProduto() { return produtoRepository.findAll(); }

    @DeleteMapping
    public void deleteTodos() {produtoRepository.deleteAll();}
}
