package controleFinanceiro.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controleFinanceiro.exceptions.SenhaIncorrentaException;
import controleFinanceiro.exceptions.UsuarioInexistenteException;
import controleFinanceiro.exceptions.UsuarioJaExisteException;
import controleFinanceiro.util.Arquivo;

/**
 * Esta classe representa um Gerente de usu�rios no qual mant�m armazenado uma
 * lista de usu�rios
 * 
 * @author Team
 * 
 */
public class GerenteDeUsuarios {

	private static List<Usuario> usuarios;

	private static Usuario usuarioLocal;

	/**
	 * Inicializa a lista de usu�rios do controle financeiro
	 * 
	 * @throws IOException
	 */
	public GerenteDeUsuarios() {
		recuperarDados();
	}

	/**
	 * Adicionar um novo usu�rio ao controle financeiro
	 * 
	 * @param usuario
	 *            Usu�rio
	 * @throws UsuarioJaExisteException
	 *             Usu�rio j� existente
	 */
	public void adicionar(Usuario usuario) throws UsuarioJaExisteException {

		if (usuarios.size() > 0)
			if (pesquisar(usuario.getEmail()) != null)
				throw new UsuarioJaExisteException();

		usuarios.add(usuario);

	}

	/**
	 * Pesquisa por um usu�rio atrav�s de email
	 * 
	 * @param email
	 *            Email no usu�rio
	 * @return Usu�rio
	 */
	public Usuario pesquisar(String email) {
		
			for (Usuario usr : usuarios) {
				if (usr.getEmail().equals(email))
					return usr;
			}
		
		return null;
	}

	/**
	 * Inicia sess�o do usu�rio no controle financeiro
	 * 
	 * @param email
	 *            Email do usu�rio
	 * @param senha
	 *            Senha do usu�rio
	 * @return Verdadeiro caso seja bem sucedido
	 * @throws UsuarioInexistenteException
	 *             Usu�rio inexistente
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

	public static void recuperarDados() {
		try {
			usuarios = (ArrayList<Usuario>) Arquivo.abrir();
			if (usuarios == null)
				usuarios = new ArrayList<Usuario>();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar dados do usu�rio");
			e.printStackTrace();
		}
	}

	public static void atualizar() {
		try {
			Arquivo.salvar(usuarios);
		} catch (IOException e) {
			System.out.println("Erro ao tentar atualizar dos dados.");
		}
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static Usuario getUsuarioLocal() {
		return usuarioLocal;
	}
	
	public static void logout() {
		atualizar();
		usuarioLocal = null;
	}
	
}