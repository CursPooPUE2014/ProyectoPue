package friki.tienda.com.backoffice.actions.gestionAdmin;

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
import friki.tienda.com.Persistencia.UsuarioAdministrador;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class EliminarAdministrador extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setContentType("application/json");
		PrintWriter out = null;

		try {

			// Obtenemos json con lista categorias de la request (Viene de
			// LeeCategorias)

			JSONObject json = (JSONObject) req.getAttribute("json");

			out = resp.getWriter();

			// De aqui se reciben los nuevos campos de la categoria desde un
			// formulario.

			IGenericDAO<Integer, UsuarioAdministrador> adminDao = new GenericDAO<Integer, UsuarioAdministrador>();

			UsuarioAdministrador adminBean = (UsuarioAdministrador) json.get("UsuarioAdministrador");

			if (adminBean != null) {
				adminDao.delete(adminBean);
				json.put("mens", "Usuario eliminando correctamente!");
				
			} else {
				json.put("mens", "Error Eliminando Usuario!");
			}

			out.println(json);
			out.flush();

		} catch (IOException | JSONException e) {
		}
		return null;
	}
}
