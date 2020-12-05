package br.com.aline.sistemasupermercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.aline.sistemasupermercado.entity.Produto;
import br.com.aline.sistemasupermercado.exception.ProdutoException;
import br.com.aline.sistemasupermercado.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
public class ProdutoServiceTest {

	@InjectMocks
	private ProdutoService produtoService;

	@Mock
	private ProdutoRepository produtoRepository;

	@Test
	public void testCadastrarProduto() {
		Produto produto = new Produto();

		produto.setCodigoBarra("1525252");
		produto.setDescricaoProduto("creme johnsons2");
		produto.setNomeProduto("johnsons");
		produto.setQuantidadeProduto(1D);
		produto.setValorProduto(25.00);

		Produto produtoRetornado = new Produto();
		Mockito.when(produtoRepository.save(produto)).thenReturn(produtoRetornado);

		Produto produtoCadastrado = produtoService.cadastrarProduto(produto);
		Assert.assertEquals(produtoRetornado, produtoCadastrado);
	}

	@Test
	public void testCadastrarProdutoProdutoNulo() {
		try {
			produtoService.cadastrarProduto(null);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe o produto", e.getMessage());
		}
	}

	@Test
	public void testCodigoBarrasNulo() {
		try {
			Produto produto = new Produto();
			// não precisa dessa linha: produto.setCodigoBarra(null); pois o padrão quando
			// instancia um objeto é seus atributos serem nulos

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe o código de barras", e.getMessage());
		}
	}

	@Test
	public void testDescricaoProdutoNulo() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("1525252");

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe a descrição do produto", e.getMessage());
		}
	}

	@Test
	public void testNomeProdutoNulo() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("1525252");
			produto.setDescricaoProduto("creme johnsons2");

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe o nome do produto", e.getMessage());
		}
	}

	@Test
	public void testQuantidadeProdutoNulo() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("1525252");
			produto.setDescricaoProduto("creme johnsons2");
			produto.setNomeProduto("johnsons");

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe a quantidade do produto", e.getMessage());
		}
	}

	@Test
	public void testValorProdutoNulo() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("1525252");
			produto.setDescricaoProduto("creme johnsons2");
			produto.setNomeProduto("johnsons");
			produto.setQuantidadeProduto(1D);

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe o valor do produto", e.getMessage());
		}
	}

	@Test
	public void testCodigoBarrasVazio() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("  ");

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe o código de barras", e.getMessage());
		}
	}

	@Test
	public void testDescricaoProdutoVazio() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("666");
			produto.setDescricaoProduto("  ");

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe a descrição do produto", e.getMessage());
		}
	}

	@Test
	public void testNomeProdutoVazio() {
		try {
			Produto produto = new Produto();
			produto.setCodigoBarra("666");
			produto.setDescricaoProduto("766");
			produto.setNomeProduto("   ");

			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("informe o nome do produto", e.getMessage());
		}
	}

	@Test
	public void testIdProdutoNaoNulo() {
		try {
			Produto produto = new Produto();
			produto.setIdProduto(23L);
			produto.setCodigoBarra("dsfhb");
			produto.setDescricaoProduto("fghndg");
			produto.setNomeProduto("papel");
			produto.setQuantidadeProduto(1D);
			produto.setValorProduto(6.00);
			
			produtoService.cadastrarProduto(produto);

		} catch (ProdutoException e) {
			Assert.assertEquals("este campo não deve ser preenchido", e.getMessage());
		}
	}

	@Test
	public void testConsultarProdutoPorId() {
//		Optional<Produto> optionalProduto = Optional.empty();
//		optionalProduto.isEmpty() = true
//
//		Produto produto = new Produto();
//		Optional<Produto> optionalProduto2 = Optional.of(produto);
//		optionalProduto.isEmpty() = false
		Long id = 5525L;
		Produto produto = new Produto();
		Optional<Produto> optional = Optional.of(produto);
		Mockito.when(produtoRepository.findById(id)).thenReturn(optional);

		Produto produtoRetornado = produtoService.consultarProdutoPorId(id);
		Assert.assertEquals(produto, produtoRetornado);
	}

	@Test
	public void testConsultarProdutoPorIdVazio() {
		String msg = "";
		try {
			Long id = 4565L;
			Optional<Produto> optional = Optional.empty();
			Mockito.when(produtoRepository.findById(id)).thenReturn(optional);
			
			produtoService.consultarProdutoPorId(id);

		} catch (ProdutoException e) {
			msg = e.getMessage();

		}
		Assert.assertEquals("produto inexistente", msg);

	}

	@Test
	public void testConsultarProdutoPorCodigoBarras() {
		String codigoBarras = "cfghs";
		Produto produto = new Produto();
		Optional<Produto> optional = Optional.of(produto);
		Mockito.when(produtoRepository.findByCodigoBarra(codigoBarras)).thenReturn(optional);

		Produto produtoRetornado = produtoService.consultarProdutoPorCodigoBarra(codigoBarras);
		Assert.assertEquals(produto, produtoRetornado);
	}
	
	@Test
	public void testConsultarProdutoPorCodigoBarrasVazio() {
		String msg = "";
		
		try {
			String codigoBarras = "sdfb";
			Optional<Produto> optional = Optional.empty();
			Mockito.when(produtoRepository.findByCodigoBarra(codigoBarras)).thenReturn(optional);
			
			produtoService.consultarProdutoPorCodigoBarra(codigoBarras);
			
		} catch(ProdutoException e) {
			msg = e.getMessage();
		}
		
		Assert.assertEquals("produto inexistente", msg);
	}
	
	
	@Test
	public void testConsultarProdutoPorNomeProduto() {
		String nomeProduto = "perfume";
		List<Produto> produto = new ArrayList<>();
		Produto sorvete = new Produto();
		produto.add(sorvete);
		Mockito.when(produtoRepository.findByNomeProdutoContains(nomeProduto)).thenReturn(produto);

		List<Produto> produtoRetornado = produtoService.consultarProdutoPorNomeProduto(nomeProduto);
		Assert.assertEquals(produto, produtoRetornado);
	}
	
	@Test
	public void testConsultarProdutoPorNomeProdutoVazio() {
		String msg = "";
		
		try {
			String nomeProduto = "creme";
			List<Produto> produto = new ArrayList<>();
			Mockito.when(produtoRepository.findByNomeProdutoContains(nomeProduto)).thenReturn(produto);
			
			produtoService.consultarProdutoPorNomeProduto(nomeProduto);
			
		} catch(ProdutoException e) {
			msg = e.getMessage();
		}
		
		Assert.assertEquals("produto inexistente", msg);
	}
	
	@Test
	public void testAtualizarProduto() {
		Long id = 66L;
		Produto produto = new Produto();
		Optional<Produto> optional = Optional.of(produto);
		Mockito.when(produtoRepository.findById(id)).thenReturn(optional);
		
		produto.setCodigoBarra("kkll-3");
		produto.setDescricaoProduto("sdfbkkn");
		produto.setNomeProduto("carne");
		produto.setQuantidadeProduto(2D);
		produto.setValorProduto(15.00);
		
		Mockito.when(produtoRepository.save(produto)).thenReturn(produto);
		Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
		Assert.assertEquals(produto, produtoAtualizado);
		Assert.assertEquals(id, produto.getIdProduto());
	}
	
	
	
}
