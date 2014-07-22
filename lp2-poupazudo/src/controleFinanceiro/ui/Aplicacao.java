package controleFinanceiro.ui;

import java.io.IOException;
import java.util.Scanner;

import controleFinanceiro.exceptions.EmailIncorretoException;
import controleFinanceiro.exceptions.NomeIncorretoException;
import controleFinanceiro.exceptions.SenhaIncorrentaException;
import controleFinanceiro.exceptions.SenhaInseguraException;
import controleFinanceiro.exceptions.UsuarioInexistenteException;
import controleFinanceiro.exceptions.UsuarioJaExisteException;
import controleFinanceiro.model.GerenteDeUsuarios;
import controleFinanceiro.model.Usuario;

public class Aplicacao {

	private static GerenteDeUsuarios sistema = new GerenteDeUsuarios();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws EmailIncorretoException,
			NomeIncorretoException, SenhaInseguraException, IOException {

		menu();

		while (true)
			prompt();
	
	}

	private static void prompt() {
		System.out.print("poupazudo~$ ");
		int op = scanner.nextInt();

		switch (op) {
		case 1:
			login();
			break;
		case 2:
			cadastrar();
			break;
		case 3:
			listar();
			break;
		case 4:
			if (GerenteDeUsuarios.getUsuarioLocal() != null)
				System.out.println("[ Sessão incerrada ]");
			GerenteDeUsuarios.logout();
			break;
		default:
			return;
		}

	}

	private static void menu() {
		String opcoes = "Testes de iteração 1 e 2.\n1 - Entrar\n2 - Cadastar\n3 - Lista usuários *\n4 - Sair\n";
		System.out.println(opcoes);
	}

	private static void login() {
		
		if (GerenteDeUsuarios.getUsuarioLocal() != null) {
			System.out.println(GerenteDeUsuarios.getUsuarioLocal().getNome() + " já está logado.");
			return;
		}
		
		String email, senha;
		System.out.print("Email: ");
		email = scanner.next();
		System.out.print("Senha: ");
		senha = scanner.next();

		try {
			sistema.logar(email, senha);
			System.out.println("[ "+GerenteDeUsuarios.getUsuarioLocal().getNome()
					+ " está logado no sistema ]");
		} catch (UsuarioInexistenteException e) {
			System.out.println(e.getLocalizedMessage() + "\n");
		} catch (SenhaIncorrentaException e) {
			System.out.println(e.getMessage() + "\n");
		}

		return;
	}

	private static void cadastrar() {
		
		String nome, email, senha, confirmar, dica;
		
		System.out.print("Nome: ");
		nome = scanner.next();
		
		System.out.print("email: ");
		email = scanner.next();
		
		System.out.print("senha: ");
		senha = scanner.next();
		
		System.out.print("Confirmar senha: ");
		confirmar = scanner.next();
		
		while (!confirmar.equals(senha)) {
			System.out.print("~#Senha: ");
			senha = scanner.next();
			
			System.out.print("~#Confirmar senha: ");
			confirmar = scanner.next();
		}
		
		System.out.print("Dica: ");
		dica = scanner.next();
		
		try {
			sistema.adicionar(new Usuario(nome, email, senha, dica));
			System.out.println("[ Usuario cadastrado ]");
		} catch (UsuarioJaExisteException e) {
			System.out.println(e.getMessage());
		} catch (EmailIncorretoException e) {
			System.out.println(e.getMessage());
		} catch (NomeIncorretoException e) {
			System.out.println(e.getMessage());
		} catch (SenhaInseguraException e) {
			System.out.println(e.getMessage());
		}
		
		GerenteDeUsuarios.atualizar();
		
	}
	
	private static void listar() {
		for (Usuario usr : GerenteDeUsuarios.getUsuarios()) {
			System.out.println(usr);
		}
	}
}
