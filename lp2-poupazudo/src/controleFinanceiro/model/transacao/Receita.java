package controleFinanceiro.model.transacao;

import java.text.SimpleDateFormat;

import controleFinanceiro.model.Conta;
import controleFinanceiro.model.categoria.Categoria;

public class Receita extends Transacao {

	public Receita(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta) {
		super(data, valor, categoria, recorrencia, descricao, conta);
	}

	@Override
	public void alteraSaldo(double valor) {
		double somaSaldo = super.getConta().getSaldo() + valor;
		super.getConta().setSaldo(somaSaldo);

	}

}
