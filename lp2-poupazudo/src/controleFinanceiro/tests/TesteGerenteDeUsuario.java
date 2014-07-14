package controleFinanceiro.tests;

import org.junit.Assert;
import org.junit.Test;

import controleFinanceiro.exceptions.EmailIncorretoException;
import controleFinanceiro.exceptions.NomeIncorretoException;
import controleFinanceiro.exceptions.SenhaIncorrentaException;
import controleFinanceiro.exceptions.SenhaInseguraException;
import controleFinanceiro.exceptions.UsuarioInexistenteException;
import controleFinanceiro.exceptions.UsuarioJaExisteException;
import controleFinanceiro.model.GerenteDeUsuarios;
import controleFinanceiro.model.Usuario;

public class TesteGerenteDeUsuario {

	@Test
	public void testeAdicionaUsuarioValido() throws Exception {

		GerenteDeUsuarios gerente = new GerenteDeUsuarios();
		Usuario usuario = new Usuario("nome", "nome@mail.com", "aabbcc");

		gerente.adicionar(usuario);

		Assert.assertEquals(usuario, gerente.pesquisar("nome@mail.com"));
	}

	@Test
	public void testeAdicionaUsuarioJaExistente() {

		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		try {
			gerente.adicionar(new Usuario("nome", "helm@mail.com", "aabbcc"));
			gerente.adicionar(new Usuario("nome", "helm@mail.com", "aabbcc"));
			Assert.fail("Usuário já existente");
		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		} catch (UsuarioJaExisteException e) {
			Assert.assertEquals("Mensagem errada", "Usuário já existente",
					e.getMessage());
		}
	}

	@Test
	public void testePesquisaUsuarioPorEmail() throws UsuarioJaExisteException,
			EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException {

		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		Usuario usuario = new Usuario("B", "b@mail.com", "bbbbbbb");

		gerente.adicionar(new Usuario("A", "a@mail.com", "aaaaaaa"));
		gerente.adicionar(usuario);
		gerente.adicionar(new Usuario("C", "c@mail.com", "ccccccc"));

		Assert.assertEquals("b@mail.com", gerente.pesquisar("b@mail.com")
				.getEmail());
		Assert.assertTrue(usuario == gerente.pesquisar("b@mail.com"));

	}

	@Test
	public void testeRealizaLogin() throws UsuarioJaExisteException,
			EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException, UsuarioInexistenteException,
			SenhaIncorrentaException {

		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		Usuario usuario = new Usuario("A", "a@mail.com", "aaaaaaa");

		gerente.adicionar(usuario);

		Assert.assertFalse(usuario.isStatus());

		gerente.logar("a@mail.com", "aaaaaaa");

		Assert.assertTrue(usuario.isStatus());

	}

	@Test
	public void testeRealizaLoginDeUsuarioInexistente()
			throws UsuarioJaExisteException, EmailIncorretoException,
			NomeIncorretoException, SenhaInseguraException,
			SenhaIncorrentaException {

		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		Usuario usuario1 = new Usuario("Caim", "caim@mail.com", "caim123");

		gerente.adicionar(usuario1);

		try {
			gerente.logar("abel@mail.com", "avel123");
			Assert.fail("Usuário inexistente");
		} catch (UsuarioInexistenteException e) {
			Assert.assertEquals("Mensagem errada", "Usuário inexistente",
					e.getMessage());
		}
	}

	@Test
	public void testeSenhaIncorreta() throws UsuarioJaExisteException,
			EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException {

		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		Usuario usuario1 = new Usuario("Caim", "caim@mail.com", "caim123");

		gerente.adicionar(usuario1);

		try {
			gerente.logar("caim@mail.com", "caim321");
			Assert.fail("Senha incorreta");
		} catch (UsuarioInexistenteException e) {
			Assert.assertEquals("Mensagem errada", "Usuário inexistente",
					e.getMessage());
		} catch (SenhaIncorrentaException e) {
			Assert.assertEquals("Mensagem errada", "Senha incorreta",
					e.getMessage());
		}

	}

}
