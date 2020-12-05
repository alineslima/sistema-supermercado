package br.com.aline.sistemasupermercado.exception;

public class ProdutoException extends RuntimeException {

	private static final long serialVersionUID = 626279180034608273L;
	
	public ProdutoException (String mensagem) {
		super(mensagem);
	}

}
