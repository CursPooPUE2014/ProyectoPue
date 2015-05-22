package tests.persistencia;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import friki.tienda.com.Persistencia.ConnectionHelper;



public class ConnectionHelperTest {
	
	
	@Test
	public void testGetInstance() {
		assert(ConnectionHelper.getInstance()!=null);
	}

	@Test
	public void testGetConnection() {
		
		assert(ConnectionHelper.getInstance().getConnection()!=null);
	}

	@Test
	public void testGetEntityManager() {
		assert(ConnectionHelper.getInstance().getEntityManager()!=null);
	}
	
	@Test
	public void testEntityManager() {
		assert(ConnectionHelper.getInstance().getEntityManager().isJoinedToTransaction());
	}
	
	@Test
	public void createEntityManagerFactory() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("TiendaOnline");
		EntityManager em2;	
		em2 = emf.createEntityManager();
		
		assert(emf!=null);
	}
	

}
