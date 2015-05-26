package friki.tienda.com.backoffice.model;

import friki.tienda.com.Persistencia.Usuariosadministrador;

import java.util.List;

import javax.persistence.EntityManager;

public class DAOUsuariosadministrador extends DAOGeneral implements DAOInterfaz {
	
	public List<Object> load(String consulta) {
		return super.load(consulta);		
	}

	// Método público que hace persistente
	// al alumno actual
	public boolean save(int idAlumno, String dummy) {
		return false;
	}
	
	//Sobrecarga para ajustarnos a los parámetros de Usuariosadministrador
		public boolean save(int idUsuario, String email, String contrasenya, String rol) {
			
			boolean retorno=false;
			
			EntityManager em = init();

			em.getTransaction().begin();
			
			// Comprobar si el curso ya existe
			Usuariosadministrador existe_instancia=em.find(Usuariosadministrador.class, idUsuario);
			
			// Si no existe lo damos de alta 
			if (existe_instancia==null) {
				
				Usuariosadministrador user = new Usuariosadministrador();
				user.setIdUsuario(idUsuario);			
				user.setEmail(email);
				user.setContrasenya(contrasenya);
				user.setRol(rol);
				
				em.persist(user);
				em.flush();
				retorno=true;
				
			}
			em.getTransaction().commit();
			return retorno;
		}


}