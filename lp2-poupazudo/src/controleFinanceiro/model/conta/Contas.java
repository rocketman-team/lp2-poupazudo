package controleFinanceiro.model.conta;

import java.util.List;
/**
 * 
 * @author rocketman team : Daniel Bezerra, Hebert Morais, Helisson Nascimento, Jeferson Ferreira
 *
 *Classe que representa o conjunto de contas, visto que um usuario pode ter mais de uma conta.
 */

public class Contas extends Conta {

	private List<Conta> contas;
	
	/**
	 * 
	 * @param nome 
	 * 			Nome da conta
	 * 
	 * @param saldo
	 * 			Saldo inical da conta
	 */
	public Contas(String nome, double saldo) {
		super(nome, saldo);
	}
	
	/**
	 * Adiciona uma nova conta
	 * @param conta
	 */
	public void adicionaConta(Conta conta) {
		contas.add(conta);
	}
	
	/**
	 * Remove uma conta
	 * @param conta
	 * 
	 */
	public void removeConta(Conta conta) {
		for (Conta cont : contas)
		{
			if (cont.equals(conta))
				contas.remove(cont);
		}
	}

	@Override
	public String toString() {
		return "Contas [contas=" + contas + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contas other = (Contas) obj;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		return true;
	}
	
	

}
