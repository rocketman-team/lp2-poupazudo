package controleFinanceiro.model.categoria;

import java.util.*;
/**
 * Classe que representa uma coleçao de transaçoes
 * @version 1.2 10 de agosto
 * @author team
 *
 */
public class Categorias {
	private List<Categoria> categorias;
/**
 * Cria nova lista de categorias	
 */
	public Categorias() {
		categorias = new ArrayList<Categoria>();
	}
/**
 * Retorna a lista de categorias
 * @return categoria
 * 		Lista de categorias
 */
	public List<Categoria> getCategorias() {
		return categorias;
	}
/**
 * Adiciona nova categoria
 * @param cat
 * 		Categoria
 * @throws Exception
 * 		Tipo diferente do esperado
 */
	public void addCategoria(Categoria cat) throws Exception {
		if (cat instanceof Categoria) 
			categorias.add(cat);
		else {
			Exception e = new Exception("Tipo diferente do esperado");
			throw e;
		}
	}
/**
 * Remove categoria da lista
 * @param nome
 * 		Parametro nome
 * @throws Exception
 * 		Coleçao ainda vazia
 */
	
	public void removeCategoria(String nome) throws Exception {
		categorias.remove(pesquisaCategoria(nome));
	}
/**
 * Pesquisa uma categoria da lista
 * @param nome
 * 		Parametro nome de uma categoria
 * @return Categoria
 * 		Categoria encontrada
 * @return null
 * 		Categoria nao encontrada
 * @throws Exception
 * 		Coleçao ainda vazia
 */
	
	public Categoria pesquisaCategoria(String nome) throws Exception {
		if (categorias != null) {
			for (Categoria cat : categorias) {
				if (cat.getNome().equals(nome))
					return cat;
			}
			return null;
		}
		else {
			Exception e = new Exception("Coleçao vazia");
			throw e;
		}
	}

}