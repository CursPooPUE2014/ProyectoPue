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
import friki.tienda.com.Persistencia.Usuariosadministrador;
import friki.tienda.com.daogenerico.GenericDAO;
import friki.tienda.com.daogenerico.IGenericDAO;

public class EditarAdministrador extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) {

		resp.setContentType("application/json");

		PrintWriter out;

		try {

			// Obtenemos json con lista categorias de la request (Viene de
			// LeeCategorias)

			JSONObject json = (JSONObject) req.getAttribute("json");

			out = resp.getWriter();

			// De aqui se reciben los nuevos campos de la categoria desde un
			// formulario.

			IGenericDAO<Integer, Usuariosadministrador> adminDao = new GenericDAO<Integer, Usuariosadministrador>();

			Usuariosadministrador adminBean = (Usuariosadministrador) json.get("Usuariosadministrador");

			if (adminBean != null) {

				adminDao.update(adminBean);

				json.put("mens", "Administrador " + "id: "+adminBean.getIdUsuario()+" - email: "+adminBean.getEmail()
						+ " Editado Correctamente");

			} else {
				json.put("mens", "Error Editando Usuario!");
			}

			out.println(json);
			out.flush();

		} catch (IOException | JSONException e) {
		}
		return null;
	}
}
