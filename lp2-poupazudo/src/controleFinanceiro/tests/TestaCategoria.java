package controleFinanceiro.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controleFinanceiro.model.categoria.Categoria;

public class TestaCategoria {
	Categoria cat;
	
	@Before
	public void criaCategoria() {
		cat = new Categoria("Biscoito", new int[] {100, 100, 100});
	}
	
	@Test
	public void testaGet() {
		assertEquals("Biscoito", cat.getNome());
		assertEquals(new int[] {100, 100, 100}, cat.getCor());
	}
	
	@Test
	public void testaSet() {
		cat.setCor(new int[] {0, 0, 0});
		assertEquals(new int[] {0, 0, 0}, cat.getCor());
		
		cat.setNome("Negresco");
		assertEquals("Negresco", cat.getNome());
	}
	
	@Test
	public void testaEquals() {
		Categoria outro = new Categoria("Pastel", new int[] {10, 60, 20});
		Categoria outro2 = new Categoria("Negresco", new int[] {0, 0, 0});
		
		assertTrue(cat.equals(outro2));
		assertFalse(cat.equals(outro));
	}
	
	@Test
	public void TestaToString() {
		assertEquals("Nome Biscoito, Cor [100, 100, 100]", cat.toString());
	}
}
