package controleFinanceiro.model;

import controleFinanceiro.exceptions.EmailIncorretoException;
import controleFinanceiro.exceptions.NomeIncorretoException;
import controleFinanceiro.exceptions.SenhaInseguraException;
import controleFinanceiro.util.Email;

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

	private String dicaDeSenha;

	private boolean status;

	/**
	 * Inicializa um novo usu�rio
	 * 
	 * @param email
	 *            Email do usu�rio
	 * @param nome
	 *            Nome do usu�rio
	 * @param senha
	 *            Senha do usu�rio
	 * @throws NomeIncorretoException
	 *             Email j� esta associada a uma conta
	 * @throws EmailIncorretoException
	 *             Email incorreto
	 * @throws SenhaInseguraException
	 * @throws Exception
	 */
	public Usuario(String nome, String email, String senha)
			throws EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException {

		checaNome(nome);
		checaEmail(email);
		checaSenha(senha);

		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setStatus(false);
	}

	/**
	 * Inicializa um novo usu�rio
	 * 
	 * @param nome
	 *            Nome do usu�rio
	 * @param email
	 *            Email do usu�rio
	 * @param senha
	 *            Senha do usu�rio
	 * @param dica
	 *            Dica de senha do usu�rio
	 * @throws EmailIncorretoException
	 *             Email j� esta associada a uma conta
	 * @throws NomeIncorretoException
	 *             NomeIncorretoException
	 * @throws SenhaInseguraException
	 *             SenhaInseguraException
	 */
	public Usuario(String nome, String email, String senha, String dica)
			throws EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException {

		checaNome(nome);
		checaEmail(email);
		checaSenha(senha);

		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setDicaDeSenha(dica);
		setStatus(false);
	}

	/**
	 * Checa se o nome n�o � vazio
	 * 
	 * @param nome
	 *            Nome do usu�rio
	 * @throws NomeIncorretoException
	 *             Nome incorreto
	 */
	private void checaNome(String nome) throws NomeIncorretoException {

		if (nome == null || nome.length() == 0)
			throw new NomeIncorretoException();

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

		if (!Email.vericaEmail(email))
			throw new EmailIncorretoException();

	}

	/**
	 * Checa se a senha � segura
	 * 
	 * @param senha
	 *            Senha do usu�rio
	 * @throws SenhaInseguraException
	 *             Senha insegura
	 */
	private void checaSenha(String senha) throws SenhaInseguraException {

		if (senha.length() < 6 || senha.length() > 8)
			throw new SenhaInseguraException();
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
	 * Define o email do usu�rio
	 * 
	 * @param email
	 *            Email do usu�rio
	 * @throws EmailIncorretoException
	 *             Email j� esta associada a uma conta
	 * @throws NomeIncorretoException
	 *             Nome incorreto
	 */
	public void setEmail(String email) {
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
		this.senha = senha;
	}

	/**
	 * Retorna a dica e senha do usupario
	 * 
	 * @return
	 */
	public String getDicaDeSenha() {
		return dicaDeSenha;
	}

	/**
	 * Define a dica de senha do usu�rio
	 * 
	 * @param dicaDeSenha
	 *            Dica de senha
	 */
	public void setDicaDeSenha(String dicaDeSenha) {
		this.dicaDeSenha = dicaDeSenha;
	}

	/**
	 * Retorna status do usu�rio
	 * 
	 * @return Status do usu�rio
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Define stats do usu�rio
	 * 
	 * @param status
	 *            Status do usu�rio
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + "]";
	}

}
