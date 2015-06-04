package friki.tienda.com.backoffice.actions.gestionCatalogo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.Persistencia.Categoria;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;
import friki.tienda.com.tienda.utilities.UtilitiesJSON;

public class LeerCategorias extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) {

		/*
		 * En esta clase se leen todas las categorías de la base de datos y se
		 * muestran en un desplegable. Al seleccionar una opción del desplegable
		 * se muestran los campos actuales para su edición. Incluye un botón
		 * "Editar" para mandar el formulario a la Action Editar Categoria, que
		 * guardará los cambios en la base de datos.
		 */

		JSONObject json = new JSONObject();

		List<Categoria> listaCategorias = new ArrayList<Categoria>();

		resp.setContentType("application/json");

		PrintWriter out = null;

		try {
			out = resp.getWriter();

			IGenericDAO<Integer, Categoria> catdao = new GenericDAO<Integer, Categoria>();

			listaCategorias = catdao.listAll(Categoria.class);

			if (listaCategorias != null) {

				json = UtilitiesJSON.jsonArrayGenerator(listaCategorias);

			} else {

				json.put("mens", "Error extrayendo lista de categorías");
			}

		} catch (IOException | JSONException e) {
		}

		finally {
			out.println(json);
			out.flush();
		}
		
		return null;
	}
}
