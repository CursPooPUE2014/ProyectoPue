package friki.tienda.com.tienda.accesDAO;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import friki.tienda.com.Persistencia.ConnectionHelper;
import friki.tienda.com.Persistencia.Usuarioscliente;
import friki.tienda.com.daogenerico.GenericDAO;

//import friki.tienda.com.daogenerico.IGenericDAO;
import friki.tienda.com.daogenerico.IPersistent;

public class ClienteDAO<K,T extends IPersistent<K>> extends GenericDAO<Integer, Usuarioscliente>{

	EntityManager manager;
	
	private void load(){
		
		manager = ConnectionHelper.getInstance().getEntityManager();
		
	}
	/*
	private void close(){
		
		//manager.close();
		
	}
	*/

//	@Override
//	public List<T> listAll(Class<T> clase) {
//		String query="SELECT o FROM " + clase.getSimpleName() + " o";
//		load();
//		
//		
//		List<T> listaDeObjetos = null;
//		try {		
//			TypedQuery<T> consulta = manager.createQuery(query, clase);
//			listaDeObjetos = consulta.getResultList();
//			
//		} finally {
//			manager.close();
//		}		
//		return listaDeObjetos;
//	}
	
	public List<T> findByLogin(final Class<T> clase, String user, String pwd) {
		String query="SELECT * FROM " + clase.getSimpleName() + "WHERE email =\"" 
	    + user + "\" and contrasenya = \"" + pwd ;
		load();		
		List<T> listaDeObjetos = null;
		try {		
			TypedQuery<T> consulta = manager.createQuery(query, clase);
			listaDeObjetos = consulta.getResultList();
			
		} finally {
			manager.close();
		}		
		return listaDeObjetos;
	}
/*
	@SuppressWarnings("unchecked")
	public T findByKey(T object, Class<K> tipo) { 
		
		load();
		
		T objeto = null;
		try {
			
			objeto = (T) manager.find((Class<T>)object.getClass(), (K) object.getKey());
			
		} finally {
			close();
		}
		
		return objeto;
	}

	
	public T save(T object) {
		load();
		
		EntityTransaction tx = null;
		try {

			tx = manager.getTransaction();
			tx.begin();
			manager.persist(object);
			tx.commit();

		} catch (PersistenceException e) {

			tx.rollback();
			throw e;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			
		} finally {

			close();
		}
		return object;
	}

	
	public T update(T object) {
		load();
		
		EntityTransaction tx = null;
		try {

			tx = manager.getTransaction();
			tx.begin();
			manager.merge(object);
			tx.commit();

		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {

			close();
		}
		
		return object;
	}
*/	
	/*
	 * Propagation.REQUIRED indica que el método actual debe 
	 * ejecutarse dentro de una transacción. Si hay una 
	 * transacción en progreso, el método se ejecutará dentro
	 * de dicha transacción. Si no, se iniciará una nueva
	 */
/*	
	public boolean delete(T object) {
		load();
		
		EntityTransaction tx = null;
		try {

			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(object));
			tx.commit();
			return true;
		} catch (PersistenceException e) {

			tx.rollback();
			throw e;
			
		} finally {

			close();
		}	
	}
 */	
}