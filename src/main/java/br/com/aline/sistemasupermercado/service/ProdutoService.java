package br.com.aline.sistemasupermercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aline.sistemasupermercado.entity.Produto;
import br.com.aline.sistemasupermercado.exception.ProdutoException;
import br.com.aline.sistemasupermercado.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	public Produto cadastrarProduto(Produto produto) {
		
		validacaoDeDados(produto);
		if(produto.getIdProduto() != null) {
			throw new ProdutoException("este campo não deve ser preenchido");
		}
		
		return produtoRepository.save(produto);
	}
	
	
	public Produto consultarProdutoPorId (Long id) {
		Optional<Produto> produtoConsultadoComId= produtoRepository.findById(id);
		if(produtoConsultadoComId.isEmpty()){
			throw new ProdutoException("produto inexistente");
		} else {
			return produtoConsultadoComId.get();
		}
		
	}
	
	public Produto consultarProdutoPorCodigoBarra (String codigoBarra) {
		Optional<Produto> produtoConsultadoComCodigoBarra = produtoRepository.findByCodigoBarra(codigoBarra);
		if(produtoConsultadoComCodigoBarra.isEmpty()){
			throw new ProdutoException("produto inexistente");
		} else {
			return produtoConsultadoComCodigoBarra.get();
		}
		
	}
	
	public List<Produto> consultarProdutoPorNomeProduto (String nomeProduto) {
		List<Produto> produtoConsultadoPorNome = produtoRepository.findByNomeProdutoContains(nomeProduto);
		if(produtoConsultadoPorNome.isEmpty()) {
			throw new ProdutoException("produto inexistente");
		} else {
			return produtoConsultadoPorNome;
		}
		
		
	}
	
	
	public Produto atualizarProduto(Long id, Produto produto) {
		consultarProdutoPorId(id);
		validacaoDeDados(produto);
		produto.setIdProduto(id);
		return produtoRepository.save(produto);
		
	}
	
	private void validacaoDeDados(Produto produto) {
		
		if(produto == null) {
			throw new ProdutoException("informe o produto");
		}
		
		if(produto.getCodigoBarra() == null || produto.getCodigoBarra().isBlank()) {
			throw new ProdutoException("informe o código de barras");
		}
		
		if(produto.getDescricaoProduto() == null || produto.getDescricaoProduto().isBlank()) {
			throw new ProdutoException("informe a descrição do produto");			
		}
		
		if(produto.getNomeProduto() == null || produto.getNomeProduto().isBlank()) {
			throw new ProdutoException("informe o nome do produto");			
		}
		
		if(produto.getQuantidadeProduto() == null) {
			throw new ProdutoException("informe a quantidade do produto");	
		}
		
		if(produto.getValorProduto() == null) {
			throw new ProdutoException("informe o valor do produto");
		}
		
	}


	public void deletarProduto(Long id) {
		consultarProdutoPorId(id);
		produtoRepository.deleteById(id);
		
	}
	
}
