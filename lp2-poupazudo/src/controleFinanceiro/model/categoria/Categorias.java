package controleFinanceiro.model.categoria;

import java.util.*;

public class Categorias {
	private List<Categoria> categorias;
	
	public Categorias() {
		categorias = new ArrayList<Categoria>();
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void addCategoria(Categoria cat) throws Exception {
		if (cat instanceof Categoria) 
			categorias.add(cat);
		else {
			Exception e = new Exception("Tipo diferente do esperado");
			throw e;
		}
	}
	
	public void removeCategoria(String nome) throws Exception {
		categorias.remove(pesquisaCategoria(nome));
	}
	
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
