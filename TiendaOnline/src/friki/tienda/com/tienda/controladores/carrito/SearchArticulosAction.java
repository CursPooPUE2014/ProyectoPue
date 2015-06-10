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
import friki.tienda.com.tienda.operaciones.ArticuloOperacionesSearch;

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
			List<Articulo> resultados = ArticuloOperacionesSearch.getResults("cadena");
			
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
	
	
}
