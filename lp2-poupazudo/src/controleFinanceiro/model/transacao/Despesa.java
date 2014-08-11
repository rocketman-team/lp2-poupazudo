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
	public Despesa(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta, int repeticao, boolean fixo) {
		super(data, valor, categoria, recorrencia, descricao, conta, repeticao, fixo);
	}

	@Override
	public boolean setValor(double valor) {
		if (valor <= super.getConta().getSaldo()) {
			super.setValor(valor);
			alteraSaldo(valor);
			return true;
		}
		return false;
	}

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
	 * 			Valor da transação
	 */
	@Override
	public void alteraSaldo(double valor) {
		double subtraiSaldo = super.getConta().getSaldo() - valor;
		super.getConta().setSaldo(subtraiSaldo);
	}

}
