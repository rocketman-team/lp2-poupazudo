package controleFinanceiro.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controleFinanceiro.exceptions.EmailDuplicadoException;
import controleFinanceiro.exceptions.EmailIncorretoException;

/**
 * Classe que representa o usu�rio
 * 
 * @author team
 * 
 */
public class Usuario {

	private String nome;

	private String email;

	private String senha;

	private List<String> dicasDeSenhas;

	/**
	 * Inicializa um novo usu�rio
	 * 
	 * @param email
	 *            Email do usu�rio
	 * @param nome
	 *            Nome do usu�rio
	 * @param senha
	 *            Senha do usu�rio
	 * @throws EmailDuplicadoException
	 *             Email j� esta associada a uma conta
	 * @throws EmailIncorretoException
	 *             Email incorreto
	 * @throws Exception
	 */
	public Usuario(String email, String nome, String senha)
			throws EmailIncorretoException, EmailDuplicadoException {

		setEmail(email);
		setNome(nome);
		setSenha(senha);
	}

	/**
	 * Verifica se o email j� est� associado a uma conta
	 * 
	 * @param email
	 *            Email do usu�rio
	 * @throws EmailDuplicadoException
	 *             Email j� est� associado a uma conta
	 */
	private void verificaDisponibilidade(String email)
			throws EmailDuplicadoException {

		// TODO se existir uma conta com esse email
		// throw new EmailDuplicadoException();
	}

	/**
	 * Retorna o email do usu�rio
	 * 
	 * @return Email do usu�rio
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 * @throws EmailIncorretoException
	 * @throws EmailDuplicadoException
	 */
	public void setEmail(String email) throws EmailIncorretoException,
			EmailDuplicadoException {

		checaEmail(email);
		verificaDisponibilidade(email);

		this.email = email;
	}

	/**
	 * Retorna o nome do usu�rio
	 * 
	 * @return Nome do usu�rio
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do usu�rio
	 * 
	 * @param nome
	 *            Nome do usu�rio
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a senha do usu�rio
	 * 
	 * @return Senha do usu�rio
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define a senha do usu�rio
	 * 
	 * @param senha
	 *            Senha do usu�rio
	 */
	public void setSenha(String senha) {
		if (senha.length() >= 6 && senha.length() <= 8)
			this.senha = senha;
	}

	/**
	 * Gera uma dica de senha para o usu�rio
	 * 
	 * @return Dicas de senhas
	 */
	public List<String> gerarDicasDeSenha() {

		return dicasDeSenhas;
	}

	/**
	 * Checa se o email � v�lido
	 * 
	 * @param email
	 *            Email do usu�rio
	 * @throws EmailIncorretoException
	 *             Email incorreto
	 */
	private void checaEmail(String email) throws EmailIncorretoException {
		Pattern pattern = Pattern
				.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);

		if (!matcher.find())
			throw new EmailIncorretoException();

	}
}
