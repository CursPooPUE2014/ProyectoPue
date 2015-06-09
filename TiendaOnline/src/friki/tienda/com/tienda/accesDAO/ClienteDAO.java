package friki.tienda.com.tienda.accesDAO;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

import friki.tienda.com.Persistencia.ConnectionHelper;
import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.daogenerico.GenericDAO;


import friki.tienda.com.daogenerico.IPersistent;

public class ClienteDAO<K,T extends IPersistent<K>> extends GenericDAO<Integer, UsuarioCliente>{

	EntityManager manager;
	
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
	
	public List<T> findByEmail(final Class<T> clase, String email) {
		String query="SELECT * FROM " + clase.getSimpleName() + "WHERE email =\"" 
	    + email ;
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

	private void load(){		
		manager = ConnectionHelper.getInstance().getEntityManager();		
	}
	
}