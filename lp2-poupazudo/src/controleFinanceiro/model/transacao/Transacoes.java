package controleFinanceiro.model.transacao;

import java.util.ArrayList;
import java.util.List;

public class Transacoes {
	private List<Transacao> transacoes;
	
	public Transacoes() {
		transacoes = new ArrayList<Transacao>();
	}
	
	public void addTransacao(Transacao tran) {
		transacoes.add(tran);
	}
	
	public boolean removerTransacao(Transacao tran) {
		for (Transacao trans : transacoes) {
			if (trans.equals(tran)) {
				transacoes.remove(trans);
				return true;
			}
		}
		
		return false;
	}

	public Transacao pesquisarTransacao(String desc) {
		for (Transacao trans : transacoes) {
			if (trans.getDescricao().equals(desc))
				return trans;
		}
		return null;
	}
}
