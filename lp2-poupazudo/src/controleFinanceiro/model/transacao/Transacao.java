package controleFinanceiro.model.transacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import controleFinanceiro.model.categoria.Categoria;
import controleFinanceiro.model.conta.Conta;

/**
 * 
 * @author rocketman team : Daniel Bezerra, Hebert Morais, Helisson Nascimento, Jeferson Ferreira
 * 
 * Classe que representa uma transa��o
 */
public abstract class Transacao {

	private Calendar calendario;

	private DateFormat data;

	private double valor;

	private Categoria categoria;

	private Recorrencia recorrencia;

	private String descricao;

	private Conta conta;

	private int repeticao;

	protected int ocorrencias;

	private int dia_semana;

	private int dia_mes;

	
	private boolean fixo;
	
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
	
	public Transacao(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta, int repeticao, boolean fixo) {
		this.data = data;
		this.valor = valor;
		this.categoria = categoria;
		this.recorrencia = recorrencia;
		this.descricao = descricao;
		this.conta = conta;
		this.repeticao = repeticao;
		this.fixo = fixo;

		ocorrencias = repeticao * recorrencia.getValor();
		calendario = data.getCalendar();
		dia_semana = calendario.get(Calendar.DAY_OF_WEEK);
		dia_mes = calendario.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 
	 * @return  quantidade de repeti��es
	 */
	public int getRepeticao() {
		return repeticao;
	}

	/**
	 * Ajusta o numero de repeti��es de ocorrencias
	 * @param repeticao
	 */
	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}

	/**
	 * 
	 * @return  data de inser��o
	 */
	public DateFormat getData() {
		return data;
	}

	/**
	 * Ajusta a data
	 * @param data
	 */
	public void setData(DateFormat data) {
		this.data = data;
	}

	/**
	 * 
	 * @return  valor da transacao
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * 
	 * @param valor
	 * @throws Exeception
	 * 		Caso o parametro inserido seja negativo.
	 */
	public void setValor(double valor) throws Exception {
		if( valor < 0){
			throw new Exception("O valor da transaçao deve ser positivo");
		}
		else this.valor = valor;
	}

	/**
	 * 
	 * @return categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Ajusta a categoria
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * 
	 * @return recorrencia
	 */
	public Recorrencia getRecorrencia() {
		return recorrencia;
	}

	/**
	 * Ajusta a recorrencia
	 * @param recorrencia
	 * @return
	 */
	public boolean setRecorrencia(Recorrencia recorrencia) {
		this.recorrencia = recorrencia;
		return true;
	}

	/**
	 * Ajusta a descricao
	 * @param des
	 */
	public void setDescricao(String des) {
		descricao = des;
	}

	/**
	 * 
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 *  
	 * @return conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * Ajusta a conta
	 * @param conta
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/**
	 * Metodo para alterar o valor da transacao
	 * Metodo abstrato para ser usado pelas subclasses Receita e Despesa
	 * @param valor
	 */
	public abstract void alteraSaldo(double valor);

	/**
	 * Atualiza a transa��o, verificando o dia da semana e o dia do mes
	 */
	public void atualizaTransacao() {
		Calendar calendarioAtual = Calendar.getInstance();
		if (getRecorrencia().getValor() == 0)
			alteraSaldo(valor);

		else {
			if (fixo){
				switch ( getRecorrencia().getValor()){
				case 4:
					if (calendarioAtual.get(Calendar.DAY_OF_WEEK) == dia_semana)
						alteraSaldo(valor);


				case 1:
					if (calendarioAtual.get(Calendar.DAY_OF_MONTH) == dia_mes)
						alteraSaldo(valor);		
				}
			}

			else {
				switch ( getRecorrencia().getValor()){
				case 4:
					if (calendarioAtual.get(Calendar.DAY_OF_WEEK) == dia_semana)
						if (ocorrencias > 0){
							alteraSaldo(valor);
							ocorrencias --;
						}

				case 1:
					if (calendarioAtual.get(Calendar.DAY_OF_MONTH) == dia_mes)
						if (ocorrencias > 0){
							alteraSaldo(valor);
							ocorrencias --;
						}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Transacao [data=" + data + ", valor=" + valor + ", categoria="
				+ categoria + ", recorrencia=" + recorrencia + ", descricao="
				+ descricao + ", conta=" + conta + ", repeticao=" + repeticao
				+ "]";
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

}
