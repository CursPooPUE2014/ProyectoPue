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
				.createEntityManagerFactory("TiendaOnline");
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
	
	
}