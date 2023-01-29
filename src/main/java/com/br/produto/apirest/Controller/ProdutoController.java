package com.br.produto.apirest.Controller;

import com.br.produto.apirest.entities.Produto;
import com.br.produto.apirest.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.buscarProdutos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> listarProdutoPorCodigo(@PathVariable long codigo) {
       Produto produto = produtoService.findByCodigo(codigo);
       return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto prod = produtoService.salvarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable long codigo) {
        Produto prod = produtoService.atualizarProduto(codigo, produto);
        return ResponseEntity.ok().body(prod);
    }

    @DeleteMapping("/{codigo}")
    public void deletarProduto(@PathVariable long codigo) {
        produtoService.deleteByCodigoProduto(codigo);
    }

    @DeleteMapping
    public void deleteTodos() {
        produtoService.deleteAll();
    }
}
