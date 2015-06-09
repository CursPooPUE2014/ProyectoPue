package friki.tienda.com.tienda.beans;

import java.util.List;

import org.apache.struts.action.ActionForm;

import friki.tienda.com.Persistencia.Articulo;




public class SearchTiendaBean extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private String cadena;
	
	public SearchTiendaBean(String cadena) {
		this.cadena = cadena;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public List<Articulo> getResults(String cadena) {
		StringBuilder query = new StringBuilder();
		query.append("Select a.nombre, a.descripcion,");
		query.append(" a.id_categoria, a.id_tipoProducto,");
		query.append(" c.nombre, t.nombre");
		query.append(" from articulo a");
		query.append(" nner join categoria c");
		query.append(" on (c.id_categoria = a.id_categoria)");
		query.append(" inner join tipoproducto t");
		
		query.append(" on (t.id_tipoProducto = a.id_tipoProducto)");
		query.append(" where 1=1 ");
				
		/*
		 * La búsqueda debe retornar aquellos artículos en cuyo nombre,
		 * descripcion, nombre de la categoria, o nombre del tipo coincida con alguno
		 * de las palabras incluidas en la cadena
		 * Se excluyen los articulos pronombres....
		 */
		
		// obtenemos la cláusula where de la consula que enviaremos
		String where = buildWhere(cadena);
		query.append(where);
		
		//#####################
		// pendiente llamar a la consulta
		
		return null;
	}		
	
	private String buildWhere(String cadena){
		StringBuilder where = new StringBuilder();
		where.append("where 1 = 1");
		
		String[] palabras = cadena.split(" ");
		
		for (String palabra: palabras){
			/*
			 * miramos si la palabra tiene al menos 3 letras 
			 * y la añadimos al where
			 */
		}
		
		return null;
	}
}
