package DAO;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
	private static DAO instancia;
	private EntityManager em;
	
	public static DAO getInstance(){
		if (instancia==null){ 
			instancia= new DAO();
		}
		
		return instancia;
	}
	
	private DAO(){
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("TiendaOnlineDAO");
			
			em = emf.createEntityManager();
	}
	public Connection getConnection(){
		 em.getTransaction().begin();
		 Connection connection = em.unwrap(Connection.class);
		 
		 em.getTransaction().commit();  
		 return connection;
	}
	public EntityManager getEntityManager(){
		return em;
	}
}
