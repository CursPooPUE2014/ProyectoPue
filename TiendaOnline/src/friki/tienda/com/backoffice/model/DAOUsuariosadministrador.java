package friki.tienda.com.backoffice.model;

import friki.tienda.com.Persistencia.Usuarioscliente;
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
	
	//Sobrecarga para ajustarnos a los parámetros de Usuarioscliente
	public boolean save(int idUsuario, String nombre, String email, String contrasenya, String dirPostal, int telefono) {
		
		boolean retorno=false;
		
		EntityManager em = init();

		em.getTransaction().begin();
		
		// Comprobar si el curso ya existe
		Usuarioscliente existe_instancia=em.find(Usuarioscliente.class, idUsuario);
		
		// Si no existe lo damos de alta 
		if (existe_instancia==null) {
			
			Usuarioscliente user = new Usuarioscliente();
			user.setIdUsuario(idUsuario);		
			user.setNombre(nombre);
			user.setEmail(email);
			user.setContrasenya(contrasenya);
			user.setDirPostal(dirPostal);
			user.setTelefono(telefono);
			
			em.persist(user);
			em.flush();
			retorno=true;
			
		}
		em.getTransaction().commit();
		return retorno;
	}

}