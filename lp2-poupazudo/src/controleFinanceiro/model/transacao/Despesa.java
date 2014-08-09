package controleFinanceiro.model.transacao;

import java.text.SimpleDateFormat;

import controleFinanceiro.model.categoria.Categoria;

public class Despesa extends Transacao {
	
	public Despesa(SimpleDateFormat data, double valor, Categoria categoria, Recorrencia recorrencia, String descricao) {
		super(data, valor, categoria, recorrencia, descricao);
		
	}

}
