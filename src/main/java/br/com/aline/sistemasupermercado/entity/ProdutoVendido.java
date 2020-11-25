package br.com.aline.sistemasupermercado.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "Venda_Produto")
public class ProdutoVendido {
	
	@EmbeddedId
	private ProdutoVendidoPk idChaveComposta;
	
	@Column(name = "quantidade_produto_vendido")
	private Double quantidadeProdutoVendido;
	
	public ProdutoVendidoPk getIdChaveComposta() {
		return idChaveComposta;
	}
	public void setIdChaveComposta(ProdutoVendidoPk idChaveComposta) {
		this.idChaveComposta = idChaveComposta;
	}
	public Double getQuantidadeProdutoVendido() {
		return quantidadeProdutoVendido;
	}
	public void setQuantidadeProdutoVendido(Double quantidadeProdutoVendido) {
		this.quantidadeProdutoVendido = quantidadeProdutoVendido;
	}
	
	
}
