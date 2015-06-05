package friki.tienda.com.backoffice.actions.gestionCatalogo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONException;
import org.json.JSONObject;

import friki.tienda.com.Persistencia.Articulo;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class BuscarArticulo extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws JSONException {

		JSONObject json = new JSONObject();

		resp.setContentType("application/json");

		PrintWriter out = null;

		try {
			out = resp.getWriter();

			Articulo art = (Articulo) form;

			IGenericDAO<Integer, Articulo> artdao = new GenericDAO<Integer, Articulo>();

			art = artdao.findByKey(art, Integer.class);
			
			if (art != null) {

				json.put("articulo", art);

			} else {
				json.put("error", "Error Editando Artículo!");
			}
		
		} catch (IOException | JSONException e) {

			json.put("error", "Error! Artículo NO Encontrado");
		}
		
		finally {
			
			out.println(json);
			out.flush();
			
		}

		return null;

	}
}
