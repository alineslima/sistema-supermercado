package br.com.aline.sistemasupermercado.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.aline.sistemasupermercado.entity.Produto;
import br.com.aline.sistemasupermercado.service.ProdutoService;

@RunWith(SpringRunner.class)
public class ProdutoControllerTest {
	
	@InjectMocks
	private ProdutoController produtoController;
	
	@Mock
	private ProdutoService produtoService;
	

	@Test
	public void testCadastrarProduto() {
		Produto produto = new Produto();
		
		Produto produtoRetornado = new Produto();
		Mockito.when(produtoService.cadastrarProduto(produto)).thenReturn(produtoRetornado);
		
		Produto produtoCadastrado = produtoController.cadastrarProduto(produto);
		Assert.assertEquals(produtoRetornado, produtoCadastrado);
	}
	
	@Test
	public void testConsultarProdutoIdNaoNulo() {
		Long id = 12L;
		Produto produto = new Produto();
		
		Mockito.when(produtoService.consultarProdutoPorId(id)).thenReturn(produto);
		
		List<Produto> produtosComId = produtoController.consultarProduto(id, null, null);
		Assert.assertEquals(produto, produtosComId.get(0));
	}
	
	@Test
	public void testConsultarProdutoIdNulo() {
		List<Produto> produtosComId = produtoController.consultarProduto(null, null, null);
		Assert.assertTrue(produtosComId.isEmpty());
	}
	
	@Test
	public void testConsultarProdutoCodigoBarrasNaoNulo() {
		String codigoBarras = "zcvbvb";
		Produto produto = new Produto();
		
		Mockito.when(produtoService.consultarProdutoPorCodigoBarra(codigoBarras)).thenReturn(produto);
		
		List<Produto> produtosComCodigoBarras = produtoController.consultarProduto(null, codigoBarras, null);
		Assert.assertEquals(produto, produtosComCodigoBarras.get(0));
	}
	
	@Test
	public void testConsultarProdutoNomeProdutoNaoNulo() {
		String nomeProduto = "sdf";
		List<Produto> produtos = new ArrayList<>();
		Produto produto = new Produto();
		produtos.add(produto);
		
		Mockito.when(produtoService.consultarProdutoPorNomeProduto(nomeProduto)).thenReturn(produtos);
		
		List<Produto> produtosComNomeProduto = produtoController.consultarProduto(null, null, nomeProduto);
		Assert.assertEquals(produto,produtosComNomeProduto.get(0));
	}
	
	@Test
	public void testAtualizarProduto() {
		Long id = 68L;
		Produto produto = new Produto();
		Produto produtoRetornado = new Produto();
		Mockito.when(produtoService.atualizarProduto(id, produto)).thenReturn(produtoRetornado);
		Produto produtoAtualizado = produtoController.atualizarProduto(id, produto);
		Assert.assertEquals(produtoRetornado, produtoAtualizado);
		
	}
	
	@Test
	public void testDeletarProduto() {
		Long id = 60L;

		produtoController.deletarProduto(id);

		ArgumentCaptor<Long> idCapturado = ArgumentCaptor.forClass(Long.class);
		Mockito.verify(produtoService, Mockito.times(1)).deletarProduto(idCapturado.capture());
		Assert.assertEquals(id, idCapturado.getValue());
		
		
	}
		
	
}
