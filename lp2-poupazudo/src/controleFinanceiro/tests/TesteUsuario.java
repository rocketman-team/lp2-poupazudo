package controleFinanceiro.tests;

import org.junit.Assert;
import org.junit.Test;

import controleFinanceiro.exceptions.EmailIncorretoException;
import controleFinanceiro.exceptions.NomeIncorretoException;
import controleFinanceiro.exceptions.SenhaInseguraException;
import controleFinanceiro.model.Usuario;

public class TesteUsuario {

	@Test
	public void testeUsuarioValido() {

		Usuario usuario = null;

		try {
			usuario = new Usuario("user", "mail@gmail.com", "******");

		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}

		Assert.assertEquals("mail@gmail.com", usuario.getEmail());
		Assert.assertEquals("user", usuario.getNome());
		Assert.assertEquals("******", usuario.getSenha());

	}

	@Test
	public void testeUsuarioInvalido() {

		try {
			new Usuario(null, "mail@gmail.com", "******");
			Assert.fail("Nome incorreto");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}

	}

	@Test
	public void testeEmailInvalido() {

		try {
			new Usuario("nome", "fnfdlkfdfd4f1dsf7ds9f", "******");
			Assert.fail("Nome incorreto");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}
	}

	@Test
	public void testeSenhaInvalido() {
		try {
			new Usuario("nome", "email@mail.com", "123456789aa");
			Assert.fail("Senha insegura");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}
	}

	@Test
	public void testeUsuariosIguais() throws EmailIncorretoException,
			NomeIncorretoException, SenhaInseguraException {

		Usuario A = new Usuario("alguem", "alguem@mail.com", "33517889");
		Usuario B = new Usuario("outro", "alguem@mail.com", "33510045");

		Assert.assertTrue(A.equals(B));
	}

	@Test
	public void testeToString() throws EmailIncorretoException,
			NomeIncorretoException, SenhaInseguraException {
		Usuario usuario = new Usuario("noel", "noel@mail.com", "33517889");

		String outputExpected = "Usuario [nome=noel, email=noel@mail.com]";

		Assert.assertTrue(usuario.toString().equals(outputExpected));
	}
}
