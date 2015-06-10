package friki.tienda.com.tienda.accesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.ConnectionHelper;
import friki.tienda.com.daogenerico.GenericDAO;


import friki.tienda.com.daogenerico.IPersistent;

public class ArticuloDAO<K,T extends IPersistent<K>> extends GenericDAO<Integer, Articulo>{

	EntityManager manager;
	
	public List<T> findBySearch(final Class<T> clase, String query) {
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