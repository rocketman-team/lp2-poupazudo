package controleFinanceiro.model.transacao;

import java.text.*;

import controleFinanceiro.model.categoria.Categoria;

public abstract class Transacao {
	private DateFormat data;
	private double valor;
	private Categoria categoria;
	private Recorrencia recorrencia;
	private String descricao;
	
	public Transacao(SimpleDateFormat data, double valor, Categoria categoria, Recorrencia recorrencia, String descricao) {
		this.data = data;
		this.valor = valor;
		this.categoria = categoria;
		this.recorrencia = recorrencia;
		this.descricao = descricao;
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

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getRecorrencia() {
		return recorrencia.getValor();
	}

	public void setRecorrencia(Recorrencia recorrencia) {
		this.recorrencia = recorrencia;
	}
	
	public void setDescricao(String des) {
		descricao = des;
	}
	
	public String getDescricao() {
		return descricao;
	}

@Override
	public String toString() {
		return "Data " + data + ", Valor " + valor + ", Categoria "
				+ categoria + ", Recorrencia " + recorrencia;
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
	if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
		return false;
	return true;
}
	
	
}
