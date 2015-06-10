package friki.tienda.com.tienda.operaciones;

import java.util.List;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.tienda.accesDAO.ArticuloDAO;

public class ArticuloOperacionesSearch {
	
	public static List<Articulo> getResults(String cadena) {
		String query = buildQuerySearch(cadena);
		
		ArticuloDAO<Integer, Articulo> dao =  new ArticuloDAO<Integer, Articulo>();
		List<Articulo> lista = null;
		
		lista = dao.findBySearch(Articulo.class, query);
		
		return lista;
	}		
	
	private static String buildQuerySearch(String cadena){
		/*
		 * La búsqueda debe retornar aquellos artículos en cuyo nombre,
		 * descripcion, nombre de la categoria, o nombre del tipo coincida con alguno
		 * de las palabras incluidas en la cadena
		 * Se excluyen los articulos pronombres ( solo mayores de 2 letras)....
		 */
		StringBuilder query = new StringBuilder();
		query.append("SELECT a.nombre, a.descripcion,");
		query.append(" a.id_categoria, a.id_tipoProducto,");
		query.append(" c.nombre, t.nombre");
		query.append(" FROM articulo a");
		query.append(" INNER JOIN categoria c");
		query.append(" ON (c.id_categoria = a.id_categoria)");
		query.append(" INNER JOIN tipoproducto t");		
		query.append(" ON (t.id_tipoProducto = a.id_tipoProducto)");
		
		StringBuilder where = new StringBuilder();
		where.append("where 1 = 1");
		
		String[] palabras = cadena.split(" ");
		
		for (String palabra: palabras){
			// intentamos evitar artículos
			if(palabra.length() > 2){
				// buscamos en los campos tipo texto
				// de todas las tablas implicadas
				where.append(" OR a.nombre like ").append(palabra);
				where.append(" OR c.nombre like ").append(palabra);
				where.append(" OR t.nombre like ").append(palabra);
			}
		}
		
		query.append(where);
		
		return query.toString();
	}

}
