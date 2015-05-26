package tests.persistencia;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;











import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.ConnectionHelper;

public class PersistenciaTest {
	 private static EntityManagerFactory factory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		String sql = "SELECT * FROM articulos ";
		Connection conn = ConnectionHelper.getInstance().getConnection();
		
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			 
			 List<Articulo> lista = new ArrayList<Articulo>();
		   
		    while (rs.next()) {
	            lista.add(processRow(rs));
		    }
		    
		    for (Articulo articulo : lista) {
		      System.out.println(articulo.toString());
		    }
		    System.out.println("Size: " + lista.size());
		} catch (SQLException e) {
			fail("SQLException: "+ e.getMessage()); // TODO
		}
		
	    assert(true);
	}
	protected Articulo processRow(ResultSet rs) throws SQLException {
    	Articulo articulo = new Articulo();
    	articulo.setIdArticulo(rs.getInt("id_articulo"));
    	articulo.setNombre(rs.getString("nombre"));
    	
        return articulo;
    }
	

}
