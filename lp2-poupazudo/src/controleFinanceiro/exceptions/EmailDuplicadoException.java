package controleFinanceiro.exceptions;

public class EmailDuplicadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4882709540779658415L;

	public EmailDuplicadoException() {
		super("Email já está associado a uma conta");
	}

	public EmailDuplicadoException(String mensagem) {
		super(mensagem);
	}

	public EmailDuplicadoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
