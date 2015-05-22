package tests.persistencia;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import friki.tienda.com.Persistencia.Articulo;

public class PersistenciaTest {
	 private static EntityManagerFactory factory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		factory = Persistence.createEntityManagerFactory("TiendaOnline");
		
		EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    Query q = em.createQuery("select * from articulos");
	    List<Articulo> lista = q.getResultList();
	    for (Articulo articulo : lista) {
	      System.out.println(articulo.toString());
	    }
	    System.out.println("Size: " + lista.size());

	    // create new todo
	    em.getTransaction().begin();
	    Articulo articulo = new Articulo();
	    
	    articulo.setNombre("prueba");
	    em.persist(articulo);
	    em.getTransaction().commit();

	    em.close();
	    assert(true);
	}

}
