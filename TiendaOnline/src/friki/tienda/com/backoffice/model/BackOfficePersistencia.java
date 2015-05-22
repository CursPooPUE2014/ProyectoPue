package friki.tienda.com.backoffice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friki.tienda.com.Persistencia.Usuarioscliente;
import friki.tienda.com.Persistencia.Usuariosadministrador;
import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.ConnectionHelper;

public class BackOfficePersistencia {

	private ConnectionHelper miConnectionHelper;

	public BackOfficePersistencia() {
		miConnectionHelper = ConnectionHelper.getInstance();
	}

	// LISTAR USUARIOS CLIENTE
	public List<Usuarioscliente> findAll() {
		List<Usuarioscliente> lista = new ArrayList<Usuarioscliente>();

		String sql = "SELECT * FROM Usuarioscliente "
				+ "WHERE UPPER(nombre) LIKE ? " + "ORDER BY nombre";
		try (Connection conn = miConnectionHelper.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lista;

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

	// CREAR USUARIO CLIENTE
	public Usuarioscliente create(Usuarioscliente uCliente) {       
        PreparedStatement ps = null;
        final String qry = "INSERT INTO Usuarioscliente (nombre, contrasenya, dir_postal, email, telefono) " 
        		+ "VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = miConnectionHelper.getConnection()){
                        
			ps = conn.prepareStatement(qry , new String[] { "ID" });
            ps.setString(1, uCliente.getNombre());
            ps.setString(2, uCliente.getContrasenya());
            ps.setString(3, uCliente.getDirPostal());
            ps.setString(4, uCliente.getEmail());
            ps.setInt(5, uCliente.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Actualizar el id del objeto que se devuelve. Esto es importante 
            // ya que este valor debe ser devuelto al cliente.
            int id = rs.getInt(1);
            uCliente.setIdUsuario(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} 
        return uCliente;
    }
	
	
	// LISTAR USUARIOS ADMINISTRADOR
		public List<Usuariosadministrador> findAlluAdmin() {
			List<Usuariosadministrador> lista = new ArrayList<Usuariosadministrador>();

			String sql = "SELECT * FROM Usuariosadministrador "
					+ "WHERE UPPER(email) LIKE ? " + "ORDER BY email";
			try (Connection conn = miConnectionHelper.getConnection()) {

				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					lista.add(processRowuAdmin(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return lista;

		}

		public Usuariosadministrador findByIduADmin(int id) {

			String sql ="SELECT * FROM Usuariosadministrador WHERE id = ?";
			Usuariosadministrador uAdmin = null;			
			try(Connection conn = miConnectionHelper.getConnection()){
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, id);
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		                uAdmin = processRowuAdmin(rs);
		            }
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return uAdmin;
		}

		protected Usuariosadministrador processRowuAdmin(ResultSet rs) throws SQLException {
			Usuariosadministrador uAdmin = new Usuariosadministrador();
			uAdmin.setIdUsuario(rs.getInt("id_usuario"));
			uAdmin.setEmail(rs.getString("email"));
			return uAdmin;
		}

	
		// CREAR USUARIO ADMINISTRADOR
		public Usuariosadministrador create(Usuariosadministrador uAdmin) {       
	        PreparedStatement ps = null;
	        final String qry = "INSERT INTO Usuariosadministrador (email, contrasenya, rol) " 
	        		+ "VALUES (?, ?, ?)";
	        try(Connection conn = miConnectionHelper.getConnection()){
	                        
				ps = conn.prepareStatement(qry , new String[] { "ID" });
	            ps.setString(1, uAdmin.getEmail());
	            ps.setString(2, uAdmin.getContrasenya());
	            ps.setString(3, uAdmin.getRol());
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            rs.next();
	            // Actualizar el id del objeto que se devuelve. Esto es importante 
	            // ya que este valor debe ser devuelto al cliente.
	            int id = rs.getInt(1);
	            uAdmin.setIdUsuario(id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} 
	        return uAdmin;
	    }
		


	public void stockArticulo() {

	}

	public void eliminarArticulo() {

	}

	public void informeStock() {

	}

}
