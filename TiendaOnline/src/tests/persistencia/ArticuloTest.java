package tests.persistencia;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.ConnectionHelper;

public class ArticuloTest {

	static EntityManager em;
	Articulo articulo=null;
	
	@BeforeClass
	public static void setUp() throws Exception {
		

		em=ConnectionHelper.getInstance().getEntityManager();
		Articulo articulo=null;
    	String sql = "SELECT * FROM articulos " +
			"WHERE UPPER(nombre) LIKE ? " +	
			"ORDER BY nombre";
       Connection conn = ConnectionHelper.getInstance().getConnection();
           
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
       rs.next();
       articulo = new Articulo();
       	articulo.setIdArticulo(rs.getInt("id"));
       	articulo.setNombre(rs.getString("nombre"));
    }
	@Test
	public void testGetEntityManager() {
		assert(ConnectionHelper.getInstance().getEntityManager()!=null);
	}
	@Test
	public void testArticulo() {
		 Articulo articulo2=null;
	    	String sql = "SELECT * FROM articulos " +
				"WHERE UPPER(nombre) LIKE ? " +	
				"ORDER BY nombre";
	        try (Connection conn = ConnectionHelper.getInstance().getConnection()){
	           
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ResultSet rs = ps.executeQuery();
	           rs.next();
	           articulo2 = new Articulo();
		       	articulo2.setIdArticulo(rs.getInt("id"));
		       	articulo2.setNombre(rs.getString("nombre"));
	         
	        } catch (SQLException e) {
	        	fail("SQLException: "+ e.getMessage()); // TODO
	          
			}
	        assert(articulo2!=null);
		
	}

	@Test
	public void testGetIdArticulo() {
		assert( articulo.getIdArticulo()>0);
	}
	
	@Test
	public void testGetNombre() {
		assertFalse( articulo.getNombre()!=null && articulo.getNombre().isEmpty());
	}


	@Test
	public void testSetIdArticulo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCategoria() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetCategoria() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDescripcion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetDescripcion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetImagen() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetImagen() {
		fail("Not yet implemented"); // TODO
	}


	@Test
	public void testSetNombre() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetPrecio() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetPrecio() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetStock() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetStock() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTipoDeProducto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetTipoDeProducto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetLineaspedidos() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetLineaspedidos() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddLineaspedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveLineaspedido() {
		fail("Not yet implemented"); // TODO
	}

}
