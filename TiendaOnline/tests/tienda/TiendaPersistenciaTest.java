package tienda;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.tienda.model.TiendaPersistencia;

public class TiendaPersistenciaTest {
	TiendaPersistencia tp;
	
	@Before
	public void setUp() throws Exception {
		tp = new TiendaPersistencia();
	}	

	@Test
	public void testTiendaPersistencia() {
		testFindAll();
		testFindById();
	}

	@Test
	public void testFindAll() {
		List<Articulo> lista = tp.findAll();
		assertTrue(lista!= null);
	}

	@Test
	public void testFindById() {
		Articulo art = tp.findById(1);
		assertTrue(art!= null);
	}

}
