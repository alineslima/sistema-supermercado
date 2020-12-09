package br.com.aline.sistemasupermercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.aline.sistemasupermercado.entity.Produto;
import br.com.aline.sistemasupermercado.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> consultarProduto(@RequestParam(required = false) Long id, 
			@RequestParam(required = false) String codigoBarra, @RequestParam(required = false) String nomeProduto){
		
		List<Produto> produtos = new ArrayList<>();
		
		if(id != null) {
			Produto produtoConsultado = produtoService.consultarProdutoPorId(id);
			produtos.add(produtoConsultado);
		} else if(codigoBarra != null) {
			Produto produtoConsultado = produtoService.consultarProdutoPorCodigoBarra(codigoBarra);
			produtos.add(produtoConsultado);
		} else if(nomeProduto != null) {
			List<Produto> produtosConsultados = produtoService.consultarProdutoPorNomeProduto(nomeProduto);
			produtos.addAll(produtosConsultados);
		}
		
		
		return produtos;
	}
	
	@PostMapping
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		
		return produtoService.cadastrarProduto(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
		
		return produtoService.atualizarProduto(id, produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		
		produtoService.deletarProduto(id);
	
	}

}
