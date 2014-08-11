package controleFinanceiro.model.transacao;

import java.text.SimpleDateFormat;

import controleFinanceiro.model.categoria.Categoria;
import controleFinanceiro.model.conta.Conta;
/**
 * 
 * @author rocketman team : Daniel Bezerra, Hebert Morais, Helisson Nascimento, Jeferson Ferreira
 *
 *Classe que representa a receita
 */
public class Receita extends Transacao {

	/**
	 * Inicializa a classe transação
	 * 
	 * @param data
	 * 			Data de inserção
	 * @param valor
	 * 			Valor da transacao
	 * @param categoria
	 * 			Categoria da transacao
	 * @param recorrencia
	 * 			Recorrencia (nenhuma,semanal ou mensal)
	 * @param descricao
	 * 			Descrição da transacao
	 * @param conta
	 * 			Conta no qual a transação será efetuada
	 * @param repeticao
	 * 			A quantidade de recorrencias
	 * @param fixo
	 * 			Uma transação sera fixa se não houver repetição definida
	 */
	public Receita(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta, int repeticao, boolean fixo) {
		super(data, valor, categoria, recorrencia, descricao, conta, repeticao, fixo);
	}

	/**
	 * Altera o saldo da conta de acordo com o valor dado
	 * @param valor
	 * 			Valor da transação
	 */
	@Override
	public void alteraSaldo(double valor) {
		if (valor >= 0){
		double somaSaldo = super.getConta().getSaldo() + valor;
		super.getConta().setSaldo(somaSaldo);
		}

	}

}
