package controleFinanceiro.model.categoria;

public enum Categoria {

	ALIMENTACAO(1), EDUCACAO(2), LAZER(3), MORADIA(4), PAGAMENTOS(5), 
	TRANSPORTE(6), ROUPA(7), SAUDE(8), ALUGUEL(9);

	public int tipo;

	Categoria(int value) {
		tipo = value;
	}

}
