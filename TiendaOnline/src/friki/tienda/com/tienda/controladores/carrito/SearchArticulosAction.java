package friki.tienda.com.tienda.controladores.carrito;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.UsuarioCliente;
import friki.tienda.com.tienda.accesDAO.ArticuloDAO;
import friki.tienda.com.tienda.accesDAO.ClienteDAO;

public class SearchArticulosAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception {
		// establecemos tipo de respuesta json
		response.setContentType("application/json");
		
		// creamos el json a retornar
		JSONObject js = new JSONObject();
		
		// recuperamos los términos de búsqueda de la request
		String cadena = request.getParameter("cadena");
		
		// si la cadena es nula enviamos msg error
		if(cadena == "" || cadena == null){
			js.put("errores","Introduzca los términos de búsqueda");
		} else {
			
			/*
				llamamos a la función que hace la consulta
				a la BD y que debe retornarnos una lista de Articulos 
			 */
			List<Articulo> resultados = getResults("cadena");
			
			if(resultados == null){
				String err = "No se obtuvieron resultados para"
						+ "\"" + cadena + "\"";
				js.put("errores",err);
			} else {
				js.put("errores","");
				js.put("listaArticulos",resultados);
			}
		}
			 
		PrintWriter pw = response.getWriter();
		pw.write(js.toString());
		pw.flush();
		pw.close();

		return null;
		
	}
	
	public List<Articulo> getResults(String cadena) {
		String query = buildQuerySearch(cadena);
		
		ArticuloDAO<Integer, Articulo> dao =  new ArticuloDAO<Integer, Articulo>();
		List<Articulo> lista = null;
		
		lista = dao.findBySearch(Articulo.class, query);
		
		return lista;
	}		
	
	private String buildQuerySearch(String cadena){
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
