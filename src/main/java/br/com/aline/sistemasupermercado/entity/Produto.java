package br.com.aline.sistemasupermercado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idProduto;
	
	@Column(name = "codigo_barra")
	private String codigoBarra;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "descrição_produto")
	private String descriçãoProduto;
	
	@Column(name = "valor")
	private Double valorProduto;
	
	@Column(name = "quantidade")
	private Double quantidadeProduto;
	
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescriçãoProduto() {
		return descriçãoProduto;
	}
	public void setDescriçãoProduto(String descriçãoProduto) {
		this.descriçãoProduto = descriçãoProduto;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public Double getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(Double quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	 
	
}
