package controleFinanceiro.model.categoria;

import java.util.Arrays;
/**
 * Classe que representa uma categoria de transaçao
 * @version 1.0 8 de agosto
 * @author team
 *
 */
public class Categoria {
/**
 * 	
 */
	private String nome;
	private int[] cor;
/**
 * Cria uma nova categoria
 * @param nome
 * 		Nome da categoria
 * @param cor
 * 		Cor da categoria
 */
	public Categoria(String nome, int[] cor) {
		this.nome = nome;
		this.cor = cor;
	}
/**
 * Retorna o nome da categoria
 * @return nome
 * 		Nome da categoria
 */

	public String getNome() {
		return nome;
	}
/**
 * Seleciona novo nome para acategoria
 * @param nome
 * 		Nome para a categoria
 */

	public void setNome(String nome) {
		this.nome = nome;
	}
/**
 * Retorna a cor da categoria
 * @return cor
 * 		Cor da categoria
 */

	public int[] getCor() {
		return cor;
	}
/**
 * Seleciona nova cor para a categoria
 * @param cor
 * 		Cor para a categoria
 */

	public void setCor(int[] cor) {
		this.cor = cor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria) obj;
		if (!Arrays.equals(cor, other.cor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome " + nome + ", Cor " + Arrays.toString(cor);
	}
}