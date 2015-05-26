package friki.tienda.com.backoffice.model;

import java.util.List;

public interface DAOInterfaz {

	public List<Object> load(String consulta);
	public boolean save(int id, String descripcion);
	
}
