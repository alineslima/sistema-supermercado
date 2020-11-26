package br.com.aline.sistemasupermercado.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.aline.sistemasupermercado.entity.Produto;
import br.com.aline.sistemasupermercado.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
public class ProdutoControllerTest {
	
	@InjectMocks
	private ProdutoController produtoController;
	
	@Mock
	private ProdutoRepository produtoRepository;
	
	
	@Test
	public void testOlaMundo() {
		String retorno = produtoController.olaMundo();
		Assert.assertEquals("hello world", retorno);
	}

	@Test
	public void testCadastrarProduto() {
		Produto produto = new Produto();
		
		Produto produtoRetornado = new Produto();
		Mockito.when(produtoRepository.save(produto)).thenReturn(produtoRetornado);
		
		Produto produtoCadastrado = produtoController.cadastrarProduto(produto);
		Assert.assertEquals(produtoRetornado, produtoCadastrado);
	}
	
	
}
