package controleFinanceiro.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controleFinanceiro.exceptions.EmailDuplicadoException;
import controleFinanceiro.exceptions.EmailIncorretoException;

/**
 * 
 * A classe gerente de usuario possui a interface pois ela era pedir as
 * inforcamoes ao usuario, criar uma nova conta, validar informacoes, guardar e
 * ler informacoes de serializes anteriores.
 * 
 * @author Hebert
 * 
 */
public class GerenteDeUsuarios {

	private static String nome;
	private static String email;
	private static String senha;
	private static String dicaSenha;
	/**
	 * a lista usuarios le as informacoes dos serializes anteriores
	 */
	private static ArrayList<Usuario> usuarios = deserializa();

	/**
	 * esse método recebe as informacoes da interface grafica (GUI)
	 * 
	 * @param n
	 *            que eh o nome
	 * @param s
	 *            que eh a senha
	 * @param c
	 *            que eh a confirmacao da conta
	 * @param em
	 *            que eh o email
	 * @param dica
	 *            que eh a dica
	 * @throws EmailDuplicadoException 
	 * @throws EmailIncorretoException 
	 */
	public static void interfaceCadastro(String n, String s, String c,
			String em, String d) throws EmailIncorretoException, EmailDuplicadoException {
		Usuario user = null;
		/**
		 * verifica se as informações dadas são validas e se tiver tudo ok ele
		 * cria um objeto do tipo usuário e armazena na lista de usuários
		 * 
		 */
		try {
			nome = verificaNome(n);
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			senha = verificaSenha(s);
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			email = verificaEmail(em);
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			confirmaSenha(c);
		} catch (Exception e) {
			e.getMessage();
		}
		dicaSenha = d;

		user = new Usuario(email, nome, senha);
		
		serializa(user);
	}

	public boolean login(String email, String senha) throws Exception {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email)) {
				if (usuarios.get(i).getSenha().equals(senha))
					return true;
				else
					throw new Exception("Senha não correspondente.");
			}
		}
		return false;
	}

	private static String verificaNome(String nome) throws Exception {
		if (nome != null && !(nome.equals("")))
			return nome;
		throw new Exception("Nome inválido. Tente um nome diferente.");
	}

	private static String verificaEmail(String email) throws Exception {
		Pattern p = Pattern
				.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);

		if (m.find()) // Caso email seja valido
			return email;
		throw new Exception("E-mail não válido."); // Caso email seja invalido
	}

	private static String verificaSenha(String senha) throws Exception {
		if (senha.length() >= 6 && senha.length() <= 8)
			return senha;
		else
			throw new Exception("Sua senha deve ser entre 6 e 8 caracteres.");
	}

	private static void confirmaSenha(String confirmaSenha) throws Exception {
		if (!confirmaSenha.equals(senha))
			throw new Exception("Confirmação da senha difere da senha omitida.");
	}

	/**
	 * o metodo serializa a lista, primeiramente verifica se existe outro
	 * usuario com o mesmo email e adiciona o usuario nessa lista depois
	 * serializa a lista usuarios
	 * 
	 * @param user
	 */
	private static void serializa(Usuario user) {

		try {
			verificaEquals(user);
			usuarios.add(user);
		} catch (Exception e) {
			e.getMessage();
		}

		try {
			FileOutputStream fos = new FileOutputStream("user.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(usuarios);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * verifica se o arquivo que vai deserializar existe se existir ele
	 * deserializa e retorna o arraylist dos usuarios; se nao existir o arquivo
	 * ele cria um usuario null e armazena ele na lista de usuario e depois
	 * serializa essa lista, assim ela nao ficara mais vazia, isso foi criado
	 * caso seja a primeira vez q o programa rode e não haja nenhum usuario na
	 * lista.
	 * 
	 * @return lista obtida pelo deserialize
	 */
	private static ArrayList<Usuario> deserializa() {
		ArrayList<Usuario> arraylist = new ArrayList<Usuario>();
		Usuario user = null;
		if (new File("user.ser").isFile()) {
			try {
				FileInputStream fis = new FileInputStream("user.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				arraylist = (ArrayList) ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (ClassNotFoundException c) {
				System.out.println("Class não encontrada.");
				c.printStackTrace();
			}
		} else
			arraylist.add(user);
		serializa(user);
		return arraylist;
	}

	/**
	 * verifica se há outro usuario com o mesmo email
	 * 
	 * @param user
	 * @throws Exception
	 */
	private static void verificaEquals(Usuario user) throws Exception {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).equals(user))
				throw new Exception("Já existe um usuario com esse e-mail.");
		}
	}
}
