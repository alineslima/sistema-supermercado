package br.com.aline.sistemasupermercado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aline.sistemasupermercado.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findByCodigoBarra(String codigoBarra);

	List<Produto> findByNomeProdutoContains(String nomeProduto);

}
