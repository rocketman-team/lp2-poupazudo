package controleFinanceiro.model;

import controleFinanceiro.exceptions.EmailIncorretoException;
import controleFinanceiro.exceptions.NomeIncorretoException;
import controleFinanceiro.exceptions.SenhaInseguraException;
import controleFinanceiro.exceptions.UsuarioJaExisteException;

public class Poupazudo {

	private static GerenteDeUsuarios gerente;

	public static void main(String[] args) throws EmailIncorretoException,
			NomeIncorretoException, SenhaInseguraException, UsuarioJaExisteException {

		gerente = new GerenteDeUsuarios();

		Usuario u = new Usuario("A", "email@mail.com", "123456");
		Usuario v = new Usuario("B", "email2@mail.com", "123456");
		Usuario x = new Usuario("C", "email3@mail.com", "123456");
		Usuario z = new Usuario("D", "email4@mail.com", "123456");
		
		gerente.adicionar(u);
		gerente.adicionar(v);
		gerente.adicionar(x);
		gerente.adicionar(z);

	}
}
