package friki.tienda.com.tienda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.ConnectionHelper;



public class TiendaPersistencia {
	private ConnectionHelper miConnectionHelper;
	
	
	public TiendaPersistencia(){
		super();
		miConnectionHelper=ConnectionHelper.getInstance();
	}
		
	public List<Articulo> findAll(){
		 List<Articulo> lista = new ArrayList<Articulo>();
	      
    	String sql = "SELECT * FROM articulos " +
			"WHERE UPPER(nombre) LIKE ? " +	
			"ORDER BY nombre";
        try (Connection conn = miConnectionHelper.getConnection()){
           
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
	public Articulo findById(int idArticulo){
		
		return null;
	}
	
    protected Articulo processRow(ResultSet rs) throws SQLException {
    	Articulo articulo = new Articulo();
    	articulo.setIdArticulo(rs.getInt("id"));
    	articulo.setNombre(rs.getString("nombre"));
    	
        return articulo;
    }

	
	
	
}
