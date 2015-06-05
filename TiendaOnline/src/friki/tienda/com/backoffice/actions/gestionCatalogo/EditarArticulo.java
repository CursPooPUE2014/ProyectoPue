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

public class EditarArticulo extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws JSONException {

		resp.setContentType("application/json");
		
		JSONObject json = (JSONObject) req.getAttribute("json");

		PrintWriter out;

		try {

			// Obtenemos json con lista categorias de la request (Viene de
			// LeeCategorias)

			out = resp.getWriter();

			// De aqui se reciben los nuevos campos de la categoria desde un
			// formulario.

			IGenericDAO<Integer, Articulo> artdao = new GenericDAO<Integer, Articulo>();

			Articulo art = (Articulo) json.get("articulo");

			artdao.update(art);

			json.put("error", "Articulo " + art.getNombre()
						+ "Editado Correctamente");

			out.println(json);
			out.flush();

		} catch (IOException | JSONException e) {
			
			json.put("error", "Error de JASON!!");
			
		}
		return null;
	}
}
