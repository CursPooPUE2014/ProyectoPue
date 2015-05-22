package friki.tienda.com.backoffice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friki.tienda.com.Persistencia.Usuarioscliente;
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

	public Articulo findById(int idUsuariocliente) {

		return null;
	}

	protected Usuarioscliente processRow(ResultSet rs) throws SQLException {
		Usuarioscliente uCliente = new Usuarioscliente();
		uCliente.setIdUsuario(rs.getInt("id_usuario"));
		uCliente.setNombre(rs.getString("nombre"));
		return uCliente;
	}
	
	
	

	public void listarArticulos(Articulo art) {

	}

	public void listarUsuarios(Articulo art) {

	}

	public void anyadirArticulo() {

	}

	public void stockArticulo() {

	}

	public void eliminarArticulo() {

	}

	public void informeStock() {

	}

}
