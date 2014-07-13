package controleFinanceiro.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controleFinanceiro.exceptions.EmailDuplicadoException;
import controleFinanceiro.exceptions.EmailIncorretoException;

/**
 * Classe que representa o usuário
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
	 * Inicializa um novo usuário
	 * 
	 * @param email
	 *            Email do usuário
	 * @param nome
	 *            Nome do usuário
	 * @param senha
	 *            Senha do usuário
	 * @throws EmailDuplicadoException
	 *             Email já esta associada a uma conta
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
	 * Verifica se o email já está associado a uma conta
	 * 
	 * @param email
	 *            Email do usuário
	 * @throws EmailDuplicadoException
	 *             Email já está associado a uma conta
	 */
	private void verificaDisponibilidade(String email)
			throws EmailDuplicadoException {

		// TODO se existir uma conta com esse email
		// throw new EmailDuplicadoException();
	}

	/**
	 * Retorna o email do usuário
	 * 
	 * @return Email do usuário
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
	 * Retorna o nome do usuário
	 * 
	 * @return Nome do usuário
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do usuário
	 * 
	 * @param nome
	 *            Nome do usuário
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a senha do usuário
	 * 
	 * @return Senha do usuário
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define a senha do usuário
	 * 
	 * @param senha
	 *            Senha do usuário
	 */
	public void setSenha(String senha) {
		if (senha.length() >= 6 && senha.length() <= 8)
			this.senha = senha;
	}

	/**
	 * Gera uma dica de senha para o usuário
	 * 
	 * @return Dicas de senhas
	 */
	public List<String> gerarDicasDeSenha() {

		return dicasDeSenhas;
	}

	/**
	 * Checa se o email é válido
	 * 
	 * @param email
	 *            Email do usuário
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
