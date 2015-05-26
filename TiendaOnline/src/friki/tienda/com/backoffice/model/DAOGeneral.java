package friki.tienda.com.backoffice.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOGeneral {

	protected static EntityManager init() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("FormacionMVC");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	/*
	 * Método público que recupera todos los objetos
	 * desde la Base de Datos
	 */
	protected List<Object> load(String consulta) {
		
		EntityManager em = init();

		EntityTransaction entr = em.getTransaction();
		entr.begin();
		Query query = em.createQuery(consulta);

		List<Object> results = query.getResultList();

		entr.commit();

		return results;
	}
	
}