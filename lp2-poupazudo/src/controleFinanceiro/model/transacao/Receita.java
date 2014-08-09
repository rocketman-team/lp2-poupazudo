package controleFinanceiro.model.transacao;

import java.text.SimpleDateFormat;

import controleFinanceiro.model.categoria.Categoria;

public class Receita extends Transacao {
	
	public Receita(SimpleDateFormat data, double valor, Categoria categoria, Recorrencia recorrencia, String descricao) {
		super(data, valor, categoria, recorrencia, descricao);	
	}
	
}
