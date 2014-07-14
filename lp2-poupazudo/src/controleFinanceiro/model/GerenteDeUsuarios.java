package controleFinanceiro.model;

import java.util.ArrayList;
import java.util.List;

import controleFinanceiro.exceptions.SenhaIncorrentaException;
import controleFinanceiro.exceptions.UsuarioInexistenteException;
import controleFinanceiro.exceptions.UsuarioJaExisteException;

/**
 * Esta classe representa um Gerente de usuários no qual mantém armazenado uma
 * lista de usuários
 * 
 * @author Team
 * 
 */
public class GerenteDeUsuarios {

	private static List<Usuario> usuarios;

	private Usuario usuarioLocal;

	/**
	 * Inicializa a lista de usuários do controle financeiro
	 */
	public GerenteDeUsuarios() {
		usuarios = new ArrayList<Usuario>();
	}

	/**
	 * Adicionar um novo usuário ao controle financeiro
	 * 
	 * @param usuario
	 *            Usuário
	 * @throws UsuarioJaExisteException
	 *             Usuário já existente
	 */
	public void adicionar(Usuario usuario) throws UsuarioJaExisteException {

		if (usuarios.size() > 0)
			if (pesquisar(usuario.getEmail()) != null)
				throw new UsuarioJaExisteException();

		usuarios.add(usuario);

	}

	/**
	 * Pesquisa por um usuário através de email
	 * 
	 * @param email
	 *            Email no usuário
	 * @return Usuário
	 */
	public Usuario pesquisar(String email) {

		for (Usuario usr : usuarios) {
			if (usr.getEmail().equals(email))
				return usr;
		}

		return null;
	}

	/**
	 * Inicia sessão do usuário no controle financeiro
	 * 
	 * @param email
	 *            Email do usuário
	 * @param senha
	 *            Senha do usuário
	 * @return Verdadeiro caso seja bem sucedido
	 * @throws UsuarioInexistenteException
	 *             Usuário inexistente
	 * @throws SenhaIncorrentaException
	 *             Senha incorreta
	 */
	public boolean logar(String email, String senha)
			throws UsuarioInexistenteException, SenhaIncorrentaException {

		usuarioLocal = pesquisar(email);

		if (usuarioLocal != null) {
			if (usuarioLocal.getSenha().equals(senha))
				usuarioLocal.setStatus(true);
			else
				throw new SenhaIncorrentaException();
		} else
			throw new UsuarioInexistenteException();

		return true;
	}
}