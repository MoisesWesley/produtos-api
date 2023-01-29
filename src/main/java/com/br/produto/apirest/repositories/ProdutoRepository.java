package com.br.produto.apirest.repositories;

import com.br.produto.apirest.entities.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    Optional<Produto> findByCodigo(long codigo);

    void deleteByCodigo(long codigo);
}
