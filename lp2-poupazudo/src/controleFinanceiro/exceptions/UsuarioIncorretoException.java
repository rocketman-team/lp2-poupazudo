package controleFinanceiro.exceptions;

public class UsuarioIncorretoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6263377851706465642L;

	public UsuarioIncorretoException() {
		super("Usuário incorreto");
	}

	public UsuarioIncorretoException(String mensagem) {
		super(mensagem);
	}

	public UsuarioIncorretoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
