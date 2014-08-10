package controleFinanceiro.model.transacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import controleFinanceiro.model.categoria.Categoria;
import controleFinanceiro.model.conta.Conta;

public abstract class Transacao {
	
	private DateFormat data;
	
	private double valor;
	
	private Categoria categoria;
	
	private Recorrencia recorrencia;
	
	private String descricao;
	
	private Conta conta;

	public Transacao(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta) {
		this.data = data;
		this.valor = valor;
		this.categoria = categoria;
		this.recorrencia = recorrencia;
		this.descricao = descricao;
		this.conta = conta;
	}

	public DateFormat getData() {
		return data;
	}

	public void setData(DateFormat data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public boolean setValor(double valor) {
		this.valor = valor;
		return true;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Recorrencia getRecorrencia() {
		return recorrencia;
	}

	public boolean setRecorrencia(Recorrencia recorrencia) {
		this.recorrencia = recorrencia;
		return true;
	}

	public void setDescricao(String des) {
		descricao = des;
	}

	public String getDescricao() {
		return descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public abstract void alteraSaldo(double valor);

	@Override
	public String toString() {
		return "Data " + data + ", Valor " + valor + ", Categoria " + categoria
				+ ", Recorrencia " + recorrencia;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Transacao))
			return false;
		Transacao other = (Transacao) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	public void alteraSaldo() {
		// TODO Auto-generated method stub
	}

}
