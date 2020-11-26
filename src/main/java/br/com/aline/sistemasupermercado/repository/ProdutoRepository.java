package br.com.aline.sistemasupermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aline.sistemasupermercado.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
