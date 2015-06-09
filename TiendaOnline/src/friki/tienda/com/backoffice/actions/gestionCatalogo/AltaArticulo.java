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

public class AltaArticulo extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws JSONException {

		System.out.println("Llego");

		JSONObject json = new JSONObject();

		resp.setContentType("application/json");

		PrintWriter out = null;

		try {
			
			out = resp.getWriter();

			Articulo art = (Articulo) form;

			IGenericDAO<Integer, Articulo> artdao = new GenericDAO<Integer, Articulo>();

			artdao.save(art);

			json.put("error", "Artículo añadido con ID: " + art.getIdArticulo());

		} catch (IOException | JSONException e) {

			json.put("error", "Error! Artículo NO añadido");
		}

		finally {

			out.println(json);
			out.flush();

		}

		return null;

	}
}
