package br.com.aline.sistemasupermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aline.sistemasupermercado.entity.Produto;
import br.com.aline.sistemasupermercado.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public String olaMundo(){
		return "hello world";
	}

	public Produto cadastrarProduto(Produto produto) {
		Produto produtoComId = produtoRepository.save(produto);
		return produtoComId;
	}
	
	

}
