package br.com.aline.sistemasupermercado.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProdutoVendidoPk implements Serializable{
	
	private static final long serialVersionUID = 3728992176136179153L;

	@ManyToOne
	@JoinColumn(name = "Venda_id_venda")
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name = "Produto_id")
	private Produto produto;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
	
	
	
	
	

}
