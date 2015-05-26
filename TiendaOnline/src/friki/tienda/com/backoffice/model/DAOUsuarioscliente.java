package friki.tienda.com.backoffice.model;

import friki.tienda.com.Persistencia.Usuarioscliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class DAOUsuarioscliente extends DAOGeneral implements DAOInterfaz {
	
	//Métodos para obtener Usuarioscliente	
	public List<Object> load(String consulta) {
		return super.load(consulta);		
	}
/*	
	public List<Usuarioscliente> findAll() {
		//List<Usuarioscliente> lista = new ArrayList<Usuarioscliente>();

		String sql = "SELECT * FROM Usuarioscliente "
				+ "WHERE UPPER(nombre) LIKE ? " + "ORDER BY nombre";
		return (List<Usuarioscliente>) load(sql);		

	}

	public Usuarioscliente findById(int id) {

		String sql ="SELECT * FROM Usuarioscliente WHERE id = ?";
		Usuarioscliente uCliente = null;			
		try(Connection conn = miConnectionHelper.getConnection()){
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                uCliente = processRow(rs);
	            }
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	protected Usuarioscliente processRow(ResultSet rs) throws SQLException {
		Usuarioscliente uCliente = new Usuarioscliente();
		uCliente.setIdUsuario(rs.getInt("id_usuario"));
		uCliente.setNombre(rs.getString("nombre"));
		return uCliente;
	}
*/
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