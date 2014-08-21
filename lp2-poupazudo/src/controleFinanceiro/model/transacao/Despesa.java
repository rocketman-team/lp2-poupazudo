package controleFinanceiro.model.transacao;

import java.text.SimpleDateFormat;
import controleFinanceiro.model.categoria.Categoria;
import controleFinanceiro.model.conta.Conta;
/**
 * 
 * @author rocketman team : Daniel Bezerra, Hebert Morais, Helisson Nascimento, Jeferson Ferreira
 *
 * Classe que representa a despesa
 */
public class Despesa extends Transacao {
	
	/**
	 * Inicializa a classe transa��o
	 * 
	 * @param data
	 * 			Data de inser��o
	 * @param valor
	 * 			Valor da transacao
	 * @param categoria
	 * 			Categoria da transacao
	 * @param recorrencia
	 * 			Recorrencia (nenhuma,semanal ou mensal)
	 * @param descricao
	 * 			Descri��o da transacao
	 * @param conta
	 * 			Conta no qual a transa��o ser� efetuada
	 * @param repeticao
	 * 			A quantidade de recorrencias
	 * @param fixo
	 * 			Uma transa��o sera fixa se n�o houver repeti��o definida
	 */
	public Despesa(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta, int repeticao, boolean fixo) {
		super(data, valor, categoria, recorrencia, descricao, conta, repeticao, fixo);
	}

	/**
	 * Seleciona novo valor de recorrencia
	 * @return true
	 * 		Caso a recorrencia do valor n�o seja maior que o saldo da conta
	 * @return false
	 * 		Caso Contrario
	*/
	@Override
	public boolean setRecorrencia(Recorrencia recorrencia) {
		super.setRecorrencia(recorrencia);
		if (super.getValor() * recorrencia.getValor() <= super.getConta()
				.getSaldo())
			return true;
		return false;
	}
	
	/**
	 * Altera o saldo da conta de acordo com o valor dado
	 * @param valor
	 * 			Valor da transa��o
	 */
	@Override
	public void alteraSaldo(double valor) {
		double subtraiSaldo = super.getConta().getSaldo() - valor;
		super.getConta().setSaldo(subtraiSaldo);
	}

}
